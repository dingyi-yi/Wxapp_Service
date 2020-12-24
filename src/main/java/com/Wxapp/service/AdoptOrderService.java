package com.Wxapp.service;

import com.Wxapp.dao.ComQualification;
import com.Wxapp.dao.ProcesserOrder;
import com.Wxapp.dao.UntreatedOrder;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.ProcesserOrderMapper;
import com.Wxapp.mapper.UntreatedOrderMapper;
import com.Wxapp.mapper.ComQualificationMaper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ding
 * 接单服务层
 */
@Service
public class AdoptOrderService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    UntreatedOrderMapper untreatedOrderMapper;

    @Autowired
    ComQualificationMaper comqualificationmaper;

    @Autowired
    ProcesserOrderMapper processerOrderMapper;

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
        String OrderId=data.get("OrderId").toString();

        //获取订单内容
        UntreatedOrder untreatedOrder=untreatedOrderMapper.inquireByOrderId(OrderId);

        //获取商家信息
        ComQualification comQualification=comqualificationmaper.inquireByOpenid(user.getOpenId());
        if (comQualification==null)
        {
            result.setCode(0);
            result.setRepMess("先注册为商家");
            return result;
        }

        //构造已处理订单
        ProcesserOrder processerOrder=new ProcesserOrder(untreatedOrder);
        processerOrder.setEndTime(new Date());
        processerOrder.setHandler(user.getOpenId());
        processerOrder.setState(1);

        /**
         * 更新数据库
         */
        //添加已处理订单
        processerOrderMapper.insertProcesserOrder(processerOrder);
        //删除未处理订单
        untreatedOrderMapper.deleteByOrderId(untreatedOrder.getOrderId());

        /**
         * 通知用户
         */

         result.setCode(1);
         result.setRepMess("接单成功");
         result.addJsonData("Order",untreatedOrder);

        return result;
    }

}
