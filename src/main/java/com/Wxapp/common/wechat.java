package com.Wxapp.common;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wechat")
public class wechat {
    public String AppID="wxe1987346697e9ca6";
    public String AppSecret="c6fc253e77feebf2e6f75aa9e44aa00f";
    public String WxUR="https://api.weixin.qq.com/sns/jscode2session?";
}
