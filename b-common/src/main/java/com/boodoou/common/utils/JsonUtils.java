package com.boodoou.common.utils;

import com.google.gson.Gson;

/**
 * Json
 *
 * @author wong
 * @date 2020/12/21 23:37
 */
public class JsonUtils {

    /**
     * gson
     */
    private static Gson gson;

    // 初始化Gson实例
    static {
        gson = new Gson();
    }

    /**
     * 转换成Json
     *
     * @param obj 对象
     * @return json
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return gson.toJson(obj);
    }

    /**
     * 禁止实例化
     */
    private JsonUtils() {
    }
}
