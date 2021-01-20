package com.Wxapp.service.orderservice;

import com.Wxapp.dao.merchantdao.ComQualification;
import com.Wxapp.dao.orderdao.TakeOrder;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.TakeOrderMapper;
import com.Wxapp.mapper.ComQualificationMaper;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ding
 * 接单服务层
 */
@Service
public class TakeOrderService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();



    @Autowired
    ComQualificationMaper comqualificationmaper;

    @Autowired
    TakeOrderMapper takeOrderMapper;


    public Result service(String token, JSONObject data)
    {
        Result result=new Result();
        //检测用户
        UserAccount user= checkTokenService.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }

        //获取订单号
        String orderId =data.get("orderId").toString();
        //获取预期价格
        int expectedPrice = (int)data.get("ExpectedPrice");
        //获取预期维修方案
        String expectedScheme =data.getString("ExpectedScheme");


        //获取商家信息
        ComQualification comQualification=comqualificationmaper.inquireByOpenid(user.getOpenId());
        if (comQualification==null)
        {
            result.setCode(0);
            result.setRepMess("先注册为商家");
            return result;
        }

        //构造接单实体类
        TakeOrder takeOrder=new TakeOrder();
        takeOrder.setOrderId(orderId);
        takeOrder.setMerchantId(user.getOpenId());
        takeOrder.setExpectedPrice(expectedPrice);
        takeOrder.setExpectedScheme(expectedScheme);


        //写入数据库
        takeOrderMapper.insertTakeOrder(takeOrder);
        result.setCode(1);
        result.setRepMess("成功");

        return result;
    }

}
