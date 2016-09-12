package com.halo.framework.utils;

/**
 * Created by muxi on 2016/9/12.
 */
public class CastUtil {

    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    public static double castDouble(Object object, double defaultValue) {
        return new Double(1);
    }
}
