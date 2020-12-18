package com.Wxapp.dao;

import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author ding
 */
@Component
public class OrderImage {
    String OpenId;
    String OrderId;
    byte[] file;

    public OrderImage(String openId, String orderId, byte[] file) {
        OpenId = openId;
        OrderId = orderId;
        this.file = file;
    }

    public OrderImage() {
    }

    public String getOpenId() {
        return OpenId;
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
