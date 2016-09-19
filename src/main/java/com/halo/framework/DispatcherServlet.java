package com.halo.framework;

import com.halo.framework.helper.HelperLoader;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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

        ServletContext servletContext = servletConfig().getServletContext();

        // TODO

    }

    private ServletConfig servletConfig() {
        return null;
    }
}
