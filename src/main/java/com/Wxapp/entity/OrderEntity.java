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
     * 该订单发布者
     */
    UserAccount user;

    /**
     * 订单内容
     */
    E order;
    /**
     * 订单图片
     */
    List<OrderImage> orderImages;

    public OrderEntity(UserAccount user, E order, List<OrderImage> orderImages) {
        this.user = user;
        this.order = order;
        this.orderImages = orderImages;
    }

    public OrderEntity() {
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

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }
}
