package com.Wxapp.service.orderservice;

import com.Wxapp.dao.merchantdao.PriceStandard;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.PriceStandardMapper;
import com.Wxapp.service.userservice.CheckTokenService;
import com.Wxapp.utils.AveragePriceUtil;
import com.Wxapp.utils.HanlpUtils;
import com.Wxapp.utils.StrJaccard;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        String Describe=data.getString("Describe");
        //获取该电器类型的所有维修类型的价格标准
        List<PriceStandard> priceStandardList=priceStandardMapper.searchByAppliancesType(appliancesType);

        PriceStandard lastPriceStandard=new PriceStandard();

        int recommendPrice=0;
        double jaccard=0;
        for(PriceStandard priceStandard:priceStandardList)
        {
            double han=HanlpUtils.hanlpUtis(Describe,priceStandard.getMaintainType());
            if(jaccard<han)
            {
                jaccard=han;
                recommendPrice= AveragePriceUtil.GainAverage(priceStandard);
                lastPriceStandard=priceStandard;
            }
        }


        if(recommendPrice==0)
        {
            recommendPrice=100;
        }
        result.addJsonData("AveragePriceStandard",lastPriceStandard);
        result.addJsonData("priceStandard",recommendPrice);
        result.setCode(1);
        result.setRepMess("查询成功");

        return  result;

    }

}
