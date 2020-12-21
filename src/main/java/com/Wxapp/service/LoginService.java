package com.Wxapp.service;

import com.Wxapp.common.wechat;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.mapper.userMapper;
import com.Wxapp.utils.WeChatUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    wechat wc=new wechat();
    private RestTemplate restTemplate=new RestTemplate();

    @Autowired
    userMapper usermapper;

    public JSONObject  weChatLogin(String js_code){

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appid", wc.AppID);
        requestMap.put("secret", wc.AppSecret);
        requestMap.put("code", js_code);

        //使用工具类，向微信官方索要openId
        JSONObject result=WeChatUtil.GetRequest(js_code,requestMap);

        if (null==result.get("errcode")){
            //去检查数据库中是否有该openid
            UserAccount user = usermapper.queryUserByOpenId(result.get("openid").toString());
            if(null==user ){
                // 不存在，就是第一次登录：新建用户信息
                user=new UserAccount();
                user.setOpenId(result.get("openid").toString());
                user.setLasttime(new Date());
                usermapper.addUser(user);
                result.put("user",user);
            }else {
                //找到的话更新最后登陆时间
                user.setLasttime(new Date());
                usermapper.updatetime(user);
                result.put("user",user);

            }

        }else {
            return result;
        }
        return result;
    }
}
