package com.unicom.salesmanagebehind.utils;

import com.unicom.salesmanagebehind.model.ResultPojo;

/**
 * 结果处理工具类
 */
public class ResultUtils {

    public static ResultPojo success() {
        return new ResultPojo(200, "成功", null);
    }

    public static ResultPojo success(String msg) {
        return new ResultPojo(200, msg, null);
    }

    public static ResultPojo success(Object object) {
        return new ResultPojo(200, "成功", object);
    }

    public static ResultPojo success(String msg, Object object) {
        return new ResultPojo(200, msg, object);
    }
    public static ResultPojo error(Integer code, String msg) {
        return new ResultPojo(code, msg, null);
    }

}
