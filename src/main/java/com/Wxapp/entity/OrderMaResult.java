package com.Wxapp.entity;

import com.Wxapp.dao.ComQualification;

import java.util.List;

/**
 * 维修预约（查询维修）时，结果返回
 */
public class OrderMaResult {
    int Code;
    String RepMess;
    List<ComQualification> RepData;

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

    public List<ComQualification> getRepData() {
        return RepData;
    }

    public void setRepData(List<ComQualification> repData) {
        RepData = repData;
    }
}
