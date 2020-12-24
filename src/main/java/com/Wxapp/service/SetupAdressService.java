package com.Wxapp.service;

import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.CommunityEntity;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.UserMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ding
 * 设置地址数据服务层
 */
@Service
public class SetupAdressService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    UserMapper userMapper;

    public Result service(String token, JSONObject data)
    {
        Result result=new Result();

        //检测用户
        UserAccount user= checkTokenService.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }


         /*
         获取参数
          */
        //地址
        String address=data.getString("Address");
        //经度
        double lon= (double) data.get("Longitude");
        //纬度
        double lat=(double)data.get("Latitude");

        user.setAddress(address);
        user.setLon(lon);
        user.setLat(lat);

        //更新数据库
        userMapper.updateAdress(user.getOpenId(),address,lon,lat);

        result.setCode(1);
        result.setRepMess("更新成功");
        result.addJsonData("User",user);


        return result;
    }
}
