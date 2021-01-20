package com.Wxapp.service.merchantdao;

import com.Wxapp.dao.merchantdao.ComQualification;
import com.Wxapp.dao.orderdao.ProcesserOrder;
import com.Wxapp.dao.orderdao.UntreatedOrder;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.ComQualificationMaper;
import com.Wxapp.mapper.ProcesserOrderMapper;
import com.Wxapp.mapper.TakeOrderMapper;
import com.Wxapp.mapper.UntreatedOrderMapper;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ding
 * 用户选择商家服务
 */
@Service
public class ChoseCompanyService {


    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    UntreatedOrderMapper untreatedOrderMapper;

    @Autowired
    ComQualificationMaper comQualificationMaper;

    @Autowired
    ProcesserOrderMapper processerOrderMapper;

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

        /*
        获取参数
         */
        //商家id
        String MerchantId=data.getString("MerchantId");
        //订单id
        String OrderId=data.getString("OrderId");


        if(MerchantId==null || OrderId==null)
        {
            result.setCode(0);
            result.setRepMess("参数传递错误");
            return result;
        }
        //获取该条未处理订单
        UntreatedOrder untreatedOrder=untreatedOrderMapper.inquireByOrderId(OrderId);
        //获取该商家
        ComQualification comQualification=comQualificationMaper.inquireByOpenid(MerchantId);

        //构造已处理订单
        ProcesserOrder processerOrder=new ProcesserOrder(untreatedOrder);
        processerOrder.setState(1);
        processerOrder.setEndTime(new Date());
        processerOrder.setHandler(MerchantId);


        /*
        更新数据库
         */
        //写入该已处理订单
        processerOrderMapper.insertProcesserOrder(processerOrder);
        //删除该未处理订单
        untreatedOrderMapper.deleteByOrderId(OrderId);
        //在接单表中删除未被选择的商家
        takeOrderMapper.deleteUnnecessary(OrderId,MerchantId);


        result.setCode(1);
        result.setRepMess("选择成功");
        return result;
    }

}
