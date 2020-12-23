package com.Wxapp.service;

import com.Wxapp.dao.PriceStandard;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.PriceStandardMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ding
 * 获取价格参考数据服务层
 */
@Service
public class PriceRefenceService {

    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    PriceStandardMapper priceStandardMapper;

    public Result service(String token, JSONObject data)
    {
        Result<PriceStandard> result=new Result();
        //检测用户
        UserAccount user= checkTokenService.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }
        //获取电器类型
        String appliancesType=data.getString("AppliancesType");
        //获取该电器类型的所有维修类型的价格标准
        List<PriceStandard> priceStandardList=priceStandardMapper.searchByAppliancesType(appliancesType);

        result.setListData(priceStandardList);
        result.setCode(1);
        result.setRepMess("查询成功");

        return  result;

    }

}
