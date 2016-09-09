package com.halo.framework.helper;

import com.halo.framework.utils.ClassUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by guodanhao on 2016/9/8.
 */
public class BeanHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassUtil.getClassSet("xxx");
        for (Class<?> cls: beanClassSet ) {
            Object obj = null;
//                    ReflectionU
            BEAN_MAP.put(cls, obj);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class" + cls);
        }

        return (T)BEAN_MAP.get(cls);
    }
}
