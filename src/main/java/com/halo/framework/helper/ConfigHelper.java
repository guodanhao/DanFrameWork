package com.halo.framework.helper;

import com.halo.framework.ConfigConstans;
import com.halo.framework.utils.PropsUtils;

import java.util.Properties;

/**
 * Created by guodanhao on 2016/8/28.
 */
public class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtils.loadProps(ConfigConstans.CONFIG_FILE);

    public static String getJdbcUsername(){
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstans.JDBC_NAME);
    }

    public static String getJdbcPassword(){
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstans.JDBC_PASSWORD);
    }

    public static String getAppBasePackage(){
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstans.APP_BASE_PACKAGE);
    }

    public static String getAppAssertPath(){
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstans.APP_ASSET_PATH);
    }

    public static String getJspPath(){
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstans.APP_JSP_PATH);
    }


}
