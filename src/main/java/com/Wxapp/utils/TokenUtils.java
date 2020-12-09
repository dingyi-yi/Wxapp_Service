package com.Wxapp.utils;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import java.util.HashMap;
public class TokenUtils {

    //过期时间为一天
    private static long EXPIRE_TIME = 24*60*60*1000;
    public static String getToken(JSONObject ob) {
        String token="";
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(ob.get("code").toString());
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        token=JWT.create()
                .withHeader(header)
                .withClaim("openid",ob.get("openid").toString())
                .withExpiresAt(date)
                .sign(algorithm);

        return token;
    }

    public static String analyToken(String token){

        String openid = JWT.decode(token).getClaim("openid").asString();

        return  openid;

    }
}
