package com.Wxapp.service.communtityservice;

import com.Wxapp.dao.communtitydao.CommunityContent;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.CommunityContentMapper;
import com.Wxapp.mapper.UserMapper;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author ding
 * 发布社区数据服务层
 */
@Service
public class PostCommunityService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    CommunityContentMapper communityContentMapper;

    @Autowired
    UserMapper userMapper;

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



        /**
         * 获取参数
         */
        //发布的种类
        String communityKind =data.getString("CommunityKind");
        //发布的内容
        String communityDescription =data.getString("CommunityDescription");
        communityDescription='#'+communityDescription;

        /**
         * 构造订单内容实体类
         */
        //生成活动编号
        String communityId = UUID.randomUUID().toString();
        //社区内容类
        CommunityContent communityContent=new CommunityContent(user.getOpenId(),communityId,communityKind,
                communityDescription,new Date(),0,0);

        //写入数据库
        communityContentMapper.insertCommunityContent(communityContent);
        userMapper.upadteGolCoin(user.getOpenId(),5);


        result.setCode(1);
        result.setRepMess("发布成功");
        result.addJsonData("CommunityContent",communityContent);

        return result;
    }


}
