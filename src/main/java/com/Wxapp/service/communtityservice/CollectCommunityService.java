package com.Wxapp.service.communtityservice;

import com.Wxapp.dao.userdao.Collect;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.CollectMapper;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ding
 * 收藏订单服务
 */
@Service
public class CollectCommunityService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    CollectMapper collectMapper;

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
        String CommunityId=data.getString("CommunityId");

        //判断是否已经收藏
        if (collectMapper.selectByOpenIdACommunityId(user.getOpenId(), CommunityId)!=null)
        {
            result.setCode(0);
            result.setRepMess("已经收藏");
            return  result;
        }

        /*
        收藏实体类
         */
        Collect collect=new Collect(user.getOpenId(),CommunityId);

        //写入数据库
        collectMapper.insertCollect(collect);



        result.setCode(1);
        result.setRepMess("收藏成功");

        return result;
    }
}
