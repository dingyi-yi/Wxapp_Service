package com.Wxapp.service.userservice;

import com.Wxapp.dao.communtitydao.CommunityComment;
import com.Wxapp.dao.communtitydao.CommunityContent;
import com.Wxapp.dao.communtitydao.CommunityImage;
import com.Wxapp.dao.communtitydao.CommunityLike;
import com.Wxapp.dao.userdao.Collect;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.CommunityEntity;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.*;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * 个人收藏数据服务层
 */
@Service
public class PersonCollectService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    CollectMapper collectMapper;

    @Autowired
    CommunityContentMapper communityContentMapper;

    @Autowired
    CommunityImageMapper communityImageMapper;

    @Autowired
    CommunityLikeMapper communityLikeMapper;

    @Autowired
    CommunityCommentMapper communityCommentMapper;

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

        //社区实体对象列表
        List<CommunityEntity> communityEntityList=new ArrayList<>();

        //获取所有的收藏
        List<Collect> collectList=collectMapper.selectByOpenId(user.getOpenId());

        for (Collect collect:collectList)
        {
            CommunityEntity communityEntity=new CommunityEntity();
            //社区发布者
            UserAccount userAccount=userMapper.queryUserByOpenId(collect.getOpenId());
            //社区内容
            CommunityContent communityContent=communityContentMapper.selectBycommunityId(collect.getCommunityId());
            //社区图片
            List<CommunityImage> communityImageList=communityImageMapper.selectByCommunityId(collect.getCommunityId());
            //社区评论
            List<CommunityComment> communityCommentList=communityCommentMapper.selectByCommunityId(collect.getCommunityId());
            //社区点赞
            List<CommunityLike> communityLikeList=communityLikeMapper.selectByCommunityId(collect.getCommunityId());

            //判断该用户是否为此社区点赞了
            CommunityLike communityLike=communityLikeMapper.selectByOpenIdACommunityId(user.getOpenId(),communityContent.getCommunityId());

            communityEntity.setCollect(true);
            communityEntity.setLike(communityLike != null);
            communityEntity.setCommunityContent(communityContent);
            communityEntity.setCommunityImageList(communityImageList);
            communityEntity.setCommunityLike(communityLikeList);
            communityEntity.setCommunityComment(communityCommentList);
            communityEntity.setCommunityWxName(userAccount.getWxName());
            communityEntity.setCommunityHeadPortrait(userAccount.getHeadPortrait());

            //加入社区实体类列表
            communityEntityList.add(communityEntity);
        }


        result.setCode(1);
        result.setRepMess("查询成功");
        result.setListData(communityEntityList);

        return result;
    }
}
