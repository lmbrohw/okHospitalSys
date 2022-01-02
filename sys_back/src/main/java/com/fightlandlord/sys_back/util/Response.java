package com.fightlandlord.sys_back.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response {

    //是否成功
    private Boolean success;

    //返回码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private Map<String, Object> data = new HashMap<String, Object>();

    private Response(){}

    public static Response ok(){
        Response r = new Response();
        r.setSuccess(true);
        r.setCode(ReturnCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static Response error(){
        Response r = new Response();
        r.setSuccess(false);
        r.setCode(ReturnCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public Response success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Response message(String message){
        this.setMessage(message);
        return this;
    }

    public Response code(Integer code){
        this.setCode(code);
        return this;
    }

    public Response data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Response data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}