package com.Wxapp.controller;


import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.SingleResult;
import com.Wxapp.service.LoginService;
import com.Wxapp.utils.TokenUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class weChatLogin {

    @Autowired
    LoginService service=new LoginService();

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public SingleResult<String> Login(String code,String nickName,String avatarUrl){

        SingleResult<String> result = new SingleResult<String>();


        //调用service.loginservice.wechatlogin 去检查openid
        JSONObject loginresult=service.weChatLogin(code,nickName,avatarUrl);

        if(null==loginresult.get("user")){
            result.setCode(0);
            result.setMessage("登陆失败");
        }else {

            //允许登陆，下发token
            UserAccount user= (UserAccount) loginresult.get("user");
            JSONObject ob=new JSONObject();
            ob.put("openid",user.getOpenId());
            ob.put("code",code);
            String token= TokenUtils.getToken(ob);

            result.setUser(user);
            result.setCode(1);
            result.setMessage("登陆成功");
            result.setToken(token);

        }

        return  result;
    }
}
