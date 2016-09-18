package com.halo.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guodanhao on 16-9-18.
 */
public class View {

    private String path;

    public Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
