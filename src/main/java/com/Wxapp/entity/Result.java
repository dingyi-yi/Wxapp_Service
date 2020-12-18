package com.Wxapp.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * 请求返回结果，
 */
public class Result {
    int Code;
    String RepMess;
    JSONObject data;

    public Result() {
    }

    public Result(int code, String repMess, JSONObject data) {
        Code = code;
        RepMess = repMess;
        this.data = data;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getRepMess() {
        return RepMess;
    }

    public void setRepMess(String repMess) {
        RepMess = repMess;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "Code=" + Code +
                ", RepMess='" + RepMess + '\'' +
                ", data=" + data +
                '}';
    }
}
