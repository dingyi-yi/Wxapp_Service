package com.Wxapp.service;

import com.Wxapp.dao.Order;
import com.Wxapp.dao.OrderImage;
import com.Wxapp.dao.UntreatedOrder;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.OrderImageMapper;
import com.Wxapp.mapper.UntreatedOrderMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * 订单查询服务
 */
@Service
public class OrderInquiryService {

    @Autowired
    CheckTokenService checktoken=new CheckTokenService();

    @Autowired
    OrderImageMapper orderImageMapper;

    @Autowired
    UntreatedOrderMapper untreatedOrderMapper;



    public Result Service(String token, JSONObject data)
    {
        Result result=new Result();
        //检测用户
        UserAccount user= checktoken.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }

        //订单列表
        List<Order> orderList=new ArrayList<>();
        /**
         * 查询未处理订单
         */
         //查询订单内容
        List<UntreatedOrder> untreatedOrders=untreatedOrderMapper.InquireOrder(user.getOpenId());
        for (UntreatedOrder order:untreatedOrders)
        {
            Order<UntreatedOrder> untreatedOrderOrder=new Order<UntreatedOrder>();
            //查询该订单所有的图片
            List<OrderImage> orderImages=orderImageMapper.inquireOrderImage(order.getOrderId());

            //构造订单
            untreatedOrderOrder.setOrder(order);
            untreatedOrderOrder.setOrderImages(orderImages);

            //将该订单加入订单列表
            orderList.add(untreatedOrderOrder);

        }

        /**
         * 未处理订单查询
         */



        //构造返回结果
        result.setCode(1);
        result.setRepMess("订单查询成功");
        result.setListData(orderList);
        result.setJsonData(null);


        return result;
    }

}
