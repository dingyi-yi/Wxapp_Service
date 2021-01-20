package com.Wxapp.dao.orderdao;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ding
 * 已经处理的订单实体类
 */
@Component
public class ProcesserOrder {
    String OpenId;
    String OrderId;
    String PAddress;
    String Phone;
    String Kind;
    int ServiceType;
    Date ReleaseTime;
    Date EndTime;
    String Describe;
    double Lon;
    double Lat;
    String Handler;
    int State;

    public ProcesserOrder(String openId, String orderId, String PAddress, String phone, String kind,
                          int serviceType, Date releaseTime, Date endTime, String describe,
                          double lon, double lat, String handler, int state) {
        OpenId = openId;
        OrderId = orderId;
        this.PAddress = PAddress;
        Phone = phone;
        Kind = kind;
        ServiceType = serviceType;
        ReleaseTime = releaseTime;
        EndTime = endTime;
        Describe = describe;
        Lon = lon;
        Lat = lat;
        Handler = handler;
        State = state;
    }

    public ProcesserOrder() {
    }

    public ProcesserOrder(UntreatedOrder untreatedOrder)
    {

        constructionUntreatedOrder(untreatedOrder);
    }

    public String getOpenId() {
        return OpenId;
    }

    /**
     * 用未处理订单进行复制变量
     * @param untreatedOrder
     */
    public void constructionUntreatedOrder(UntreatedOrder untreatedOrder)
    {
        OpenId=untreatedOrder.getOpenId();
        OrderId=untreatedOrder.getOrderId();
        PAddress=untreatedOrder.getPAddress();
        Phone=untreatedOrder.getPhone();
        Kind=untreatedOrder.getKind();
        ServiceType=untreatedOrder.getServiceType();
        ReleaseTime=untreatedOrder.getReleaseTime();
        Describe=untreatedOrder.getDescribe();
        Lon=untreatedOrder.getLon();
        Lat=untreatedOrder.getLat();
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
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

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
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

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String handler) {
        Handler = handler;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
