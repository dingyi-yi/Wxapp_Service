package com.Wxapp.dao;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ding
 * 用户画像数据库表对应的实体类
 */
@Component
public class UserPortrait {
    String OpenId;
    int Status;
    int Maintain;
    Date MaintainDate;
    String MaintainContent;
    int MaintainNumber;

    public UserPortrait(String openId, int status, int maintain,
                        Date maintainDate, String maintainContent, int maintainNumber) {
        OpenId = openId;
        Status = status;
        Maintain = maintain;
        MaintainDate = maintainDate;
        MaintainContent = maintainContent;
        MaintainNumber = maintainNumber;
    }


    public UserPortrait() {
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getMaintain() {
        return Maintain;
    }

    public void setMaintain(int maintain) {
        Maintain = maintain;
    }

    public Date getMaintainDate() {
        return MaintainDate;
    }

    public void setMaintainDate(Date maintainDate) {
        MaintainDate = maintainDate;
    }

    public String getMaintainContent() {
        return MaintainContent;
    }

    public void setMaintainContent(String maintainContent) {
        MaintainContent = maintainContent;
    }

    public int getMaintainNumber() {
        return MaintainNumber;
    }

    public void setMaintainNumber(int maintainNumber) {
        MaintainNumber = maintainNumber;
    }
}
