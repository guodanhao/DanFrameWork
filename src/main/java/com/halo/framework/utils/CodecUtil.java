package com.halo.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码和解码操作工具类
 * Created by guodanhao on 16-9-21.
 */
public class CodecUtil {

    private static final Logger log = LoggerFactory.getLogger(CodecUtil.class);

    public static String encodeURL(String source) {

        String target = null;
        try {

            target = URLEncoder.encode(source, "UTF-8");

        } catch (UnsupportedEncodingException e){
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }
        return target;
    }

    public static String decodeURL(String source) {
        String target = null;
        try {

            target = URLDecoder.decode(source, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);

            throw new RuntimeException();
        }
        return target;
    }
}
