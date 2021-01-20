package com.Wxapp.service.activityservice;

import com.Wxapp.dao.activitydao.ActiveImage;
import com.Wxapp.dao.activitydao.ActivityContent;
import com.Wxapp.dao.merchantdao.ComQualification;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.dao.userdao.UserPortrait;
import com.Wxapp.entity.ActivityEntity;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.*;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ding
 * 获取活动数据服务层
 */
@Service
public class GainActivityService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    UserPortraitMapper userPortraitMapper;

    @Autowired
    ActivityContentMapper activityContentMapper;

    @Autowired
    ActiveImageMapper activeImageMapper;

    @Autowired
    ComQualificationMaper comQualificationMaper;

    @Autowired
    UserMapper userMapper;

    public Result service(String token, JSONObject data,int way)
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

        //活动实体对象列表
        List<ActivityEntity> activityEntityList=new ArrayList<>();


        //获取活动内容列表
        List<ActivityContent> activityContentList=activityMethod(user.getOpenId(),1);

        for (ActivityContent activityContent:activityContentList)
        {
            //活动实体对象
            ActivityEntity activityEntity=new ActivityEntity();

            //活动的内容
            activityEntity.setActivityContent(activityContent);

            //发布活动的用户
            UserAccount userAccount=userMapper.queryUserByOpenId(activityContent.getOpenId());
            activityEntity.setTradeMark(userAccount.getHeadPortrait());

            //发布活动的企业
            ComQualification comQualification=comQualificationMaper.inquireByOpenid(activityContent.getOpenId());
            activityEntity.setFirmName(comQualification.getbName());

            //地址
            activityEntity.setActivityAdress(comQualification.getbAdd());

            //获取活动的海报
           // List<ActiveImage> activeImageList=activeImageMapper.selectByActiveId(activityContent.getActiveId());
            List<ActiveImage> activeImageList=new ArrayList<>();
            activityEntity.setActiveImageList(activeImageList);

            activityEntityList.add(activityEntity);
        }

        result.setCode(1);
        result.setRepMess("查询成功");
        result.setListData(activityEntityList);


        return result;
    }

    public List<ActivityContent> activityMethod(String OpenId,int way)
    {
        List<ActivityContent> activityContentList = new ArrayList<>();
        if (way==1)
        {//index页面加载时，根据用户喜欢加载
            String MaintainContent="#";
            //获取用户画像
            UserPortrait userPortrait= userPortraitMapper.selectByOpenid(OpenId);
            if (userPortrait!=null)
            {
                //获取用户维修内容
                MaintainContent=userPortrait.getMaintainContent();
                if (MaintainContent==null)
                {
                    MaintainContent="#";
                }
            }

            activityContentList=activityContentMapper.selectByActiveDescription(MaintainContent,new Date());

        }else if (way==2)
        {//获取商户自己发布的活动
            activityContentList=activityContentMapper.selectByOpenId(OpenId);
        }
        return activityContentList;
    }
}
