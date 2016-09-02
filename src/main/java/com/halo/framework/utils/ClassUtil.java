package com.halo.framework.utils;

/**
 * Created by muxi on 2016/9/2.
 */
public final class ClassUtil {

    /**
     * 获得当前线程中的类加载器
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return cls;
    }


}
