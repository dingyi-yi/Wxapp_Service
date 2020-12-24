package com.Wxapp.controller;



import com.Wxapp.entity.Result;
import com.Wxapp.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class weChatLogin {

    @Autowired
    LoginService loginService=new LoginService();

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result Login(@RequestBody JSONObject data){

        Result result=loginService.service(data);

        return result;

    }
}
