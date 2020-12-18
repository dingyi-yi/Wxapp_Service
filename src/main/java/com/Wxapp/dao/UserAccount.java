package com.Wxapp.dao;

import java.util.Date;

public class UserAccount {

    String OpenId;
    Date lasttime;
    String WxNmae;
    String HeadPortrait;

    public String getOpenid() {
        return OpenId;
    }

    public void setOpenid(String openid) {
        this.OpenId = openid;
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

}
