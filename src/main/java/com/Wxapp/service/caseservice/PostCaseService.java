package com.Wxapp.service.caseservice;

import com.Wxapp.dao.casesharedao.CaseContent;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.CaseContentMapper;
import com.Wxapp.mapper.UserMapper;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author ding
 * 发布案例数据服务类
 */
@Service
public class PostCaseService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    CaseContentMapper caseContentMapper;

    @Autowired
    UserMapper userMapper;

    public Result service(String token, JSONObject data){

        Result result=new Result();
        //检测用户
        UserAccount user= checkTokenService.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }

        /**
         * 获取参数，构造案例内容实体类
         */
        //生成活动编号
        String caseId = UUID.randomUUID().toString();
        //家电类型
        String appliancesType =data.getString("AppliancesType");
        //案例描述
        String caseDescription =data.getString("CaseDescription");
        //维修时间
        String maintenanceTime =data.getString("MaintenanceTime");
        //价格
        int price= (int) data.get("Price");
        //发布时间
        Date publishTime=new Date();
        //维修企业
        String maintenanceCompany =data.getString("MaintenanceCompany");

        //构造活动内容对象
        CaseContent caseContent=new CaseContent(user.getOpenId(),caseId,appliancesType,
                caseDescription,maintenanceTime,price,publishTime,maintenanceCompany);

        //写入数据库
        caseContentMapper.insertCaseContent(caseContent);
        userMapper.upadteGolCoin(user.getOpenId(),10);


        result.addJsonData("Case",caseContent);
        result.setCode(1);
        result.setRepMess("发布成功");

        return result;
    }
}
