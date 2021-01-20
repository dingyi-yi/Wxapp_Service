package com.Wxapp.service.orderservice;

import com.Wxapp.dao.merchantdao.ComQualification;
import com.Wxapp.dao.merchantdao.Evaluation;
import com.Wxapp.dao.orderdao.ProcesserOrder;
import com.Wxapp.dao.orderdao.TakeOrder;
import com.Wxapp.dao.orderdao.UntreatedOrder;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.OrderEntity;
import com.Wxapp.entity.TakeOderCompany;
import com.Wxapp.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * 有关个人订单
 */
@Service
public class PersonOrderService {

    @Autowired
    UntreatedOrderMapper untreatedOrderMapper;

    @Autowired
    ProcesserOrderMapper processerOrderMapper;

    @Autowired
    EvaluationMapper evaluationMapper;
    public List<OrderEntity> personOrder(UserAccount user)
    {

        List<OrderEntity> orderEntityList=new ArrayList<>();
        /*
         * 查询未处理订单
         */
        //查询订单内容
        List<UntreatedOrder> untreatedOrders=untreatedOrderMapper.InquireOrder(user.getOpenId());

        for (UntreatedOrder untreatedOrder:untreatedOrders)
        {
            OrderEntity unOrderEntity=new OrderEntity();



            //构造订单
            //添加订单内容
            unOrderEntity.setUntreatedOrder(untreatedOrder);
            //添加订单接单商家列表
            unOrderEntity.setTakeOderCompanyList(gainTakeOderCompany(untreatedOrder.getOrderId()));
            unOrderEntity.setType(0);
            unOrderEntity.setOrderWxName(user.getWxName());
            unOrderEntity.setOrderHeadPortrait(user.getHeadPortrait());
            orderEntityList.add(unOrderEntity);
        }

        /**
         * 已经处理订单查询
         */
        //查询订单内容
        List<ProcesserOrder> processerOrderList=processerOrderMapper.selectByOpenId(user.getOpenId());
        for (ProcesserOrder processerOrder:processerOrderList)
        {
            //已处理订单实体类
            OrderEntity processerOrderEntity=new OrderEntity();

            //获取处理此订单的商家
            ComQualification comQualification=comQualificationMaper.inquireByOpenid(processerOrder.getHandler());
            TakeOrder takeOrder=takeOrderMapper.selectByOrderIdAMerchantId(processerOrder.getOrderId(),processerOrder.getHandler());
            TakeOderCompany takeOderCompany=new TakeOderCompany(comQualification,takeOrder);

            //查询对此订单的评价
            Evaluation evaluation=evaluationMapper.selectByOpenIdAOrderId(user.getOpenId(),processerOrder.getOrderId());
            if (evaluation!=null)
            {
                processerOrderEntity.setEvaluation(evaluation);
            }

            //构造订单
            processerOrderEntity.setProcesserOrder(processerOrder);

            processerOrderEntity.setOrderWxName(user.getWxName());
            processerOrderEntity.setOrderHeadPortrait(user.getHeadPortrait());
            processerOrderEntity.setType(1);
            processerOrderEntity.setTakeOderCompany(takeOderCompany);
            orderEntityList.add(processerOrderEntity);

        }

        return orderEntityList;
    }

    /**
     * 获取一个未处理订单的所有接单者
     * @param oderId
     * @return
     */
    @Autowired
    TakeOrderMapper takeOrderMapper;
    @Autowired
    ComQualificationMaper comQualificationMaper;
    public List<TakeOderCompany> gainTakeOderCompany(String orderId)
    {
        //接单商家列表
        List<TakeOderCompany> takeOderCompanyList=new ArrayList<>();


        List<TakeOrder> takeOrderList=takeOrderMapper.selectByOrderId(orderId);
        for (TakeOrder takeOrder:takeOrderList)
        {
            //构造接单商家实体对象
            TakeOderCompany takeOderCompany=new TakeOderCompany();

            //获取商家信息
            ComQualification comQualification=comQualificationMaper.inquireByOpenid(takeOrder.getMerchantId());
            takeOderCompany.setComQualification(comQualification);
            takeOderCompany.setTakeOrder(takeOrder);

            //加入列表
            takeOderCompanyList.add(takeOderCompany);

        }

        return takeOderCompanyList;
    }

}
