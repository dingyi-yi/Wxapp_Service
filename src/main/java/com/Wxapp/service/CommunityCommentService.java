package com.Wxapp.service;

import com.Wxapp.dao.CommunityComment;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.CaseContentMapper;
import com.Wxapp.mapper.CommunityCommentMapper;
import com.Wxapp.mapper.CommunityContentMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ding
 * 社区评论数据服务层
 */
@Service
public class CommunityCommentService {


    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    CommunityCommentMapper communityCommentMapper;

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
        //评论内容
        String commentContent=data.getString("CommentContent");

        //构造评论实体类
        CommunityComment communityComment=new CommunityComment(communityId,user.getWxName(), user.getHeadPortrait(), commentContent,new Date());

        //更新社区内容中评论数
        communityContentMapper.updateCommentNumber(communityId);

        //写入社区评论数据库
        communityCommentMapper.insertCommunityComment(communityComment);

        result.addJsonData("CommunityComment",communityComment);
        result.setCode(1);
        result.setRepMess("评论成功");



        return result;
    }
}
