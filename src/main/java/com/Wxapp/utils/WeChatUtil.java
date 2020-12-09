package com.Wxapp.utils;

import java.util.Map;
import com.Wxapp.common.wechat;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 微信小程序工具类
 */

public class WeChatUtil {

    static wechat wc=new wechat();
    static RestTemplate restTemplate=new RestTemplate();


    public static JSONObject GetRequest(String js_code,Map<String, String> requestMap){
        String url = wc.WxUR+"appid=" + wc.AppID + "&secret=" + wc.AppSecret + "&js_code=" + js_code
                    + "&grant_type=authorization_code";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class,requestMap);
        JSONObject jsonObject=JSONObject.parseObject(responseEntity.getBody());
        return jsonObject;
    }
}

