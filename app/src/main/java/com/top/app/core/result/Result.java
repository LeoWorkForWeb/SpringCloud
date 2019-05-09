package com.top.app.core.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一API响应结果封装
 */
public class Result {
    private int code;
    private String message;
    private Object data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        Map< String , Object > jsonMap = new HashMap< String , Object>();
        jsonMap.put("a",1);
        jsonMap.put("b","");
        jsonMap.put("c",null);
        jsonMap.put("d","wuzhuti.cn");

        String str = JSON.toJSONString(jsonMap, SerializerFeature.WriteMapNullValue, SerializerFeature.UseISO8601DateFormat);
        System.out.println(str);

    }

}
