package com.Wxapp.dao;

import org.springframework.stereotype.Component;

/**
 * @author ding
 *活动图片数据库表实体类
 */
@Component
public class ActiveImage {

    String OpenId;
    String OrderId;
    byte[] ActiveImage;

    public ActiveImage(String openId, String orderId, byte[] activeImage) {
        OpenId = openId;
        OrderId = orderId;
        ActiveImage = activeImage;
    }

    public ActiveImage() {
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

    public byte[] getActiveImage() {
        return ActiveImage;
    }

    public void setActiveImage(byte[] activeImage) {
        ActiveImage = activeImage;
    }
}
