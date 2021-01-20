package com.Wxapp.service;

import com.Wxapp.dao.activitydao.ActiveImage;
import com.Wxapp.dao.casesharedao.CaseImage;
import com.Wxapp.dao.communtitydao.CommunityImage;
import com.Wxapp.dao.orderdao.OrderImage;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.*;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ding
 * 获取图片服务层
 */
@Service
public class DownloadFileService {
    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

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
        int way= (int) data.get("Type");
        String OAId=data.getString("OAId");
        if (data.get("Type")==null|| OAId== null)
        {
            result.setCode(0);
            result.setRepMess("参数无效");
            return result;
        }


        if (way==1)
        {
            result.setListData(orderImage(OAId));
        }else if (way==2)
        {
            result.setListData(activeImage(OAId));
        }else if(way==3)
        {
            result.setListData(caseImage(OAId));
        }else if (way==4)
        {
            result.setListData(communityImage(OAId));
        }

        result.setCode(1);
        result.setRepMess("查询成功");

        return result;
    }



    /**
     * 获取订单图片
     * @param OrderId
     * @return
     */
    @Autowired
    OrderImageMapper orderImageMapper;
    public List<OrderImage> orderImage(String OrderId)
    {
        List<OrderImage> orderImageList=orderImageMapper.inquireOrderImage(OrderId);
        return orderImageList;
    }


    /**
     * 获取活动图片
     * @param ActivityId
     * @return
     */
    @Autowired
    ActiveImageMapper activeImageMapper;
    public List<ActiveImage> activeImage(String ActivityId)
    {
        List<ActiveImage> activeImageList=activeImageMapper.selectByActiveId(ActivityId);
        return activeImageList;
    }

    /**
     * 获取社区图片
     * @param CommunityId
     * @return
     */
    @Autowired
    CommunityImageMapper communityImageMapper;
    public List<CommunityImage> communityImage(String CommunityId)
    {
        List<CommunityImage> communityImageList=communityImageMapper.selectByCommunityId(CommunityId);
        return communityImageList;
    }



    @Autowired
    CaseImageMapper caseImageMapper;
    public  List<CaseImage> caseImage(String CaseId)
    {
        List<CaseImage> caseImageList=caseImageMapper.selectByCaseId(CaseId);
        return caseImageList;
    }


}
