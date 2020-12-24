package com.Wxapp.dao;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class UserAccount {

    String OpenId;
    Date lasttime;
    String WxNmae;
    String HeadPortrait;
    int Status;
    int GolCoin;
    String Address;
    double Lon;
    double Lat;


    public UserAccount(String openId, Date lasttime, String wxNmae, String headPortrait, int status,
                       int golCoin, String address, double lon, double lat) {
        OpenId = openId;
        this.lasttime = lasttime;
        WxNmae = wxNmae;
        HeadPortrait = headPortrait;
        Status = status;
        GolCoin = golCoin;
        Address = address;
        Lon = lon;
        Lat = lat;
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

    public int getGolCoin() {
        return GolCoin;
    }

    public void setGolCoin(int golCoin) {
        GolCoin = golCoin;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getLon() {
        return Lon;
    }

    public void setLon(double lon) {
        Lon = lon;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }
}
