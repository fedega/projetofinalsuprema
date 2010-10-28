//IServiceChecker @0-0D3671AC

package com.codecharge.features;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

public interface IServiceChecker {
	public boolean check ( HttpServletRequest request, HttpServletResponse response, ServletContext context);
}


//End IServiceChecker

