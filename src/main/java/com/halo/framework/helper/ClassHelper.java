package com.halo.framework.helper;

import com.halo.framework.annotation.Controller;
import com.halo.framework.annotation.Service;
import com.halo.framework.utils.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by muxi on 2016/9/10.
 */
public class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {

        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getClassService() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls: CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getClassController() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls: CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getClassController());
        beanClassSet.addAll(getClassService());

        return beanClassSet;
    }
}
