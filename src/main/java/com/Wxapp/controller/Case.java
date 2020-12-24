package com.Wxapp.controller;

import com.Wxapp.entity.Result;
import com.Wxapp.service.GainCaseService;
import com.Wxapp.service.PostCaseService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 案例类，处理从case页面发送来的请求
 */
@Controller
public class Case {

    /**
     * 案例页面加载时，需要请求的数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "CaseLoad",method = RequestMethod.POST)
    public Result caseLoad(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=gainCaseService.service(token,data);
        return result;
    }

    /**
     * 发布案例
     * @param token
     * @param data
     * @return
     */
    @Autowired
    PostCaseService postCaseService=new PostCaseService();
    @ResponseBody
    @RequestMapping(value = "PostCase",method = RequestMethod.POST)
    public Result postCase(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=postCaseService.service(token,data);
        return result;
    }


    /**
     * 案例查询服务
     * @param token
     * @param data
     * @return
     */
    @Autowired
    GainCaseService gainCaseService=new GainCaseService();
    @ResponseBody
    @RequestMapping(value = "GainCase",method = RequestMethod.POST)
    public Result gainCase(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=gainCaseService.service(token,data);
        return result;
    }



}
