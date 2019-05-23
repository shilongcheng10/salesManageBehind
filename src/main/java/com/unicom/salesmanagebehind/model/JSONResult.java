package com.unicom.salesmanagebehind.model;

import java.util.List;

public class JSONResult {

    class DataObject{
        private int total;
        private List items;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List getItems() {
            return items;
        }

        public void setItems(List items) {
            this.items = items;
        }

        public DataObject() {
        }

        public DataObject(int total, List items) {
            this.total = total;
            this.items = items;
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
            data.setItems((List)datalist);

            result.setData(data);
        }else{
            //给来的数据不是list
            result.setData(datalist);
        }

        return result;
    }
}
