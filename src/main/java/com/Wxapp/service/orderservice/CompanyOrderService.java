package com.Wxapp.service.orderservice;

import com.Wxapp.dao.merchantdao.Evaluation;
import com.Wxapp.dao.orderdao.ProcesserOrder;
import com.Wxapp.dao.orderdao.TakeOrder;
import com.Wxapp.dao.orderdao.UntreatedOrder;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.OrderEntity;
import com.Wxapp.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * 获取有关商家的订单
 */
@Service
public class CompanyOrderService {


    @Autowired
    ProcesserOrderMapper processerOrderMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    UntreatedOrderMapper untreatedOrderMapper;

    @Autowired
    TakeOrderMapper takeOrderMapper;

    @Autowired
    EvaluationMapper evaluationMapper;

    public List<OrderEntity> companyOrder(UserAccount user)
    {
        //订单列表
        List<OrderEntity> orderEntityList =new ArrayList<>();

        /*
         查询商家处理的订单
         */
        //订单内容
        List<ProcesserOrder> processerOrderList=new ArrayList<>();
        processerOrderList=processerOrderMapper.selectByHandler(user.getOpenId());

        for (ProcesserOrder processerOrder:processerOrderList)
        {
            //订单实体
            OrderEntity prOrderEntity=new OrderEntity();

            //获取订单发布者
            UserAccount pushUser=userMapper.queryUserByOpenId(processerOrder.getOpenId());

            //获取这条订单的评价
            Evaluation evaluation=evaluationMapper.selectByMerchantIdAOrderId(user.getOpenId(),processerOrder.getOpenId());
            if (evaluation!=null)
            {
                prOrderEntity.setEvaluation(evaluation);
            }


            prOrderEntity.setType(1);
            prOrderEntity.setProcesserOrder(processerOrder);
            prOrderEntity.setOrderWxName(pushUser.getWxName());
            prOrderEntity.setOrderHeadPortrait(pushUser.getHeadPortrait());

            orderEntityList.add(prOrderEntity);
        }

        /*
        获取商家接单的
         */
        List<UntreatedOrder> untreatedOrderList=new ArrayList<>();
        List<TakeOrder> takeOrderList=new ArrayList<>();
        takeOrderList=takeOrderMapper.selectByMerchantId(user.getOpenId());
        //根据商家的接单，来获取发布的订单
        for(TakeOrder takeOrder:takeOrderList)
        {
            UntreatedOrder untreatedOrder=new UntreatedOrder();
            untreatedOrder=untreatedOrderMapper.inquireByOrderId(takeOrder.getOrderId());
            untreatedOrderList.add(untreatedOrder);
        }

        for (UntreatedOrder untreatedOrder:untreatedOrderList)
        {
            //订单实体类
            OrderEntity orderEntity=new OrderEntity();
            UserAccount pushUser=userMapper.queryUserByOpenId(untreatedOrder.getOpenId());

            //订单实体类复值
            orderEntity.setOrderHeadPortrait(pushUser.getHeadPortrait());
            orderEntity.setOrderWxName(pushUser.getWxName());
            orderEntity.setUntreatedOrder(untreatedOrder);
            orderEntity.setTakeOrder(true);


            orderEntityList.add(orderEntity);
        }



        return orderEntityList;
    }

}
