package com.Wxapp.service;

import com.Wxapp.dao.ComQualification;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.comQualificationMaper;
import com.Wxapp.mapper.userMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ding
 * 注册商家服务
 */
@Service
public class LicencedHouseService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    comQualificationMaper comQuaMaper;

    @Autowired
    userMapper usermapper;

    public Result Service(String token, JSONObject data)
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
        ComQualification comQualification=new ComQualification();
        //名称
        comQualification.setbName(data.get("bName").toString());
        //地址
        comQualification.setbAdd(data.get("bAdd").toString());
        //法人代表
        comQualification.setLegalRepre(data.get("legalRepre").toString());
        //公司性质
        comQualification.setShip(data.get("ship").toString());
        //许可证编号
        comQualification.setLicenseNo(data.get("LicenseNo").toString());
        //特约品牌
        comQualification.setSpecialBrand(data.get("specialBrand").toString());
        //服务范围
        comQualification.setScope(data.get("scope").toString());
        //备注
        comQualification.setScope(data.get("remarks").toString());
        //经度
        comQualification.setLon((Double) data.get("longitude"));
        //纬度
        comQualification.setLat((Double) data.get("latitude"));
        //等级，默认为3级
        comQualification.setRating(3);

        //向数据库中添加商家
        comQuaMaper.InsertCom(comQualification);

        //更新用户性质
        user.setStatus(1);
        usermapper.updateStatus(user);

        result.setCode(1);
        result.setRepMess("注册成功");

        return  result;
    }
}
