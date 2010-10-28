//AbstractServiceAction @0-4CCFEB15

package com.codecharge.features;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractServiceAction {
    abstract public IDataProvider preform(IParameterProvider parameterProvider, IDataProvider dataProvider, HttpServletRequest request, HttpServletResponse response);
    abstract public IDataProvider preform(IParameterProvider parameterProvider, IDataProvider dataProvider);
}


//End AbstractServiceAction

