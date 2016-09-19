package com.halo.framework;

import com.halo.framework.helper.ConfigHelper;
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
        ServletContext servletContext = servletConfig().getServletContext();

        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");

        jspServlet.addMapping(ConfigHelper.getJspPath() + "*");

        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");

        defaultServlet.addMapping(ConfigHelper.getAppAssertPath() + "*");
    }

    private ServletConfig servletConfig() {

        return null;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String requestMethod = req.getMethod().toLowerCase();

    }
}
