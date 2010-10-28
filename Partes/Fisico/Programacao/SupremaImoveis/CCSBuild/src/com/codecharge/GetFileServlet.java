//GetFileServlet class @0-6C51E7DC
package com.codecharge;


import java.io.InputStream;
import java.io.StreamTokenizer;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codecharge.util.CCLogger;
import com.codecharge.util.SimpleContextStorage;
import com.codecharge.util.StringUtils;
import com.codecharge.util.CCSLocale;
import com.codecharge.util.SessionStorage;
import com.codecharge.util.LocaleChooser;

public class GetFileServlet extends HttpServlet {

    private static Hashtable allowedFiles = new Hashtable();
    private static CCLogger log = CCLogger.getInstance();
    static {
        allowedFiles.put("functions.js", "content-type: application/x-javascript; charset=utf-8");
        allowedFiles.put("datepicker.js", "content-type: application/x-javascript; charset=utf-8");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String fileName = req.getParameter("file");
        log.debug("GetFileServlet => file '"+fileName+"' is requested");
        String content = null;
        if (isLoadAllowed(fileName)) {
            content = loadFile(fileName, getLocale(req));
        } else {
            log.debug("GetFileServlet => access denied to file '"+fileName+"'");
        }
        if (content != null) {
            resp.setContentType(getContentType(fileName));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(resp.getOutputStream(), "utf-8"));
            out.println(content);
            out.close();
        }
    }

    private boolean isLoadAllowed(String path) {
        return (! StringUtils.isEmpty(path) && GetFileServlet.allowedFiles.get(path.toLowerCase()) != null);
    }

    private String getContentType(String path) {
        return (String) GetFileServlet.allowedFiles.get(path.toLowerCase());
    }
    
    private String loadFile(String path, Locale locale) {
        String result = null;
        InputStream cf = null;
        ResourceBundle res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"), locale);
        //if ("true".equalsIgnoreCase(StringUtils.getSiteProperty("usedUnpackedWarFile"))) {
            try {
                cf = new java.io.FileInputStream(getServletContext().getRealPath(path));
            } catch (FileNotFoundException fnfe) {
                log.error( "File '"+path+"' not found.");
            }
        //} else {
            //cf = getServletContext().getResourceAsStream(path);
        //}

        if( cf == null) {
            log.error("Unable to open file '"+path+"'.");
        } else {
            try {
    			result = parse(new InputStreamReader(cf, "utf-8"), locale);
            } catch (Exception e) {
                log.error("Unable to read file '"+path+"'.", e);
            } finally {
                try {
	                cf.close();
                } catch (IOException e) {
                    log.error("Unable to read file '"+path+"'.", e);
                }
            }
        }
        return result;
    }
  
	private String parse(Reader reader, Locale locale) {
        StringBuffer sb = new StringBuffer();
        try {
            StreamTokenizer in = getStreamTokenizer(reader);

	        ResourceBundle res = ResourceBundle.getBundle(StringUtils.getSiteProperty("messagesBundle"), locale);
            while(in.nextToken() != StreamTokenizer.TT_EOF) {
                if (in.ttype == '{') {
                    in.pushBack();
                    getVar(in, sb, res);
                } else {
                    if (in.ttype == StreamTokenizer.TT_WORD) {
                        sb.append(in.sval);
                    } else if (in.ttype == StreamTokenizer.TT_NUMBER) {
                        sb.append(in.sval);
                    } else if (in.ttype == '}') {
                        sb.append('}');
                    } else if (in.ttype == StreamTokenizer.TT_EOL) {
                        sb.append("\n");
                    } else if (in.sval != null) {
                        sb.append(in.sval);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
		return sb.toString();
	}

	private StreamTokenizer getStreamTokenizer(Reader reader) throws IOException{
        StreamTokenizer in = new StreamTokenizer(reader);
        in.resetSyntax();
        in.eolIsSignificant(true);
        in.ordinaryChar('{'); //start resource variables
        in.ordinaryChar('}'); //end resource variables
        in.wordChars('<', '<'); 
        in.wordChars('>', '>'); 
        in.wordChars('-', '-'); 
        in.wordChars('"', '"'); 
        in.wordChars('!', '!'); 
        in.wordChars('.', '.'); 
        in.wordChars('#', ',');
        in.wordChars('[', '`');
        in.wordChars('.', '9');
        in.wordChars('a', 'z');
        in.wordChars('A', 'Z');
        in.wordChars('?', '@');
        in.wordChars(':', ';');
        in.wordChars('=', '=');
        in.wordChars('|', '|');
        in.wordChars('~', 255);
        in.wordChars(' ', ' ');
        in.wordChars('\\', '\\');
        in.wordChars('/', '/');
		return in;
	}
  
    private void getVar(StreamTokenizer in, StringBuffer appendTo, ResourceBundle res) throws IOException {
        StringBuffer name = new StringBuffer();
        boolean isOpen = false;
        while(in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == '}' && isOpen) {
                if (checkVarName(name.toString().trim())) {
                    String nameString = name.toString().substring(4);
                    appendTo.append(res.getString(nameString));
                } else {
                    appendTo.append( "{" + name.toString() + "}" );
                    name.setLength(0);
                    isOpen = false;
                    break;
                }
                isOpen = false;
                name.setLength(0);
                break;
            } else if (in.ttype == '{') {
                isOpen = true;
            } else if (isOpen) {
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    name.append(in.sval);
                } else if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    name.append(in.sval);
                } else if (in.ttype == StreamTokenizer.TT_EOL) {
                    appendTo.append( "{" + name.toString() + "\n" );
                    name.setLength(0);
                    isOpen = false;
                    break;
                } else if (in.sval != null) {
                    name.append(in.sval);
                }
            } else {
                if (in.sval != null) {
                    appendTo.append(in.sval);
                } else if (in.ttype == '{') {
                    appendTo.append(in.sval);
                } else if (in.ttype == '}') {
                    appendTo.append(in.sval);
                }
            }
        }
    }

    private boolean checkVarName(String name) {
        boolean result = true;
        int nameLength = name.length();
        result = name.startsWith("res:") && nameLength > 4;
        if (result) {
            for (int i = 4; i < nameLength; i++) {
                result &= (Character.isLetterOrDigit(name.charAt(i)) || name.charAt(i) == '_');
                if (! result) {
                    break;
                }
            }
        }
        return result;
    }
    
    private Locale getLocale(HttpServletRequest req) {
        return LocaleChooser.getCCSLocale(req).getLocale();
    }

}

//End GetFileServlet class

