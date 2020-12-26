package com.Wxapp.service;


import com.Wxapp.dao.UntreatedOrder;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.UntreatedOrderMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;


/**
 * 发布订单的服务类
 */
@Service
public class PostOrderService {

    @Autowired
    CheckTokenService checktoken=new CheckTokenService();

    @Autowired
    UntreatedOrderMapper UndisOrderMapper;


    public Result Service(String token, JSONObject data) {
        Result result=new Result();

        //获取用户
        UserAccount user= checktoken.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }


        //获取相关参数
        UntreatedOrder order=new UntreatedOrder();
        //生成订单编号
        String OrderId= UUID.randomUUID().toString();
        order.setOpenId(user.getOpenId());
        order.setOrderId(OrderId);

        order.setPAddress(data.get("PAddress").toString());
        order.setPhone(data.get("Phone").toString());
        order.setKind(data.get("Kind").toString());
        order.setServiceType((int) data.get("ServiceType"));
        order.setDescribe(data.get("Describe").toString());
        //订单发布时间
        Date ReleaseTime=new Date();
        //订单预期天数
        int et= (int) data.get("ExpectTime");
        //转换到订单预期时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(ReleaseTime);
        calendar.add(Calendar.DATE,et);
        Date ExpectTime=calendar.getTime();
        //订单发布时间
        order.setReleaseTime(ReleaseTime);
        //订单结束时间
        order.setExpectTime(ExpectTime);
        //订单发布时的经度
        order.setLon((Double) data.get("Longitude"));
        //订单发布时的纬度
        order.setLat((Double) data.get("Latitude"));


        //插入数据库
        UndisOrderMapper.InsertOrder(order);

        result.setCode(1);
        result.setRepMess("发布成功");
        JSONObject da=new JSONObject();
        da.put("OrderId",OrderId);
        result.setJsonData(da);


        return result;
    }
}
