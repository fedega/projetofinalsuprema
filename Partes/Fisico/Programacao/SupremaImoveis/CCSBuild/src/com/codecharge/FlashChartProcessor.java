//FlashChartProcessor class: head @0-B18A4059
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import java.util.*;
import java.text.*;
import org.w3c.dom.*;

public class FlashChartProcessor extends AbstractProcessor {

  private CCLogger logger = CCLogger.getInstance();
  private FlashChart model;

  public FlashChartProcessor(Element elm, Model model, Page page) {
    super(elm,model,page);
    this.model = (FlashChart)model;
  }

  public void process() {
    setActivePermissions( model );
    if ( ! model.isVisible() ) {
      return;
    }

    model.setQueryString(page);
    com.codecharge.components.Page parentPage = this.model.getRootPage(page);
    this.model.setSrc(parentPage.getRelativePath() + this.model.getSrc());
  }

}

//End FlashChartProcessor class: head

