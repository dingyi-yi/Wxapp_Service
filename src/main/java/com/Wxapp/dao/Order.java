package com.Wxapp.dao;

import java.util.List;

/**
 * @author ding
 * 订单实体类（包含已处理和未处理订单以及订单对应的图片）
 */
public class Order<E> {
    /**
     * 订单内容
     */
    E order;
    /**
     * 订单图片
     */
    List<OrderImage> orderImages;

    public Order(E order, List<OrderImage> orderImages) {
        this.order = order;
        this.orderImages = orderImages;
    }

    public Order() {
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
