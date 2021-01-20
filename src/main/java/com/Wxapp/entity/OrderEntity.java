package com.Wxapp.entity;

import com.Wxapp.dao.merchantdao.Evaluation;
import com.Wxapp.dao.orderdao.ProcesserOrder;
import com.Wxapp.dao.orderdao.UntreatedOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * 订单实体类（包含已处理和未处理订单以及订单对应的图片）
 */
@Component
public class OrderEntity {

    /**
     * 该订单发布者名称和头像
     */
    String OrderWxName;
    String OrderHeadPortrait;


    /**
     * 用于判断是该订单的类型 =1表示已处理订单 =0表示未处理订单
     */
    int Type;


    /**
     * 商家是否接单
     */
    boolean IsTakeOrder;

    /**
     * 该订单的所有接单商家
     */
    List<TakeOderCompany> takeOderCompanyList;




    /**
     *未处理订单
     */
    UntreatedOrder untreatedOrder;

    /**
     * 已处理的订单
     */
    ProcesserOrder processerOrder;

    /**
     * 当为已经处理的订单时，只要一个商家的数据
     */
    TakeOderCompany takeOderCompany;

    /**
     * 已处理订单的评价
     */
    Evaluation evaluation;


    public OrderEntity(String orderWxName, String orderHeadPortrait, int type, boolean isTakeOrder, List<TakeOderCompany> takeOderCompanyList, UntreatedOrder untreatedOrder, ProcesserOrder processerOrder,
                       TakeOderCompany takeOderCompany, Evaluation evaluation) {
        OrderWxName = orderWxName;
        OrderHeadPortrait = orderHeadPortrait;
        Type = type;
        IsTakeOrder = isTakeOrder;
        this.takeOderCompanyList = takeOderCompanyList;
        this.untreatedOrder = untreatedOrder;
        this.processerOrder = processerOrder;
        this.takeOderCompany = takeOderCompany;
        this.evaluation = evaluation;
    }



    public OrderEntity() {
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
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

    public boolean isTakeOrder() {
        return IsTakeOrder;
    }

    public void setTakeOrder(boolean takeOrder) {
        IsTakeOrder = takeOrder;
    }

    public List<TakeOderCompany> getTakeOderCompanyList() {
        return takeOderCompanyList;
    }

    public void setTakeOderCompanyList(List<TakeOderCompany> takeOderCompanyList) {
        this.takeOderCompanyList = takeOderCompanyList;
    }

    public UntreatedOrder getUntreatedOrder() {
        return untreatedOrder;
    }

    public void setUntreatedOrder(UntreatedOrder untreatedOrder) {
        this.untreatedOrder = untreatedOrder;
    }

    public ProcesserOrder getProcesserOrder() {
        return processerOrder;
    }

    public void setProcesserOrder(ProcesserOrder processerOrder) {
        this.processerOrder = processerOrder;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public TakeOderCompany getTakeOderCompany() {
        return takeOderCompany;
    }

    public void setTakeOderCompany(TakeOderCompany takeOderCompany) {
        this.takeOderCompany = takeOderCompany;
    }

    public void addtakeOderCompanyList(TakeOderCompany takeOderCompany)
    {
        if (takeOderCompanyList==null)
        {
            takeOderCompanyList=new ArrayList<>();
        }
        takeOderCompanyList.add(takeOderCompany);
    }



}
