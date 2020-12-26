package com.Wxapp.service;

import com.Wxapp.dao.UserAccount;
import com.Wxapp.mapper.UserMapper;
import com.Wxapp.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 检测token,
 * @author ding
 */
@Service
public class CheckTokenService {

    @Autowired
    private UserMapper usermapper;


    public UserAccount CheckToken(String token){

        UserAccount user;
        if(null==token){
            return null;
        }else {
            String openid= TokenUtils.analyToken(token);
            user=usermapper.queryUserByOpenId(openid);
        }
        return user;
    }
}
