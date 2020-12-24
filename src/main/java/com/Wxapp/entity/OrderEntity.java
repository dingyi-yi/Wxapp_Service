package com.Wxapp.entity;

import com.Wxapp.dao.OrderImage;
import com.Wxapp.dao.UserAccount;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ding
 * 订单实体类（包含已处理和未处理订单以及订单对应的图片）
 */
@Component
public class OrderEntity<E> {

    /**
     * 该订单发布者名称和头像
     */
    String OrderWxName;
    String OrderHeadPortrait;

    /**
     * 订单内容
     */
    E order;
    /**
     * 订单图片
     */
    List<OrderImage> orderImages;

    public OrderEntity(String orderWxName, String orderHeadPortrait, E order, List<OrderImage> orderImages) {
        OrderWxName = orderWxName;
        OrderHeadPortrait = orderHeadPortrait;
        this.order = order;
        this.orderImages = orderImages;
    }

    public OrderEntity() {
    }

    public String getOrderWxName() {
        return OrderWxName;
    }

    public void setOrderWxName(String orderWxName) {
        OrderWxName = orderWxName;
    }

    public String getOrderHeadPortrait() {
        return OrderHeadPortrait;
    }

    public void setOrderHeadPortrait(String orderHeadPortrait) {
        OrderHeadPortrait = orderHeadPortrait;
    }

    public E getOrder() {
        return order;
    }

    public void setOrder(E order) {
        this.order = order;
    }

    public List<OrderImage> getOrderImages() {
        return orderImages;
    }

    public void setOrderImages(List<OrderImage> orderImages) {
        this.orderImages = orderImages;
    }
}
