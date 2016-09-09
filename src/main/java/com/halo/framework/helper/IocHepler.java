package com.halo.framework.helper;

import com.halo.framework.annotation.Inject;
import com.halo.framework.utils.ReflectionUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by muxi on 2016/9/9.
 */
public class IocHepler {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

        for (Map.Entry<Class<?>, Object> entry: beanMap.entrySet() ) {
            Class<?> beanClass =  entry.getKey();
            Object beanInstance = entry.getValue();

            Field[] beanFields = beanClass.getDeclaredFields();
            if (ArrayUtils.isNotEmpty(beanFields)) {
                for ( Field beanField : beanFields) {
                    /**
                     * 找到被注释的Field
                     */
                    if (beanField.isAnnotationPresent(Inject.class)) {
                        Class<?> beanFieldClass = beanField.getType();

                        Object beanFieldInstance = beanMap.get(beanFieldClass);

                        if (beanFieldInstance != null) {
                            ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                        }
                    }
                }
            }
        }
    }
}
