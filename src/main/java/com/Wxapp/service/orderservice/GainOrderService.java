package com.Wxapp.service.orderservice;

import com.Wxapp.dao.merchantdao.ComQualification;
import com.Wxapp.dao.orderdao.OrderImage;
import com.Wxapp.dao.orderdao.TakeOrder;
import com.Wxapp.dao.orderdao.UntreatedOrder;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.OrderEntity;
import com.Wxapp.entity.Result;
import com.Wxapp.entity.TakeOderCompany;
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
 * 订单查询服务
 */
@Service
public class GainOrderService {
    @Autowired
    CheckTokenService checktoken=new CheckTokenService();

    @Autowired
    UntreatedOrderMapper untreatedOrderMapper;

    @Autowired
    UserMapper usermapper;

    @Autowired
    ComQualificationMaper comqualificationmaper;


    @Autowired
    TakeOrderMapper takeOrderMapper;


    public Result service(String token, JSONObject data,int way)
    {
        Result result=new Result();
        //检测用户
        UserAccount user= checktoken.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }

        if(1==way)
        {
            //查询个人订单
            result.setListData(personOrder(user));
        }else if (2==way)
        {
            //在线接单时，加载订单
            result.setListData(adoptOrder(user,data));
        }

        //构造返回结果
        result.setCode(1);
        result.setRepMess("订单查询成功");
        result.setJsonData(null);


        return result;
    }

    /**
     * 获取个人订单
     * @param user
     * @return
     */
    @Autowired
    PersonOrderService personOrderService=new PersonOrderService();
    @Autowired
    CompanyOrderService companyOrderService=new CompanyOrderService();
    public List personOrder(UserAccount  user)
    {
        ComQualification comQualification=comqualificationmaper.inquireByOpenid(user.getOpenId());
        if (comQualification!=null)
        {//该用户是商家
            return companyOrderService.companyOrder(user);
        }else {
            //该用户是普通用户
            return personOrderService.personOrder(user);
        }
    }







    /**
     * 在线接单时，获取已有订单
     * @param user
     * @param data
     * @return
     */
    public  List adoptOrder(UserAccount user,JSONObject data){

        //获取该商家的信息
        ComQualification com=comqualificationmaper.inquireByOpenid(user.getOpenId());
        if (com==null)
         {
            return null;
        }
        //获取商家维修范围
        String scope=com.getScope();
        if(scope.length()<2)
        {
            scope="冰箱，空调，洗衣机，微波炉，移动电话";
        }

        //订单列表
        List<OrderEntity> orderEntityList;

        String time ="Time", distance ="Distance", searchCriteria ="SearchCriteria";

        //订单查询方式
        String displayMode =data.get("DisplayMode").toString();



        if (time.equals(displayMode))
        { //根据时间优先
            orderEntityList =adoptOrderSearch(scope,0,null,0,0, user.getOpenId());
            return orderEntityList;
        }else if (distance.equals(displayMode))
        {//
            //获取经纬度
            double Lon= (double) data.get("Longitude");
            double Lat= (double) data.get("Latitude");
            orderEntityList =adoptOrderSearch(scope,1,null,Lon,Lat,user.getOpenId());
            return orderEntityList;
        }else if (searchCriteria.equals(displayMode))
        {//搜索某一种家电的订单
            //获取搜索内容
            String storetype=data.get("SearchContent").toString();

            orderEntityList =adoptOrderSearch(scope,2,storetype,0,0,user.getOpenId());

            return orderEntityList;

        }else {
            //默认查询所有的
            orderEntityList =adoptOrderSearch(scope,3,null,0,0,user.getOpenId());
            return orderEntityList;
        }


    }


    /**
     * 在线接单时，从数据库查询订单内容，订单图片，订单发布者，并构造订单
     * @param scope 维修范围
     * @param way 方式
     * @param storetype 搜索的家电种类
     * @param Lon  经度
     * @param Lat 纬度
     * @return
     */
    public  List adoptOrderSearch(String scope, int way, String storetype, double Lon, double Lat,String MerchantId)
    {
        //订单列表
        List<OrderEntity> orderEntityList =new ArrayList<>();

        //订单内容列表
        List<UntreatedOrder> untreatedOrderList = null;
        if (way==0)
        {
            untreatedOrderList=untreatedOrderMapper.inquireByTime(scope,new Date());
        }else if (way==1)
        {
            untreatedOrderList=untreatedOrderMapper.inquireByDistance(scope,new Date(),Lon,Lat);
        }else if (way==2)
        {
            //获取订单内容列表
            untreatedOrderList=untreatedOrderMapper.inquireByStoretype(scope,storetype,new Date());
        }else {
            untreatedOrderList=untreatedOrderMapper.iquireByScope(scope,new Date());
        }

        for (UntreatedOrder order:untreatedOrderList){
            //订单实体类
            OrderEntity untreatedOrderOrder=new OrderEntity();
            //查询该订单所有的图片

            List<OrderImage> orderImageList=new ArrayList<>();
            //查询该订单的发布用户
            UserAccount orderuser=usermapper.queryUserByOpenId(order.getOpenId());

            //查询该商家是否接单
            TakeOrder takeOrder=takeOrderMapper.selectByOrderIdAMerchantId(order.getOrderId(),MerchantId);
            untreatedOrderOrder.setTakeOrder(false);
            if(takeOrder!=null)
            {
                untreatedOrderOrder.setTakeOrder(true);

                TakeOderCompany takeOderCompany=new TakeOderCompany();
                takeOderCompany.setTakeOrder(takeOrder);
                untreatedOrderOrder.addtakeOderCompanyList(takeOderCompany);
                untreatedOrderOrder.setTakeOrder(true);
            }


            //构造订单
            untreatedOrderOrder.setUntreatedOrder(order);
            untreatedOrderOrder.setOrderWxName(orderuser.getWxName());
            untreatedOrderOrder.setOrderHeadPortrait(orderuser.getHeadPortrait());

            //该订单的内容，图片，发布者已经构造完成，将该订单添加入列表
            orderEntityList.add(untreatedOrderOrder);
        }

        return orderEntityList;
    }
}
