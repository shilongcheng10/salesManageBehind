package com.unicom.salesmanagebehind.utils;

import com.unicom.salesmanagebehind.model.ResultPojo;
import io.swagger.annotations.Api;

/**
 * 结果处理工具类
 */
@Api(tags = {"返回结果处理工具"})
public class ResultUtils {

    public static ResultPojo success() {
        return new ResultPojo(0, "成功", null);
    }

    public static ResultPojo success(String msg) {
        return new ResultPojo(0, msg, null);
    }

    public static ResultPojo success(Object object) {
        return new ResultPojo(0, "成功", object);
    }

    public static ResultPojo success(String msg, Object object) {
        return new ResultPojo(0, msg, object);
    }
    public static ResultPojo error(Integer code, String msg) {
        return new ResultPojo(code, msg, null);
    }

}
