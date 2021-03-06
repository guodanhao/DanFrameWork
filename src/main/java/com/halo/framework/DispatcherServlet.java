package com.halo.framework;

import com.halo.framework.bean.Data;
import com.halo.framework.bean.Handler;
import com.halo.framework.bean.Param;
import com.halo.framework.bean.View;
import com.halo.framework.helper.BeanHelper;
import com.halo.framework.helper.ConfigHelper;
import com.halo.framework.helper.ControllerHepler;
import com.halo.framework.helper.HelperLoader;
import com.halo.framework.utils.CodecUtil;
import com.halo.framework.utils.ReflectionUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
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

        // 从helper中获得handler
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

            //TODO 缺少对getInputStream的处理
            String body = CodecUtil.decodeURL(request.getInputStream().toString());

            if (StringUtils.isNotEmpty(body)) {

                // 把body中的参数放进paramMap中
                String[] params = StringUtils.split(body, "&");
                if (ArrayUtils.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] array = StringUtils.split(param, "=");
                        if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }

            Param param = new Param(paramMap);

            Method actionMethod = handler.getActionMethod();

            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);

            // 处理action的返回内容
            if (result instanceof View){
                View view = (View) result;
                String path = view.getPath();

                if (StringUtils.isNotEmpty(path)) {
                    if (path.startsWith("/")) {
                        response.sendRedirect(request.getContextPath() + path);
                    }else {
                        Map<String, Object> model = view.getModel();
                        for (Map.Entry<String, Object> enttry : model.entrySet()) {
                            request.setAttribute(enttry.getKey(), enttry.getValue());
                        }
                        request.getRequestDispatcher(ConfigHelper.getAppBasePackage() + path).forward(request, response);
                    }
                }
            }else {
                if (result instanceof Data) {
                    Data data = (Data) result;
                    Object model = data.getModel();
                    if (model != null) {
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter write = response.getWriter();
                        //TODO 缺少将model转化为json
                        write.write(model.toString());
                        write.flush();
                        write.close();
                    }
                }
            }

        }

    }
}
