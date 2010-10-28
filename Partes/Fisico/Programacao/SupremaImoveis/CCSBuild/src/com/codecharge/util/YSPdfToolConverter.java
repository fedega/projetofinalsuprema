//YSPdfToolConverter class @0-0DC0296C
package com.codecharge.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

import com.codecharge.util.StringUtils;
import com.codecharge.util.CCLogger;


public class YSPdfToolConverter implements IContentConverter {

    final static private int BUFFER_SIZE = 1024 * 32;
    
    final static private String DEFAULT_COMMAND = "c:/program files/superpdf/bin/pdftool.exe";
    final static private String DEFAULT_OPTIONS = "";
    final static private String DEFAULT_TEMP_FOLDER = "%TEMP";

    final static private int COMMAND_INDEX = 0;
    final static private int OPTIONS_INDEX = 1;
    final static private int TEMP_FOLDER_INDEX = 2;
    final static private int ROOT_URL_INDEX = 3;
    final static private int WAIT_FOR_PROCCES_INDICATOR_INDEX = 4;
    
    public byte[] convert(byte[] content, String[] parameters) throws IOException {

        if (content == null) {
            return null;
        }
        
        String cmd = getParameter(parameters, YSPdfToolConverter.COMMAND_INDEX, YSPdfToolConverter.DEFAULT_COMMAND);
        String tmpFolder = getParameter(parameters, YSPdfToolConverter.TEMP_FOLDER_INDEX, YSPdfToolConverter.DEFAULT_TEMP_FOLDER);
        String options = " " + getParameter(parameters, YSPdfToolConverter.OPTIONS_INDEX, YSPdfToolConverter.DEFAULT_OPTIONS) + " ";
        String rootUrl = getParameter(parameters, YSPdfToolConverter.ROOT_URL_INDEX, "");
        String waitForProcessIndicator = getParameter(parameters, YSPdfToolConverter.WAIT_FOR_PROCCES_INDICATOR_INDEX, "");

        File html = saveToFile(createTempFile("ccspdf", "html", tmpFolder), content);
        File result = createTempFile("ccspdf", "pdf", tmpFolder);
        
        if (cmd.toLowerCase().indexOf("pdftool.exe") > -1) {
            //if (options.indexOf(" -u ") < 0) {
            String rOptions = StringUtils.replace(options, " ", "");
            if ("".equals(rOptions)) {
                options += "\"" + html.getAbsolutePath() + "\"";
                if (! StringUtils.isEmpty(rootUrl)) {
                    options += " -root " + rootUrl;
                }
            }
            if (StringUtils.isEmpty(waitForProcessIndicator)) {
                waitForProcessIndicator = " -f ";
            }
        }
        
        boolean isWaitForProcess = false; //if false - read stdout; otherwise - wait for process and read output file.
        if (! StringUtils.isEmpty(waitForProcessIndicator) 
                && options.indexOf(waitForProcessIndicator) > -1) {
            isWaitForProcess = true;
        }

        options = StringUtils.replace(options, "{ResultFile}", "\"" + result.getAbsolutePath() + "\"");
        options = StringUtils.replace(options, "{InputFile}", "\"" + html.getAbsolutePath() + "\"");
        options = StringUtils.replace(options, "{Root}", rootUrl);

        //String[] cmdArr = (cmd + " " + options).split(" ");
        List r = StringUtils.splitToList(cmd + " " + options, ' ', '\t');
        String[] cmdArr = new String[r.size()];
        for (int g = 0; g<r.size(); g++) cmdArr[g] = (String) r.get(g);

        CCLogger.getInstance().info(cmd + " " + options);
        Process proc = Runtime.getRuntime().exec(cmdArr);
        BufferedInputStream bis = getInputStream(result, proc, isWaitForProcess);
        byte[] pdf = getContent(bis);
        bis.close();

        html.delete();
        result.delete();
        
        return pdf;
    }
    
    private BufferedInputStream getInputStream(File result, Process proc, boolean isWaitForProcess) throws IOException {
        BufferedInputStream bis = null;
        if (isWaitForProcess) {
            try {
                proc.waitFor();
            } catch (InterruptedException ie) {

                new RuntimeException(ie.getMessage());


            }
            if (result.length() > 0) {
                bis = new BufferedInputStream(new FileInputStream(result));
            }
        } else {
            bis = new BufferedInputStream(proc.getInputStream());
        }
        return bis;
    }

    private byte[] getContent(BufferedInputStream bis) throws IOException {
        int i = 0;
        long counter = 0;
        byte[] c = new byte[YSPdfToolConverter.BUFFER_SIZE];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if (bis != null) {
            while ((i = bis.read(c)) > 0) {
                os.write(c, 0, i);
                counter += i;
            }
        } else { 
            os.write("Unable to read result file.".getBytes());
        }
        os.close();
        return os.toByteArray();
    }

    private File createTempFile(String prefix, String extension, String tmpFolder) throws IOException {
        File file;
        if ("%TEMP".equals(tmpFolder)) {
            file = File.createTempFile(prefix, "." + extension);
        } else {

            if (tmpFolder.startsWith("\"")) {
                tmpFolder = tmpFolder.substring(1,tmpFolder.length());
            }
            if (tmpFolder.endsWith("\"")) {
                tmpFolder = tmpFolder.substring(0,tmpFolder.length()-1);
            }

            file = File.createTempFile(prefix, "." + extension, new File(tmpFolder));
        }
        return file;
    }
    
    private File saveToFile(File file, byte[] content) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        out.write(content);
        out.close();
        return file;
    }

    private String getParameter(String[] parameters, int index, String defaultValue) {
        String result = null;
        if (parameters.length > index && ! StringUtils.isEmpty(parameters[index])) {
            result = parameters[index];
        }
        if (StringUtils.isEmpty(result)) {
            result = defaultValue;
        }
        return result;
    }
    
    private void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("array["+i+"]: "+array[i]);
        }
    }
}

//End YSPdfToolConverter class

