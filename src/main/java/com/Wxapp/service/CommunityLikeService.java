package com.Wxapp.service;

import com.Wxapp.dao.CommunityLike;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.CommunityContentMapper;
import com.Wxapp.mapper.CommunityLikeMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ding
 * 社区点赞数添加
 */
@Service
public class CommunityLikeService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    CommunityLikeMapper communityLikeMapper;

    @Autowired
    CommunityContentMapper communityContentMapper;

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
       //社区CommunityId
        String communityId=data.getString("CommunityId");

        //构造社区点赞实体对象
        CommunityLike communityLike=new CommunityLike(user.getOpenId(),communityId,user.getWxName(), user.getHeadPortrait(),new Date());

        //更新社区内容点赞数
        communityContentMapper.updateLikeNumber(communityId);

        //写入社区点赞数据库表
        communityLikeMapper.insertCommunityLike(communityLike);

        result.addJsonData("CommunityLike",communityLike);
        result.setCode(1);
        result.setRepMess("点赞成功");

        return result;
    }
}
