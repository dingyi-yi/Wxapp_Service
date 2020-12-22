package com.Wxapp.controller;

import com.Wxapp.entity.Result;
import com.alibaba.fastjson.JSONObject;
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
     * @param dat
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "CommunityOnload",method = RequestMethod.POST)
    public Result communityOnload(@RequestHeader("token") String token, @RequestBody JSONObject dat)
    {
        return null;
    }

}
