//Service @0-B739DC11

package com.codecharge.features;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Service {
    IDataRender render;
    IParameterProvider parameterProvider;
    IDataProvider dataProvider;

    AbstractServiceAction action;

    public void setRender(IDataRender render) {
        this.render = render;
    }
    public void setParameterProvider(IParameterProvider parameterProvider) {
        this.parameterProvider = parameterProvider;
    }
    public void setDataProvider(IDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
    public void setAction(AbstractServiceAction action) {
        this.action = action;
    }


    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //IDataProvider d1 = action.preform (parameterProvider, dataProvider, request, response);
        render.setData(null);
        response.getWriter().print(render.render());
        //System.out.println( render.render() );

    }
    public void execute(){
        IDataProvider d2 = action.preform (parameterProvider, dataProvider);
        render.setData(d2);
        System.out.println( render.render() );
    }


    public String getData() {
        return render.render();
    }
}


//End Service

