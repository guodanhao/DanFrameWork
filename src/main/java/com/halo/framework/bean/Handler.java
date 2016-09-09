package com.halo.framework.bean;

import java.lang.reflect.Method;

/**
 * Created by muxi on 2016/9/9.
 */
public class Handler {

    private Class<?> controllerClass;

    private Method actionMethod;

    public Handler() {

    }

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
