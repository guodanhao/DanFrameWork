package com.halo.framework.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by muxi on 2016/9/2.
 */
public class ClassGetAnnotation {

    public static ClassLoader getAnnotationClassLoder() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadAnnotationClass(String className, boolean isInitialize) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialize, getAnnotationClassLoder());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cls;
    }

    public static void main(String[] arg) throws NoSuchFieldException, IllegalAccessException {
        Class<?> test = loadAnnotationClass("test", false);
        Annotation annotations[] = test.getAnnotations();
        test.getDeclaredAnnotations();
        Field field = test.getDeclaredField("name");
        field.set(new String(), "name1");
        System.out.println(test.getName());
    }
}
