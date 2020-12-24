package com.Wxapp.controller;

import com.Wxapp.entity.Result;
import com.Wxapp.service.CommunityCommentService;
import com.Wxapp.service.GainCommunityService;
import com.Wxapp.service.PostCommunityService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    @RequestMapping(value = "communityLike",method = RequestMethod.POST)
    public Result communityLike(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        return null;
    }

}
