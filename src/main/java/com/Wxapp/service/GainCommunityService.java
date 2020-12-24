package com.Wxapp.service;

import com.Wxapp.dao.*;
import com.Wxapp.entity.CommunityEntity;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ding
 * 获取社区数据服务层
 */
@Service
public class GainCommunityService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

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

    @Autowired
    CollectMapper collectMapper;

    public Result service(String token, JSONObject data,int way)
    {

        Result<CommunityEntity> result=new Result();

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
        //家电种类
        String communityKind=data.getString("CommunityKind");
        //搜索内容
        String searchContent=data.getString("SearchContent");
        searchContent="#"+searchContent;



        //社区实体列表
        List<CommunityEntity> communityEntityList=new ArrayList<>();


        //社区内容列表
        //way=1,为时间排序
        List<CommunityContent> communityContentList=communityMethod(communityKind,searchContent,way,user.getOpenId());

        //计数器，只记录20个

        int index=0;
        //根据社区内容，构造社区实体类
        for (CommunityContent communityContent:communityContentList)
        {
            index++;
            //社区实体类
            CommunityEntity communityEntity=new CommunityEntity();

            //社区发布者
            UserAccount userAccount=userMapper.queryUserByOpenId(communityContent.getOpenId());

            //社区图片
            List<CommunityImage> communityImageList=communityImageMapper.selectByCommunityId(communityContent.getCommunityId());
            //社区评论
            List<CommunityComment> communityCommentList=communityCommentMapper.selectByCommunityId(communityContent.getCommunityId());
            //社区点赞
            List<CommunityLike> communityLikeList=communityLikeMapper.selectByCommunityId(communityContent.getCommunityId());

            //判断该用户是否为此社区点赞了
            CommunityLike communityLike=communityLikeMapper.selectByOpenIdACommunityId(user.getOpenId(),communityContent.getCommunityId());
            //判断用户是否收藏
            Collect collect=collectMapper.selectByOpenIdACommunityId(user.getOpenId(),communityContent.getCommunityId());

            //构造社区实体类
            communityEntity.setCommunityContent(communityContent);
            communityEntity.setCommunityImageList(communityImageList);
            communityEntity.setCommunityComment(communityCommentList);
            communityEntity.setCommunityLike(communityLikeList);
            communityEntity.setCommunityWxName(userAccount.getWxName());
            communityEntity.setCommunityHeadPortrait(user.getHeadPortrait());
            communityEntity.setLike(communityLike != null);
            communityEntity.setCollect(collect!=null);

            //加入社区实体类列表
            communityEntityList.add(communityEntity);
            if (index>20)
            {
                break;
            }

        }

        result.setCode(1);
        result.setRepMess("查询成功");
        result.setListData(communityEntityList);

        return  result;

    }

    /**
     * 处理显示方式
     * @param communityKind 种类
     * @param searchContent 搜索内容
     * @param way 方式
     * @return
     */
    public List<CommunityContent> communityMethod(String communityKind,String searchContent,int way,String OpenId)
    {
        List<CommunityContent> communityContentList=new ArrayList<>();

        if (way==1 || way==2)
        {//页面加载时，或者查询时
            communityContentList=communityContentMapper.selectByKindADescription(communityKind,searchContent);
        }else if (way==3){
            communityContentList=communityContentMapper.selectByOpenId(OpenId);
        }




        return communityContentList;
    }

}
