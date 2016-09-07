package com.halo.framework.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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

                if (url != null){
                    String protocol = url.getProtocol();
                    if ("file".equals(protocol) ){

                        String packagePath = url.getPath().replace("%20", " ");
                        addClass(classSet, packagePath, packageName);

                    }else if ("jar".equals(protocol)){
                        JarURLConnection  jarURLConnection = (JarURLConnection) url.openConnection();
                        if (jarURLConnection != null ) {

                            JarFile jarFile = jarURLConnection.getJarFile();

                            if (jarFile != null) {

                                Enumeration<JarEntry> jarEntries = jarFile.entries();

                                while (jarEntries.hasMoreElements()) {
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();

                                    if (jarEntryName.endsWith(".class")) {

                                        String className = jarEntryName.substring(0, jarEntryName.indexOf("."));
                                        doAddClass(classSet, className);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {

        }
        return null;
    }

    public static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {

        File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });

        for (File file: files) {

            String fileName = file.getName();

            if (file.isFile()) {

                String className = fileName.substring(0, fileName.lastIndexOf("."));

                if (StringUtils.isNotEmpty(packageName)) {
                    className = packageName + "." +className;
                }

                doAddClass(classSet, className);
            } else {

                String subPackagePath = fileName;
                if (StringUtils.isNotEmpty(packagePath)) {
                    subPackagePath = packagePath + "/" +subPackagePath;
                }

                String subPackageName = fileName;
                if (StringUtils.isNotEmpty(packageName)) {
                    subPackageName = packageName + "." +subPackageName;
                }
                addClass(classSet, subPackagePath, subPackageName);
            }
        }
    }

    public static void doAddClass(Set<Class<?>> classSet, String className) {
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }
}
