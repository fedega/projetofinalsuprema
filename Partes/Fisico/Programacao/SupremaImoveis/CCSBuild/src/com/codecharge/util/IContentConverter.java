//IContentConverter interface @0-BE0049D1
package com.codecharge.util;

import java.io.IOException;

import com.codecharge.util.StringUtils;

public interface IContentConverter {
    byte[] convert(byte[] content, String[] parameters) throws IOException;
}

//End IContentConverter interface

