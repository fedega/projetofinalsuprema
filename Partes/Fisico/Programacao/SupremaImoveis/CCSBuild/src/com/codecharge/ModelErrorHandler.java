//ModelErrorHandler class @0-3AAC0FA4
package com.codecharge;

import org.xml.sax.*;
import com.codecharge.util.CCLogger;

final public class ModelErrorHandler implements ErrorHandler {
    private CCLogger logger = CCLogger.getInstance();
    public void error(SAXParseException e) throws SAXException {
      logger.warn(e.getSystemId()+" at line "+e.getLineNumber()+" "+e);
      //throw new SAXException(e.getMessage());
    }
    public void warning(SAXParseException e) throws SAXException {
      throw new SAXException(e.getMessage());
    }
    public void fatalError(SAXParseException e) throws SAXException {
      throw new SAXException(e.getMessage());
    }
}
//End ModelErrorHandler class

