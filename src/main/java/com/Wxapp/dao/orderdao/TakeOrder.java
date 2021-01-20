package com.Wxapp.dao.orderdao;

import org.springframework.stereotype.Component;


/**
 * @author ding
 * 商家接单实体类
 */
@Component
public class TakeOrder {
    String OrderId;
    String MerchantId;
    int ExpectedPrice;
    String ExpectedScheme;

    public TakeOrder(String orderId, String merchantId, int expectedPrice, String expectedScheme) {
        OrderId = orderId;
        MerchantId = merchantId;
        ExpectedPrice = expectedPrice;
        ExpectedScheme = expectedScheme;
    }

    public TakeOrder() {
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getMerchantId() {
        return MerchantId;
    }

    public void setMerchantId(String merchantId) {
        MerchantId = merchantId;
    }

    public int getExpectedPrice() {
        return ExpectedPrice;
    }

    public void setExpectedPrice(int expectedPrice) {
        ExpectedPrice = expectedPrice;
    }

    public String getExpectedScheme() {
        return ExpectedScheme;
    }

    public void setExpectedScheme(String expectedScheme) {
        ExpectedScheme = expectedScheme;
    }
}
