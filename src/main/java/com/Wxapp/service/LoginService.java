package com.Wxapp.service;

import com.Wxapp.common.wechat;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.UserPortraitMapper;
import com.Wxapp.mapper.UserMapper;
import com.Wxapp.utils.TokenUtils;
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
    UserMapper usermapper;

    @Autowired
    UserPortraitMapper userPortraitMapper;

   public Result service(JSONObject data) {
       Result result = new Result();

       String code = data.getString("code");
       String nickName = data.getString("nickName");
       String avatarUrl = data.getString("avatarUrl");

       if (code == null || avatarUrl==null) {
           result.setCode(0);
           result.setRepMess("登陆失败，请重新登陆");
           return result;
       }

       Map<String, String> requestMap = new HashMap<>();
       requestMap.put("appid", wc.AppID);
       requestMap.put("secret", wc.AppSecret);
       requestMap.put("code", code);

       //使用工具类，向微信官方索要openId
       JSONObject openidresult = WeChatUtil.GetRequest(code, requestMap);


       if (openidresult.get("errcode") != null) {
           result.setCode(0);
           result.setRepMess("登陆失败，请重新登陆");
           return result;
       }
       //获取用户openid
       String openid = openidresult.getString("openid");
       //去检查数据库中是否有该openid
       UserAccount user = usermapper.queryUserByOpenId(openid);

       if (user == null) {
           // 不存在，就是第一次登录：新建用户信息
           user = new UserAccount();
           user.setOpenId(openid);
           //最后登陆时间
           user.setLastTime(new Date());
           //名称
           user.setWxName(nickName);
           //头像
           user.setHeadPortrait(avatarUrl);
           user.setStatus(0);
           user.setAddress(" ");
           usermapper.addUser(user);

       } else {
           //找到的话更新最后登陆时间
           user.setLastTime(new Date());
           usermapper.updatetime(user);
       }

       /*
       获取token
        */
       JSONObject ob = new JSONObject();
       ob.put("openid", user.getOpenId());
       ob.put("code", code);
       String token = TokenUtils.getToken(ob);

       user.setOpenId("0");
       result.addJsonData("Token",token);
       result.addJsonData("User",user);
       result.setCode(1);
       result.setRepMess("登陆成功");

       return result;
   }

}
