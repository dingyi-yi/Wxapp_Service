package com.Wxapp.service;

import com.Wxapp.dao.CommunityContent;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.CommunityEntity;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.CommunityContentMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ding
 * 获取社区数据服务层
 */
@Service
public class GainCommunityService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    CommunityContentMapper communityContentMapper;

    public Result service(String token, JSONObject data)
    {

        Result<CommunityEntity> result=new Result();

        //检测用户
        UserAccount user= checkTokenService.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }

        //社区列表
        List<CommunityEntity> communityEntityList =new ArrayList<>();



        //社区内容列表


        return  result;

    }

    public List<CommunityContent> CommunityMethod(JSONObject data)
    {
        List<CommunityContent> communityContentList;

        return null;
    }

}
