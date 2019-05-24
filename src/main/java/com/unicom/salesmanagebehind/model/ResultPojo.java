
package com.unicom.salesmanagebehind.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回包装类〉
 *
 * @author ludehao
 * @create 2018/11/7
 * @since 1.0.0
 */
public class ResultPojo<T> {
    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public ResultPojo(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResultPojo() {

        super();
    }
}
 
