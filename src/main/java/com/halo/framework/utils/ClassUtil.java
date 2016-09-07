package com.halo.framework.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

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

    public static Class<?> loadClass(String className) {
        Class<?> cls;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return cls;
    }

    public static Set<Class<?>> getClassSet(String packageName) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));

            if (urls.hasMoreElements()) {

                URL url = urls.nextElement();

                //TODO 未完待续
                if (url != null){
                    String protocol = url.getProtocol();
                    if ("file".equals(protocol) ){

                    }else if ("jar".equals(protocol)){

                    }
                }
            }
        } catch (IOException e) {

        }
        return null;
    }
}
