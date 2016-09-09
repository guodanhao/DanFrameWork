package com.halo.framework.helper;

import com.halo.framework.bean.Handler;
import com.halo.framework.bean.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by muxi on 2016/9/9.
 */
public final class ControllerHepler {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {
        Set<Class<?>> controllerClassSet = null;
        // ClassHelper.getClassController();

//        if
    }
}
