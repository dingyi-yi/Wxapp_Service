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
    byte[] OrderImage;

    public OrderImage(String openId, String orderId, byte[] orderImage) {
        OpenId = openId;
        OrderId = orderId;
        OrderImage = orderImage;
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

    public byte[] getOrderImage() {
        return OrderImage;
    }

    public void setOrderImage(byte[] orderImage) {
        OrderImage = orderImage;
    }
}
