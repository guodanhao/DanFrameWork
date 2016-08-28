package com.halo.framework.utils;

import org.jetbrains.annotations.Contract;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** 超级无敌加载类
 * Created by guodanhao on 2016/8/28.
 */
public class PropsUtils {

    /**
     * 加载properties配置文件工具类
     * @param fileConfig
     * @return
     */
    public static Properties loadProps(String fileConfig) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = Object.class.getResourceAsStream("/" + fileConfig);
            properties.load(inputStream);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 根据传入的properties文件对象的key获得value
     * @param properties
     * @param key
     * @return value
     */
    public static String getString(Properties properties, String key){
        String value = properties.getProperty(key);
        return value;
    }

    /**
     *  根据传入的properties文件对象的key获得value,提供可选的路径配置项pathCustom
     * @param properties
     * @param key
     * @param pathCustom 自定义配置项，传入null默认加载配置文件key
     * @return value
     */
    @Contract("_, _, !null -> !null")
    public static String getString(Properties properties, String key, String pathCustom){
        if (pathCustom != null){
            return pathCustom;
        }else {
            String value = properties.getProperty(key);
            return value;
        }
    }
}
