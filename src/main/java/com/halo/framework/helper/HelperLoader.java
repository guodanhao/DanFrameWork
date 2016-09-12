package com.halo.framework.helper;

import com.halo.framework.utils.ClassUtil;

/**
 * Created by muxi on 2016/9/12.
 */
public class HelperLoader {

    public static void init() {

        Class<?>[] classList = {

                ClassHelper.class,
//                ConfigHelper.class,
                BeanHelper.class,
                ControllerHepler.class,
                IocHepler.class
        };

        for (Class<?> cls:classList) {

            ClassUtil.loadClass(cls.getName());
        }
    }
}
