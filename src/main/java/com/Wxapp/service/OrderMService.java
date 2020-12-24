package com.Wxapp.service;

import com.Wxapp.dao.ComQualification;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.dao.UserPortrait;
import com.Wxapp.entity.OrderMaResult;
import com.Wxapp.mapper.UserPortraitMapper;
import com.Wxapp.mapper.ComQualificationMaper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *查询维修企业服务
 */
@Service
public class OrderMService {

    @Autowired
    ComQualificationMaper comqumapper;

    @Autowired
    CheckTokenService checktoken=new CheckTokenService();

    @Autowired
    UserPortraitMapper userPortraitMapper;


    public OrderMaResult OrderService(String token, JSONObject data){
        OrderMaResult orderresult=new OrderMaResult();

        String EleAppliance=data.get("EleAppliance").toString();
        String ship=data.get("ship").toString();
        String longitude=data.get("longitude").toString();
        String latitude=data.get("latitude").toString();

        //根据token获取用户
        UserAccount user=checktoken.CheckToken(token);

        if (null==user) {
            //token无效时
            orderresult.setCode(0);
            orderresult.setRepMess("token无效,重新登陆");
            orderresult.setRepData(null);
        }else {

            /**
             * 更新用户画像表中，用户维修数据
             */
            //获取用户画像
            UserPortrait userPortrait=userPortraitMapper.selectByOpenid(user.getOpenId());
            //更新数据
            userPortrait.setMaintain(1);
            userPortrait.setMaintainDate(new Date());
            userPortrait.setMaintainContent(EleAppliance);
            userPortrait.setMaintainNumber(userPortrait.getMaintainNumber()+1);
            //将数据更新到数据库
            userPortraitMapper.updateMaintain(userPortrait);


            if (ship.equals("1") || longitude==null || latitude==null){
                //如果选择评分优先时，或者没有经纬度时，则评分优先
                List<ComQualification> U=GradeFist(EleAppliance);
                orderresult.setRepData(U);
            }else  if(ship.equals("2")){
                //距离优先
                List<ComQualification> U=DistanceFist(EleAppliance,longitude,latitude);
                orderresult.setRepData(U);
            }else{
                //综合
                List<ComQualification> U=SynthesizeFist(EleAppliance,longitude,latitude);
                orderresult.setRepData(U);
            }
            orderresult.setCode(1);
            orderresult.setRepMess("数据返回成功");
        }

        return orderresult;
    }

    //距离优先
    public List<ComQualification> DistanceFist(String EleAppliance,String longitude,String latitude){
        List<ComQualification> com=comqumapper.QByDistance(EleAppliance,Double.valueOf(longitude.toString()),
                                                                    Double.valueOf(latitude.toString()));
        System.out.println(com);
        return com;
    }

    //评分优先
    public List<ComQualification> GradeFist(String EleAppliance){
        List<ComQualification> com=comqumapper.QByRating(EleAppliance);
        return com;
    }

    //综合
    public List<ComQualification> SynthesizeFist(String EleAppliance,String longitude,String latitude){
        List<ComQualification> com=comqumapper.QBySynthesize(EleAppliance,Double.valueOf(longitude.toString()),
                Double.valueOf(latitude.toString()));
        return com;
    }

}
