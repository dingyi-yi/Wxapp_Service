package com.Wxapp.controller;


import com.Wxapp.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;



@RestController
public class testtoken {

    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public String test(@RequestHeader("token") String token,@RequestBody String question){
        System.out.println(token);
        System.out.println(question);
        String openid= TokenUtils.analyToken(token);
        if(openid==null){
            return null;
        }else {
            return "aaaaa";
        }

    }
}
