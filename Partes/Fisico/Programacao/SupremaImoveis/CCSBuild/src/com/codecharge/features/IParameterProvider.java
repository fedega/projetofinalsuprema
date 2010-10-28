//IParameterProvider @0-7AC7EFE7

package com.codecharge.features;

public interface IParameterProvider {
    public static final String URL = "~url";
    public static final String FORM = "~url";
    public static final String SESSION = "~url";
    public static final String APPLICATION = "~url";
    public static final String DB = "~url";

    public Object getParameter (String name);
    public Object getParameter (String type, String name);
}


//End IParameterProvider

