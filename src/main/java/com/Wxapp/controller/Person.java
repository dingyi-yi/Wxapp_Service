package com.Wxapp.controller;

import com.Wxapp.entity.Result;
import com.Wxapp.service.GainOrderService;
import com.Wxapp.service.LicencedHouseService;
import com.Wxapp.service.SetupAdressService;
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

}
