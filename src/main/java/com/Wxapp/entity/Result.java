package com.Wxapp.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 请求返回结果，
 */
public class Result<E> {
    int Code;
    String RepMess;
    JSONObject JsonData;
    List<E> ListData;

    public Result(int code, String repMess, JSONObject jsonData, List<E> listData) {
        Code = code;
        RepMess = repMess;
        JsonData = jsonData;
        ListData = listData;

    }

    public Result() {
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

    public JSONObject getJsonData() {
        return JsonData;
    }

    public void setJsonData(JSONObject jsonData) {
        JsonData = jsonData;
    }

    public List<E> getListData() {
        return ListData;
    }

    public void setListData(List<E> listData) {
        ListData = listData;
    }


    public void addJsonData(String key,Object value)
    {
       if (JsonData==null)
       {
           JsonData=new JSONObject();
       }
        JsonData.put(key,value);
    }


    @Override
    public String toString() {
        return "Result{" +
                "Code=" + Code +
                ", RepMess='" + RepMess + '\'' +
                ", JsonData=" + JsonData +
                ", ListData=" + ListData +
                '}';
    }
}
