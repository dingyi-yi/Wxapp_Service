package com.Wxapp.dao;

import java.util.Date;

public class UserAccount {

    String OpenId;
    Date lasttime;
    String WxNmae;
    String HeadPortrait;
    int Status;

    public UserAccount(String openId, Date lasttime, String wxNmae, String headPortrait, int status) {
        OpenId = openId;
        this.lasttime = lasttime;
        WxNmae = wxNmae;
        HeadPortrait = headPortrait;
        Status = status;
    }

    public UserAccount() {
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getWxNmae() {
        return WxNmae;
    }

    public void setWxNmae(String wxNmae) {
        WxNmae = wxNmae;
    }

    public String getHeadPortrait() {
        return HeadPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        HeadPortrait = headPortrait;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
