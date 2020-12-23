package com.Wxapp.service;

import com.Wxapp.dao.ActivityContent;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.ActivityContentMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author ding
 * 发布活动服务层
 */
@Service
public class PostActivityService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    ActivityContentMapper activityContentMapper;


    public Result service(String token, JSONObject data){

        Result result=new Result();
        //检测用户
        UserAccount user= checkTokenService.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }
        //检测是否为商家
        if(1!=user.getStatus())
        {
            result.setCode(0);
            result.setRepMess("请先注册为商家");
            return null;
        }

        //生成活动编号
        String activeId = UUID.randomUUID().toString();
        //活动名称
        String activeName =data.getString("ActiveName");
        //活动开始时间
        Date startTime= data.getDate("StartTime");
        //活动结束时间
        Date endTime=data.getDate("EndTime");
        //活动描述
        String activeDescription=data.getString("ActiveDescription");

        //构造活动内容对象
        ActivityContent activityContent=new ActivityContent(user.getOpenId(),activeId,activeName,startTime,endTime,activeDescription);

        //写入数据库
        activityContentMapper.insertActivityContent(activityContent);

        result.setCode(1);
        result.setRepMess("发布成功");
        result.addJsonData("Activity",activityContent);

        return result;
    }
}
