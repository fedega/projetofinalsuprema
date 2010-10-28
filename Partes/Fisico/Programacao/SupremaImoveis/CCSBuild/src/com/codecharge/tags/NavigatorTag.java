//NavigatorTag class @0-8692F14B
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/04 08:39:41 $
 */
package com.codecharge.tags;

import javax.servlet.jsp.tagext.TagSupport;

import com.codecharge.components.Model;
import com.codecharge.components.CalendarNavigator;
import com.codecharge.components.Calendar;
import com.codecharge.components.Navigable;
import com.codecharge.components.Navigator;
import com.codecharge.events.Event;

/**
  Defines Grid/Calendar Navigator (Pager).
  <pre><b>&lt;navigator name=".." type=".." size=".."&gt;..&lt;/navigator&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setName name}, {@link #setType type}, {@link #setSize size}
    <dt><b>Parent elements:</b> <dd>{@link GridTag grid}
    <dt><b>Child elements:</b> <dd>{@link FirstOnTag first_on}, {@link FirstOffTag first_off}, {@link PrevOnTag prev_on},
   {@link PrevOffTag prev_off}, {@link PagesTag pages}, {@link TotalPagesTag total_pages},
   {@link PageNumberTag page_number}, {@link NextOnTag netxt_on}, {@link NextOffTag next_off}, {@link LastOnTag last_on},
   {@link LastOffTag last_off}
  </dl>
**/
public class NavigatorTag extends TagSupport {

    private String name;
    /** Name of the Navigator as defined in XML model. * */
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    private int size = 10;
    /** Number of navigation pages. Defaults to 10. * */
    public void setSize(String size) {
        try {
            this.size = Integer.parseInt(size);
        } catch (NumberFormatException nfe) {
        }
    }

    private int type = Navigator.SIMPLE;
    /** Type of the Navigator: moving, centered, simple. Defaults to simple. * */
    public void setType(String type) {
        if ("moving".equalsIgnoreCase(type)) {
            this.type = Navigator.MOVING;
        } else if ("centered".equalsIgnoreCase(type)) {
            this.type = Navigator.CENTERED;
        }
    }

    private boolean next;
    /** If Grid has next page * */
    public boolean hasNext() {
        return next;
    }

    private boolean prev;
    /** If Grid has previous page * */
    public boolean hasPrev() {
        return prev;
    }

    private int pageNumber;
    /** Current page number * */
    public int getPageNumber() {
        return pageNumber;
    }

    private int lastPage;
    /** Number of pages in Grid * */
    public int getNumberOfPages() {
        return lastPage;
    }

    private int start;
    /** First page of the navigation pages * */
    public int getPageLinksStart() {
        return start;
    }

    private int end;
    /** Last page of the navigation pages * */
    public int getPageLinksEnd() {
        return end;
    }

    private boolean isCalendar;

    public int doStartTag() {
        Object parent = pageContext.getAttribute("parent");
        Model nav = null;
        if (parent instanceof Navigable) {
            nav = ((Navigable) parent).getNavigator(name);
        } else if (parent instanceof Calendar) {
            nav = ((Calendar) parent).getNavigator(name);
            this.isCalendar = true;
        }
        if (nav != null) {
            if (isCalendar) {
                ((CalendarNavigator) nav).fireBeforeShowEvent(new Event());
            } else {
                ((Navigator) nav).fireBeforeShowEvent(new Event());
            }
        } else {
            return SKIP_BODY;
        }
        pageContext.setAttribute("navigator", nav);
        if (parent instanceof Navigable && ! ((Navigable) parent).isNavigatorVisible()) {
            nav.setVisible(false);
        }
        if (!nav.isVisible()) {
            return SKIP_BODY;
        }

        if (parent instanceof Navigable) {
            lastPage = ((Navigable) parent).getTotalPages();
            pageNumber = ((Navigable) parent).getPageNumber();
            next = pageNumber < lastPage;
            prev = pageNumber > 1;
    
            switch (type) {
                case Navigator.SIMPLE :
                    start = pageNumber;
                    end = pageNumber;
                    break;
                case Navigator.CENTERED :
                    start = pageNumber - size / 2;
                    end = start + size - 1;
                    if (start < 1) {
                        start = 1;
                        end = size > lastPage ? lastPage : size;
                    }
                    if (end > lastPage) {
                        end = lastPage;
                        start = lastPage - size + 1 < 1 ? 1 : lastPage - size + 1;
                    }
                    break;
                case Navigator.MOVING :
                    start = ((pageNumber - 1) / size) * size + 1;
                    end = start + size - 1;
                    if (end > lastPage)
                        end = lastPage;
                    break;
                default :
                    start = 1;
                    end = 0;
            }
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() {
        pageContext.removeAttribute("navigator");
        if (isCalendar) {
            pageContext.removeAttribute("navigator_stored_get");
            pageContext.removeAttribute("navigator_form_action");
        }
        return EVAL_PAGE;
    }

}

//End NavigatorTag class

