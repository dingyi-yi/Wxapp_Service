package com.Wxapp.dao.orderdao;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UntreatedOrder {
    String OpenId;
    String OrderId;
    String PAddress;
    String Phone;
    String Kind;
    int ServiceType;
    Date ReleaseTime;
    Date ExpectTime;
    String Describe;
    double Lon;
    double Lat;

    public UntreatedOrder(String openId, String orderId, String PAddress, String phone,
                          String kind, int serviceType, Date releaseTime,
                          Date expectTime, String describe, double lon, double lat) {
        OpenId = openId;
        OrderId = orderId;
        this.PAddress = PAddress;
        Phone = phone;
        Kind = kind;
        ServiceType = serviceType;
        ReleaseTime = releaseTime;
        ExpectTime = expectTime;
        Describe = describe;
        Lon = lon;
        Lat = lat;
    }

    public UntreatedOrder() {
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getPAddress() {
        return PAddress;
    }

    public void setPAddress(String PAddress) {
        this.PAddress = PAddress;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        Kind = kind;
    }

    public int getServiceType() {
        return ServiceType;
    }

    public void setServiceType(int serviceType) {
        ServiceType = serviceType;
    }

    public Date getReleaseTime() {
        return ReleaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        ReleaseTime = releaseTime;
    }

    public Date getExpectTime() {
        return ExpectTime;
    }

    public void setExpectTime(Date expectTime) {
        ExpectTime = expectTime;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String describe) {
        Describe = describe;
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

    @Override
    public String toString() {
        return "UntreatedOrder{" +
                "OpenId='" + OpenId + '\'' +
                ", OrderId='" + OrderId + '\'' +
                ", PAddress='" + PAddress + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Kind='" + Kind + '\'' +
                ", ServiceType=" + ServiceType +
                ", ReleaseTime=" + ReleaseTime +
                ", ExpectTime=" + ExpectTime +
                ", Describe='" + Describe + '\'' +
                ", Lon=" + Lon +
                ", Lat=" + Lat +
                '}';
    }
}
