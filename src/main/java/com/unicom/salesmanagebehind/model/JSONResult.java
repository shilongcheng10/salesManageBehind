package com.unicom.salesmanagebehind.model;

import java.util.List;

public class JSONResult {

    class DataObject{
        private int total;
        private List notices;
        private String message;


        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List getNotices() {
            return notices;
        }

        public void setNotices(List notices) {
            this.notices = notices;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }


        public DataObject() {
        }

        public DataObject(int total, List items,String message) {
            this.total = total;
            this.notices = items;
            this.message=message;
        }


    }

    private int code;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSONResult() {
    }

    public JSONResult(int code, DataObject data) {
        this.code = code;
        this.data = data;
    }

    public JSONResult ok(Object datalist){
        JSONResult result=new JSONResult();
        result.setCode(0);

        //判断给来数据是list的情况（DataObject）
        if(datalist instanceof List){
            DataObject data=new DataObject();
            data.setTotal(((List)datalist).size());
            data.setNotices((List)datalist);

            result.setData(data);
        }else{
            //给来的数据不是list
//            result.setData(datalist);
            DataObject data=new DataObject();
            data.setMessage((String)datalist);

        }

        return result;
    }
}
