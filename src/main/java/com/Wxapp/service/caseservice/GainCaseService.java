package com.Wxapp.service.caseservice;

import com.Wxapp.dao.casesharedao.CaseContent;
import com.Wxapp.dao.casesharedao.CaseImage;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.CaseEntity;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.CaseContentMapper;
import com.Wxapp.mapper.CaseImageMapper;
import com.Wxapp.mapper.UserMapper;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ding
 * 获取案例数据服务层
 */
@Service
public class GainCaseService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    CaseContentMapper caseContentMapper;

    @Autowired
    CaseImageMapper caseImageMapper;

    @Autowired
    UserMapper usermapper;

    public Result service(String token, JSONObject data,int way)
    {

        //订单列表
        List<CaseEntity> caseList=new ArrayList<>();

        Result<CaseEntity> result=new Result();

        //检测用户
        UserAccount user= checkTokenService.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }

        //案例内容
        List<CaseContent> caseContentList=caseMethod(data,way);


        int index=0;
        for (CaseContent caseContent:caseContentList)
        {
            index++;
            //案例类
            CaseEntity caseEntity=new CaseEntity();

            //该案例的所有图片
            //List<CaseImage> caseImageList=caseImageMapper.selectByCaseId(caseContent.getCaseId());
            List<CaseImage> caseImageList=new ArrayList<>();

            //获取发布该案例的用户
            UserAccount userAccount=usermapper.queryUserByOpenId(caseContent.getOpenId());

            caseEntity.setCaseContent(caseContent);
            caseEntity.setCaseImageList(caseImageList);
            caseEntity.setCaseWxName(userAccount.getWxName());
            caseEntity.setCaseHeadPortrait(userAccount.getHeadPortrait());

            caseList.add(caseEntity);
            if (index>20)
            {
                break;
            }
        }

        result.setListData(caseList);
        result.setCode(1);
        result.setRepMess("查询成功");


        return result;
    }



    /**
     * 处理查询方式
     * @param data
     * @return
     */
    public List<CaseContent> caseMethod(JSONObject data,int way)
    {
        List<CaseContent> caseContentList=new ArrayList<>();
        if (way==1)
        {
            caseContentList=caseContentMapper.selectAll();
            return caseContentList;
        }else {
            //获取参数，家电类型
            String appliancesType=data.getString("AppliancesType");
            caseContentList=caseContentMapper.selectByAppliancesType(appliancesType);
            return caseContentList;
        }

    }

}
