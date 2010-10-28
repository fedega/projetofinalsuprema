//CCSTemplate class @0-0DE11557
/*
 * $Revision: 1.3 $
 * $Date: 2005/02/18 14:22:58 $
 */
package com.codecharge.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import com.codecharge.ITemplate;
import com.codecharge.template.structure.ITemplateItem;
import com.codecharge.template.structure.TemplateVariable;
import com.codecharge.util.CCLogger;
import com.codecharge.util.StringUtils;


public class CCSTemplate implements ITemplate {

    final static public int IF_DOESNT_EXIST_DO_NOTHING = 1;
    final static public int IF_DOESNT_EXIST_IS_ERROR = 0;
    final static public int IF_DOESNT_EXIST_CRATE = 2;

    protected CCLogger logger;

    protected String encoding;
    protected Locale locale;
    
    protected Map blocks;
    protected Map variables;
    protected Map templateModel;
     
    protected ServletContext servletContext;
    protected ITemplateParser templateParser;
    protected ITemplateSource templateSource;

    public CCSTemplate() {
        logger = CCLogger.getInstance();
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    public void setTemplateParser(ITemplateParser templateParser) {
        this.templateParser = templateParser;
    }
    public void setTemplateSource(ITemplateSource templateSource) {
        this.templateSource = templateSource;
    }
    public void setTemplateModel(Map templateModel) {
        this.templateModel = templateModel;
    }
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
    public void load(String templateName) {
        if (StringUtils.isEmpty(templateName)) {
            throw new IllegalArgumentException("Unable to load template. Template name is null or empty.");
        }
        if (templateSource != null || templateParser != null) {
            templateSource.setEncoding(encoding);
            templateSource.setLocale(locale);
            if (servletContext != null) {
                templateSource.setServletContext(servletContext);
            }
            templateParser.setLocale(locale);
            this.templateModel = templateParser.parse(templateSource.getReader(templateName));
        } else {
            if (templateSource == null && templateParser == null) {
                throw new IllegalStateException("Unable to load template. TemplateSource and TemplatePaser are null.");
            } else if (templateSource == null) {
                throw new IllegalStateException("Unable to load template. TemplateSource is null.");
            } else if (templateParser == null) {
                throw new IllegalStateException("Unable to load template. TemplatePaser is null.");
            }
        }
    }
    
    /**
     * Sets Map with blocks to control blocks visibility.
     */
    public void setBlocks(Map blocks) {
        this.blocks = blocks;
    }

    /**
     * Sets Map with user variables that must be set in the template.
     */
    public void setVariables(Map variables) {
        this.variables = variables;
    }

    public void setVar(String name, String value, int mode) {
        //logger.debug("CCSTemplate.setVar(\"" + name + "\", \"" + value + "\", " + mode + ")");
        if (StringUtils.isEmpty(name)) {
            logger.error("call with null name => Template.setVar(\"" + name + "\", \"" + value
                    + "\", " + mode + ")");
            return;
        }
        List items = (List) templateModel.get("/" + name + "/*");

        if (items == null && mode == CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING) {
            return;
        }

        if (items == null && mode == CCSTemplate.IF_DOESNT_EXIST_CRATE) {
            items = new ArrayList();
            templateModel.put("/" + name + "/*", items);
        }

        if (items == null) {
            throw new NoSuchTemplateItemException("Variable '" + name + "' does not exist");
        }
        for (int i = 0; i < items.size(); i++) {
            ITemplateItem item = (ITemplateItem) items.get(i);
            item.setBody(new StringBuffer(value));
            item.setParsed(true);
        }

    }

    public void setTag(String pathTo, String tagName, String value, int mode) {
            //logger.debug("CCSTemplate.setTag(\"" + pathTo + ", \""
            //        + tagName + "\", \"" + value + "\", " + mode + ")");
        if (StringUtils.isEmpty(tagName)) {
            logger.error("call with null name => Template.setTag(\"" + pathTo + ", \""
                    + tagName + "\", \"" + value + "\", " + mode + ")");
            return;
        }
        List items = (List) templateModel.get("/" + tagName + "/*");
        if (items == null && mode == CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING)
            return;
        if (items == null) {
            throw new NoSuchTemplateItemException("Variable '" + tagName + "' does not exist");
        }
        for (int i = 0; i < items.size(); i++) {
            ITemplateItem item = (ITemplateItem) items.get(i);
            if (item.getPath().startsWith("/" + pathTo)) {
                item.setBody(new StringBuffer(value));
                item.setParsed(true);
            }
        }
    }

    public void setVar(String name) {
        setVar(name, "", CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING);
    }

    public void setTag(String pathTo, String varName) {
        setTag(pathTo, varName, "", CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING);
    }

    public void setVar(String name, String value) {
        setVar(name, value, CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING);
    }

    public void setTag(String pathTo, String varName, String value) {
        setTag(pathTo, varName, value, CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING);
    }

    public void setVar(String name, int mode) {
        setVar(name, "", mode);
    }

    public void setTag(String pathTo, String varName, int mode) {
        setTag(pathTo, varName, "", mode);
    }

    public String renderBlock(String pathTo, String blockName, boolean accumulate,
            String target, int mode) {
        if (StringUtils.isEmpty(blockName)) {
            logger.error("call with null name => Template.parseAndPrint(\"" + blockName
                    + "\", " + accumulate + ", \"" + target + "\", " + mode + ")");
            return "";
        }
        List items = (List) templateModel.get("/" + blockName + "/*");
        if (items == null) {
            if (mode == CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING) {
                return "";
            }
            throw new NoSuchTemplateItemException("Block '" + blockName + "' does not exist");
        }

        String body = "";
        for (int i = 0; i < items.size(); i++) {
            ITemplateItem item = (ITemplateItem) items.get(i);
            if (item.getPath().startsWith("/" + pathTo)) {
                body = parseAndPrint(item.getPath().substring(1, item.getPath().length()/* - 2*/),
                        accumulate, target, mode);
                item.setParsed(true);
            }
        }
        return body;
    }

    public String renderBlock(String blockName, boolean accumulate, String target, int mode) {
        return parseAndPrint(blockName, accumulate, target, mode);
    }

    // This method uses only for parsing update panel, because previos method always return empty string except "main" block   
    public String parseAndPrintForUpdatePanel(String blockName, boolean accumulate ) {
    	String target = null;
    	int mode = CCSTemplate.IF_DOESNT_EXIST_IS_ERROR;
    	if (StringUtils.isEmpty(blockName)) {
		    return "";
		}
		List items = (List) templateModel.get("/" + blockName + "/*");
		if (items == null) {
		    if (mode == CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING) {
		        return "";
		    } else {
		        throw new NoSuchTemplateItemException("Block '" + blockName + "' does not exist");
		    }
		}
		
		ITemplateItem item = (ITemplateItem) items.get(0);
		item.setAccumulate(accumulate);
		
		ITemplateItem pointTarget = null;
		if (target == null) {
		    pointTarget = item;
		    item.setTargetItem(null);
		} else {
		    List targets = (List) templateModel.get("/" + target + "/*");
		    if (targets == null) {
		        pointTarget = new TemplateVariable();
		        List trgs = new ArrayList();
		        trgs.add(pointTarget);
		        templateModel.put("/" + target + "/*", trgs);
		        item.setTargetItem(pointTarget);
		    } else {
		        pointTarget = (ITemplateItem) ((List) templateModel.get("/" + target + "/*")).get(0);
		        item.setTargetItem(pointTarget);
		    }
		}

		item.parse();
		pointTarget.setParsed(true);
	    return pointTarget.getBody().toString();
    }

    public String parseAndPrint(String blockName, boolean accumulate, String target, int mode) {
                //logger.debug("CCSTemplate.parseAndPrint(\"" + blockName + "\", " + accumulate
                //        + ", \"" + target + "\", " + mode + ")");
        if (StringUtils.isEmpty(blockName)) {
            logger.error("call with null name => CCSTemplate.parseAndPrint(\"" + blockName
                    + "\", " + accumulate + ", \"" + target + "\", " + mode + ")");
            return "";
        }
        List items = (List) templateModel.get("/" + blockName + "/*");
        if (items == null) {
            if (mode == CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING) {
                return "";
            } else {
                throw new NoSuchTemplateItemException("Block '" + blockName + "' does not exist");
            }
        }

        ITemplateItem item = (ITemplateItem) items.get(0);
        item.setAccumulate(accumulate);

        ITemplateItem pointTarget = null;
        if (target == null) {
            pointTarget = item;
            item.setTargetItem(null);
        } else {
            List targets = (List) templateModel.get("/" + target + "/*");
            if (targets == null) {
                pointTarget = new TemplateVariable();
                List trgs = new ArrayList();
                trgs.add(pointTarget);
                templateModel.put("/" + target + "/*", trgs);
                item.setTargetItem(pointTarget);
                //item.setTargetItem(item);
                //if (mode != CCSTemplate.IF_DOESNT_EXIST_DO_NOTHING) {
                //    throw new NoSuchTemplateItemException("Target block '" + target + "' does not exist");
                //}
            } else {
                pointTarget = (ITemplateItem) ((List) templateModel.get("/" + target + "/*")).get(0);
                item.setTargetItem(pointTarget);
            }
        }

        item.parse();
        pointTarget.setParsed(true);
	if ("main".equals(blockName))
	        return pointTarget.getBody().toString();
	return "";
    }

    public String parse(String blockName, boolean accumulate, String target, int mode) {
        return parseAndPrint(blockName, accumulate, target, mode);
    }

    public String parse(String blockName, boolean accumulate, String target) {
        return parseAndPrint(blockName, accumulate, target, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String parse(String blockName, boolean accumulate) {
        return parseAndPrint(blockName, accumulate, null, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String parse(String blockName) {
        return parseAndPrint(blockName, true, null, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String parse(String blockName, boolean accumulate, int mode) {
        return parseAndPrint(blockName, accumulate, null, mode);
    }

    public String parse(String blockName, int mode) {
        return parseAndPrint(blockName, true, null, mode);
    }

    public String render(String blockName, boolean accumulate, String target, int mode) {
        return renderBlock(blockName, accumulate, target, mode);
    }

    public String render(String pathTo, String blockName, boolean accumulate, String target,
            int mode) {
        return renderBlock(pathTo, blockName, accumulate, target, mode);
    }

    public String render(String blockName, boolean accumulate, String target) {
        return renderBlock(blockName, accumulate, target, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String render(String blockName, boolean accumulate) {
        return renderBlock(blockName, accumulate, null, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String render(String pathTo, String blockName, boolean accumulate) {
        return renderBlock(pathTo, blockName, accumulate, null,
                CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String render(String blockName) {
        return renderBlock(blockName, true, null, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String render(String pathTo, String blockName) {
        return renderBlock(pathTo, blockName, true, null, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String render(String pathTo, String blockName, boolean accumulate, int mode) {
        return renderBlock(pathTo, blockName, accumulate, null, mode);
    }

    public String render(String blockName, boolean accumulate, int mode) {
        return renderBlock(blockName, accumulate, null, mode);
    }

    public String render(String blockName, int mode) {
        return renderBlock(blockName, true, null, mode);
    }

    public boolean isExists(String path, int type) {
        if (StringUtils.isEmpty(path)) {
            return false;
        }
        return templateModel.get("/" + path + "/*") != null;
    }

    public void hideBlock(String blockName) {
        setVar(blockName, "");
    }

    public String pParse(String blockName, boolean accumulate) {
        return parseAndPrint(blockName, accumulate, null, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    public String parseTo(String blockName, boolean accumulate, String target) {
        return parseAndPrint(blockName, accumulate, target, CCSTemplate.IF_DOESNT_EXIST_IS_ERROR);
    }

    
    public String getVar(String name) {
        List items = (List) templateModel.get("/" + name + "/*");
        if (items == null) {
            return null;
        }
        ITemplateItem item = (ITemplateItem) items.get(0);
        if (item != null) {
            return item.getBody().toString();
        }
        return null;
    }
}


//End CCSTemplate class

