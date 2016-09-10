package com.halo.framework.helper;

import com.halo.framework.annotation.Action;
import com.halo.framework.bean.Handler;
import com.halo.framework.bean.Request;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by muxi on 2016/9/9.
 */
public final class ControllerHepler {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {

        Set<Class<?>> controllerClassSet = ClassHelper.getClassController();

        if (CollectionUtils.isNotEmpty(controllerClassSet)) {

            for (Class<?> cls:controllerClassSet) {

                Method[] methods =  cls.getDeclaredMethods();

                if (ArrayUtils.isNotEmpty(methods)) {

                    for (Method method : methods) {

                        if (method.isAnnotationPresent(Action.class)) {

                            Action action = method.getAnnotation(Action.class);

                            String mapping = action.value();

                            if (mapping.matches("\\w+:/\\w*")) {

                                String[] array = mapping.split(":");

                                if (ArrayUtils.isNotEmpty(array) && array.length ==2 ) {

                                    String requestMethod = array[0];
                                    String requestPath = array[1];

                                    Request request = new Request(requestMethod, requestPath);

                                    Handler handler = new Handler(cls, method);

                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath) {

        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
