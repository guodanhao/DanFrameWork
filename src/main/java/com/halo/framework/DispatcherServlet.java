package com.halo.framework;

import com.halo.framework.bean.Handler;
import com.halo.framework.helper.BeanHelper;
import com.halo.framework.helper.ConfigHelper;
import com.halo.framework.helper.ControllerHepler;
import com.halo.framework.helper.HelperLoader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by guodanhao on 16-9-19.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        HelperLoader.init();

        /**
         * servlet这边有个回调函数
         */
        ServletContext servletContext = servletConfig.getServletContext();

        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");

        jspServlet.addMapping(ConfigHelper.getJspPath() + "*");

        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");

        defaultServlet.addMapping(ConfigHelper.getAppAssertPath() + "*");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestMethod = request.getMethod().toLowerCase();

        String requestPath = request.getPathInfo();

        Handler handler = ControllerHepler.getHandler(requestMethod, requestPath);
        if (handler != null) {
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);

            Map<String, Object> paramMap = new HashMap<>();

            Enumeration<String> paramNames = request.getParameterNames();


            // TODO 为何不放到param中
            while (paramNames.hasMoreElements()) {

                String paramName = paramNames.nextElement();

                String paramValue = request.getParameter(paramName);

                paramMap.put(paramName, paramValue);
            }

//            String body = CodecU
        }

    }
}
