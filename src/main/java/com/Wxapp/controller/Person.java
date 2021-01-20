package com.Wxapp.controller;

import com.Wxapp.dao.merchantdao.Evaluation;
import com.Wxapp.entity.Result;
import com.Wxapp.service.activityservice.GainActivityService;
import com.Wxapp.service.communtityservice.GainCommunityService;
import com.Wxapp.service.merchantdao.ChoseCompanyService;
import com.Wxapp.service.merchantdao.EvaluationService;
import com.Wxapp.service.merchantdao.LicencedHouseService;
import com.Wxapp.service.orderservice.GainOrderService;
import com.Wxapp.service.userservice.PersonCollectService;
import com.Wxapp.service.userservice.SetupAdressService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ding
 * 个人中心
 */
@Controller
public class Person {


    /**
     * 个人订单查询
     * @return
     */
    @Autowired
    GainOrderService gainOrderService=new GainOrderService();
    @ResponseBody
    @RequestMapping(value = "PersonOrder",method = RequestMethod.POST)
    public Result personOrder(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=gainOrderService.service(token,data,1);
        return result;
    }


    /**
     * 注册成为商家
     * @param token
     * @param data
     * @return
     */
    @Autowired
    LicencedHouseService licencedHouseService=new LicencedHouseService();
    @ResponseBody
    @RequestMapping(value = "LicencedHouse",method = RequestMethod.POST)
    public Result licencedHouse(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=licencedHouseService.Service(token,data);
        return result;
    }


    /**
     * 设置默认地址
     * @param token
     * @param data
     * @return
     */
    @Autowired
    SetupAdressService setupAdressService=new SetupAdressService();
    @ResponseBody
    @RequestMapping(value = "SetupAdress",method = RequestMethod.POST)
    public Result setupAdress(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=setupAdressService.service(token,data);
        return result;
    }


    /**
     * 个人收藏
     * @param token
     * @param data
     * @return
     */
    @Autowired
    PersonCollectService personCollectService=new PersonCollectService();
    @ResponseBody
    @RequestMapping(value = "PersonCollect",method = RequestMethod.POST)
    public Result personCollect(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=personCollectService.service(token,data);
        return result;
    }

    /**
     * 个人社区获取
     */
    @Autowired
    GainCommunityService gainCommunityService=new GainCommunityService();
    @ResponseBody
    @RequestMapping(value = "PersonCommunity",method = RequestMethod.POST)
    public Result personCommunity(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result= gainCommunityService.service(token,data,3);
        return result;
    }


    /**
     * 个人活动获取
     * @param token
     * @param data
     * @return
     */
    @Autowired
    GainActivityService gainActivityService=new GainActivityService();
    @ResponseBody
    @RequestMapping(value = "PersonActivity",method = RequestMethod.POST)
    public Result personActivity(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=gainActivityService.service(token,data,2);
        return result;
    }


    /**
     * 用户选择商家
     * @param token
     * @param data
     * @return
     */
    @Autowired
    ChoseCompanyService choseCompanyService=new ChoseCompanyService();
    @ResponseBody
    @RequestMapping(value = "ChoseCompany",method = RequestMethod.POST)
    public  Result choseCompany(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=choseCompanyService.service(token,data);
        return result;
    }


    @Autowired
    EvaluationService evaluationService=new EvaluationService();
    @ResponseBody
    @RequestMapping(value = "Evaluation",method = RequestMethod.POST)
    public  Result evaluation(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        return evaluationService.service(token,data);
    }


}
