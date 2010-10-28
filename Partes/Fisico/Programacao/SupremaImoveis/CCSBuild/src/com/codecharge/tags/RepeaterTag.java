//RepeaterTag class @0-5B56B00C
package com.codecharge.tags;

import com.codecharge.components.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import com.codecharge.events.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

/**
  Repeatedly outputs rows of Grid data.
  <pre><b>&lt;repeater&gt;..&lt;/repeater&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>(No attributes)
    <dt><b>Parent elements:</b> <dd>{@link GridTag grid}
    <dt><b>Child elements:</b> <dd>{@link RowTag row}
  </dl>

  This tag is a simple iterator which for each record in Grid (records collection):
  <ul>
    <li>defines the name of the row in template which will be used to show this record,
    <li>binds data or in other words copies one record from records collection to DbRow which represents current row.
  </ul>
**/
public class RepeaterTag extends BodyTagSupport {

    private Grid grid;
    private Vector rowNames;
    public void addRowName(String name) {
        if (!rowNames.contains(name)) rowNames.add(name);
    }
    private void switchRow() {
        if (row < rowNames.size()) {
            row++;
        } else {
            row=1;
        }
    }

    private int row = 1; // Row we want to show, default "general";
    /** Name of the row in template to show in this iteration **/
    public String getRow() {
        if (rowNames.size() > 0) {
            return (String)rowNames.get(row-1);
        } else {
            return null;
        }
    }

    /** Current Grid record. **/
    public HashMap getRecord(){return grid.currentRow();}

    public int doStartTag() throws JspTagException {
      Object parent = pageContext.getAttribute("parent");
      if (parent != null) {
        if (parent instanceof Grid) grid = (Grid)parent;
      } else {
        throw new JspTagException("Repeater tag: wrong context, repeater should be a child of a grid tag");
      }
      rowNames = new Vector(); row = 1;
      grid.initializeRows();
        if (grid.hasNextRow() || grid.isForceIteration() ) {

          if (!grid.hasNextRow()) { 
            grid.setForceIteration(false);
            grid.setCurrentRowNumber ( grid.getCurrentRowNumber() + 1);
          } else {

            grid.nextRow();
            grid.setForceIteration(false);

            if (grid instanceof EditableGrid) {
                EditableGrid egrid = (EditableGrid)grid;
                if (egrid.isShowEmptyRow()) {
                    try {
                        Model delCtrl = egrid.getChild(egrid.getDeleteControlName());
                        delCtrl.setVisible(false);
                        Model panelModel = egrid.getChild(egrid.getDeleteControlName() + "_Panel");
                        if (panelModel!=null) {
                            if (panelModel instanceof Panel) ((Panel)panelModel).setVisible(false);
                        }
                    } catch (NoSuchComponentException ignore) {}
                }
            }
          }

          com.codecharge.util.ModelAttribute ma = ((com.codecharge.util.ModelAttribute)grid.getAttribute( "rowNumber" ));
          if (ma != null) ma.setValue( ""+(grid.getCurrentRowNumber()) );

          grid.fireBeforeShowRowEvent(new Event());
          return EVAL_BODY_TAG;
        } else {
          if (grid instanceof EditableGrid) {
            EditableGrid egrid = (EditableGrid)grid;
            if (!egrid.isProcessed() && egrid.isAllowInsert()) {
            if (egrid.getCurrentRowNumber() < egrid.getChildRows().size() + egrid.getNumberEmptyRows()) {
              row = 1;
              HashMap newrow = egrid.getEmptyRow();
              try {
                if (egrid.getDeleteControlName() != null) {
                    Model delCtrl = (Model)newrow.get(egrid.getDeleteControlName());
                    if (delCtrl != null) delCtrl.setVisible(false);

                    Model panelModel = egrid.getChild(egrid.getDeleteControlName() + "_Panel");
                    if (panelModel!=null) {
                        if (panelModel instanceof Panel) ((Panel)panelModel).setVisible(false);
                    }


                }
              } catch (NoSuchComponentException ignore) {}

              com.codecharge.util.ModelAttribute ma = ((com.codecharge.util.ModelAttribute)egrid.getAttribute( "rowNumber" ));
              if (ma != null) ma.setValue( ""+(egrid.getCurrentRowNumber()) );
              egrid.fireBeforeShowRowEvent(new Event());
              return EVAL_BODY_TAG;
            }
            }
          }
          grid.nullChildRow();
          return SKIP_BODY;
        }
    }

    public int doAfterBody() throws JspTagException {
        BodyContent body = getBodyContent();
        try {
          // write evaluation on the output Writer
          body.writeOut(getPreviousOut());
        } catch ( java.io.IOException ex) {
          throw new JspTagException("unexpected IO error");
        }

        // clear up so the next time we get here we are afresh.
        body.clearBody();

        if ( grid.hasNextRow() || grid.isForceIteration() ) {
          if (grid instanceof EditableGrid) {
            row = 1; // EditableGrid doesn't support alt rows
          } else {
            switchRow();
          }

          if (!grid.hasNextRow()) {
            grid.setForceIteration(false);
            grid.setCurrentRowNumber ( grid.getCurrentRowNumber() + 1);
          } else {

            grid.nextRow();
            grid.setForceIteration(false);

            if (grid instanceof EditableGrid) {

                EditableGrid egrid = (EditableGrid)grid;
                if (egrid.isShowEmptyRow()) {
                    try {
                        Model delCtrl = egrid.getChild(egrid.getDeleteControlName());
                        delCtrl.setVisible(false);
                        Model panelModel = egrid.getChild(egrid.getDeleteControlName() + "_Panel");
                        if (panelModel!=null) {
                            if (panelModel instanceof Panel) ((Panel)panelModel).setVisible(false);
                        }
                    } catch (NoSuchComponentException ignore) {}
                }
            }
          }


          com.codecharge.util.ModelAttribute ma = ((com.codecharge.util.ModelAttribute)grid.getAttribute( "rowNumber" ));
          if (ma != null) ma.setValue( ""+(grid.getCurrentRowNumber()) );
          grid.fireBeforeShowRowEvent(new Event());

          return EVAL_BODY_TAG;
        } else {
          if (grid instanceof EditableGrid) {
            EditableGrid egrid = (EditableGrid)grid;
            if (!egrid.isProcessed() && egrid.isAllowInsert()) {
            if (egrid.getCurrentRowNumber() < egrid.getChildRows().size() + egrid.getNumberEmptyRows()) {
              row = 1;
              HashMap newrow = egrid.getEmptyRow();
              try {
                if (egrid.getDeleteControlName() != null) {
                    Model delCtrl = (Model)newrow.get(egrid.getDeleteControlName());
                    if (delCtrl != null) delCtrl.setVisible(false);
                    Model panelModel = egrid.getChild(egrid.getDeleteControlName() + "_Panel");
                    if (panelModel!=null) {
                        if (panelModel instanceof Panel) ((Panel)panelModel).setVisible(false);
                    }
                }
              } catch (NoSuchComponentException ignore) {}

              com.codecharge.util.ModelAttribute ma = ((com.codecharge.util.ModelAttribute)egrid.getAttribute( "rowNumber" ));
              if (ma != null) ma.setValue( ""+(egrid.getCurrentRowNumber()) );
              egrid.fireBeforeShowRowEvent(new Event());
              return EVAL_BODY_TAG;
            }
            }
          }
          grid.nullChildRow();
          return SKIP_BODY;
        }
    }
}
//End RepeaterTag class

