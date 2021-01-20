package com.Wxapp.entity;

import com.Wxapp.dao.merchantdao.ComQualification;
import com.Wxapp.dao.orderdao.TakeOrder;

/**
 * @author ding
 * 一个订单的接单商家
 */
public class TakeOderCompany {

    ComQualification comQualification;
    TakeOrder takeOrder;

    public TakeOderCompany(ComQualification comQualification, TakeOrder takeOrder) {
        this.comQualification = comQualification;
        this.takeOrder = takeOrder;
    }

    public TakeOderCompany() {
    }

    public ComQualification getComQualification() {
        return comQualification;
    }

    public void setComQualification(ComQualification comQualification) {
        this.comQualification = comQualification;
    }

    public TakeOrder getTakeOrder() {
        return takeOrder;
    }

    public void setTakeOrder(TakeOrder takeOrder) {
        this.takeOrder = takeOrder;
    }
}
