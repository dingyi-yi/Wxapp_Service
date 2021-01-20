package com.Wxapp.dao.userdao;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class UserAccount {

    String OpenId;
    Date LastTime;
    String WxName;
    String HeadPortrait;
    int Status;
    int GolCoin;
    String Address;
    double Lon;
    double Lat;


    public UserAccount(String openId, Date lastTime, String wxName, String headPortrait, int status,
                       int golCoin, String address, double lon, double lat) {
        OpenId = openId;
        LastTime = lastTime;
        WxName = wxName;
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

    public Date getLastTime() {
        return LastTime;
    }

    public void setLastTime(Date lastTime) {
        LastTime = lastTime;
    }

    public String getWxName() {
        return WxName;
    }

    public void setWxName(String wxName) {
        WxName = wxName;
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
