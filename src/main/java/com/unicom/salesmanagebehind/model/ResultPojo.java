
package com.unicom.salesmanagebehind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回包装类〉
 *
 * @author ludehao
 * @create 2018/11/7
 * @since 1.0.0
 */
@ApiModel(description="返回结果包装类")
public class ResultPojo<T> {
    @ApiModelProperty(value="返回结果报文",name="code",required=true)
    private Integer code;
    @ApiModelProperty(value="返回结果信息",name="msg",required=true)
    private String msg;
    @ApiModelProperty(value="返回结果数据",name="data",required=true)
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
 
