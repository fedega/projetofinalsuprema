//CaptchaProcessor class: head @0-612D6593
package com.codecharge;

import com.codecharge.components.*;
import com.codecharge.events.*;
import com.codecharge.util.*;
import com.codecharge.db.*;
import java.util.*;
import java.text.*;
import org.w3c.dom.*;

public class CaptchaProcessor extends AbstractProcessor {

  private CCLogger logger = CCLogger.getInstance();
  private Captcha model;

  public CaptchaProcessor(Element elm, Model model, Page page) {
    super(elm,model,page);
    this.model = (Captcha)model;
  }

  public void process() {
  }

}

//End CaptchaProcessor class: head

