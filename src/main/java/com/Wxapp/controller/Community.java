package com.Wxapp.controller;

import com.Wxapp.entity.Result;
import com.Wxapp.service.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;

/**
 * @author ding
 * 社区应用层
 */
@Controller
public class Community {


    /**
     * 社区页面加载请求数据
     * @param token
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "CommunityOnload",method = RequestMethod.POST)
    public Result communityOnload(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=gainCommunityService.service(token,data);
        return  result;
    }


    /**
     * 发布社区
     * @param token
     * @param data
     * @return
     */
    @Autowired
    PostCommunityService postCommunityService=new PostCommunityService();
    @ResponseBody
    @RequestMapping(value = "PostCommunity",method = RequestMethod.POST)
    public Result postCommunity(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=postCommunityService.service(token,data);
        return  result;
    }


    /**
     * 获取社区内容
     * @param token
     * @param data
     * @return
     */
    @Autowired
    GainCommunityService gainCommunityService=new GainCommunityService();
    @ResponseBody
    @RequestMapping(value = "GainCommunity",method = RequestMethod.POST)
    public Result gainCommunity(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=gainCommunityService.service(token,data);
        return  result;
    }


    /**
     * 社区评论
     * @param token
     * @param data
     * @return
     */
    @Autowired
    CommunityCommentService communityCommentService=new CommunityCommentService();
    @ResponseBody
    @RequestMapping(value = "CommunityComment",method = RequestMethod.POST)
    public  Result communityComment(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=communityCommentService.service(token, data);
     return result;
    }


    /**
     * 社区点赞
     * @param token
     * @param data
     * @return
     */
    @Autowired
    CommunityLikeService communityLikeService=new CommunityLikeService();
    @ResponseBody
    @RequestMapping(value = "communityLike",method = RequestMethod.POST)
    public Result communityLike(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=communityLikeService.service(token,data);
        return result;
    }

    /**
     * 收藏
     * @param token
     * @param data
     * @return
     */
    @Autowired
    CollectCommunityService collectCommunityService=new CollectCommunityService();
    @ResponseBody
    @RequestMapping(value = "CollectCommunity",method = RequestMethod.POST)
    public Result collectCommunity(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=collectCommunityService.service(token,data);
        return result;
    }

}
