package com.Wxapp.dao;

import java.util.Date;

public class UserAccount {

    String OpenId;
    Date lasttime;

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


}
