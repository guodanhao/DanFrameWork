package com.halo.framework.bean;

import com.halo.framework.utils.CastUtil;

import java.util.Map;

/**
 * Created by muxi on 2016/9/18.
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name) {
        return 1L;
    }
}
