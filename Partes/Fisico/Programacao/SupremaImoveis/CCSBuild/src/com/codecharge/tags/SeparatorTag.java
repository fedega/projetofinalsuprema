//SeparatorTag class @0-781C0518
package com.codecharge.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import com.codecharge.components.*;

/**
  Defines block to be shown after every record, but not after the last one.
  <pre><b>&lt;separator type=".."&gt;..&lt;/separator&gt;</b></pre>
  <dl>
    <dt><b>Attributes:</b><dd>{@link #setType type}
    <dt><b>Parent elements:</b> <dd>{@link com.codecharge.tags.GridTag grid}
    <dt><b>Child elements:</b> <dd>(No child elements)
  </dl>
**/
public class SeparatorTag extends TagSupport {

  private String type;
  public String getType() {return type;}
  public void setType(String type) {this.type = type;}

	public int doStartTag() {
    if ("category".equals(type)) {
      Directory dir = (Directory)pageContext.getAttribute("parent");
      CategoriesTag categories = (CategoriesTag)findAncestorWithClass(this, CategoriesTag.class);
      if (categories.getState().hasNext() &&
          !isNewColumn(dir.getCurrentCategoryNumber(),dir.getNumberOfCategories(),dir.getNumberOfColumns())) {
        return EVAL_BODY_INCLUDE;
      } else {
        return SKIP_BODY;
      }
    } else if ("subcategory".equals(type)) {
      SubcategoriesTag subcategories = (SubcategoriesTag)findAncestorWithClass(this, SubcategoriesTag.class);
      if (subcategories.getState().hasNext()) {
        return EVAL_BODY_INCLUDE;
      } else {
        return SKIP_BODY;
      }
    } else if ("column".equals(type)) {
      Directory dir = (Directory)pageContext.getAttribute("parent");
      CategoriesTag categories = (CategoriesTag)findAncestorWithClass(this, CategoriesTag.class);
      // No columns - quit
      if (dir.getNumberOfColumns() == 1) return SKIP_BODY;
      if (isNewColumn(dir.getCurrentCategoryNumber(),dir.getNumberOfCategories(),dir.getNumberOfColumns())
          && categories.getState().hasNext())
        return EVAL_BODY_INCLUDE;
      else return SKIP_BODY;
    } else {
      Grid grid = (Grid)pageContext.getAttribute("parent");
      if (grid.hasNextRow()) return EVAL_BODY_INCLUDE;
      else  return SKIP_BODY;
    }
	}
  protected boolean isNewColumn(long current, long catnum, long columns) {
    long number = 0;
    if ( columns <= 1 ) return false;
    double numberCatsInColumn = ((double) catnum)/((double) columns);
    number = (int) numberCatsInColumn;
    if ( numberCatsInColumn != number ) {
        number++;
    }
    return ( ((current) % number) == 0 );
  }
}
//End SeparatorTag class

