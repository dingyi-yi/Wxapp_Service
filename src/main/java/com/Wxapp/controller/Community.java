package com.Wxapp.controller;

import com.Wxapp.entity.Result;
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
        return null;
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



    @ResponseBody
    @RequestMapping(value = "gainCommunity",method = RequestMethod.POST)
    public Result gainCommunity(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        return null;
    }

}
