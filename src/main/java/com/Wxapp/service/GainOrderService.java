package com.Wxapp.service;

import com.Wxapp.dao.*;
import com.Wxapp.entity.OrderEntity;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.OrderImageMapper;
import com.Wxapp.mapper.UntreatedOrderMapper;
import com.Wxapp.mapper.ComQualificationMaper;
import com.Wxapp.mapper.UserMapper;
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
    OrderImageMapper orderImageMapper;

    @Autowired
    UntreatedOrderMapper untreatedOrderMapper;

    @Autowired
    UserMapper usermapper;

    @Autowired
    ComQualificationMaper comqualificationmaper;



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
    public List personOrder(UserAccount  user)
    {
        //订单列表
        List<OrderEntity> orderEntityList =new ArrayList<>();

        /**
         * 查询未处理订单
         */
        //查询订单内容
        List<UntreatedOrder> untreatedOrders=untreatedOrderMapper.InquireOrder(user.getOpenId());
        for (UntreatedOrder order:untreatedOrders)
        {
            OrderEntity<UntreatedOrder> untreatedOrderOrder=new OrderEntity<UntreatedOrder>();
            //查询该订单所有的图片
            List<OrderImage> orderImages=orderImageMapper.inquireOrderImage(order.getOrderId());

            //构造订单
            untreatedOrderOrder.setOrder(order);
            untreatedOrderOrder.setOrderImages(orderImages);
            untreatedOrderOrder.setOrderWxName(user.getWxName());
            untreatedOrderOrder.setOrderHeadPortrait(user.getHeadPortrait());
            //将该订单加入订单列表
            orderEntityList.add(untreatedOrderOrder);

        }

        /**
         * 已经处理订单查询
         */

        return orderEntityList;
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

        //订单列表
        List<OrderEntity> orderEntityList;

        String time ="Time", distance ="Distance", searchCriteria ="SearchCriteria";

        //订单查询方式
        String displayMode =data.get("displayMode").toString();

        if (time.equals(displayMode))
        { //根据时间优先
            orderEntityList =adoptOrderSearch(scope,0,null,0,0);
        }else if (distance.equals(displayMode))
        {//
            //获取经纬度
            double Lon= (double) data.get("Longitude");
            double Lat= (double) data.get("Latitude");
            orderEntityList =adoptOrderSearch(scope,1,null,Lon,Lat);
        }else if (searchCriteria.equals(displayMode))
        {//搜索某一种家电的订单
            //获取搜索内容
            String storetype=data.get("SearchContent").toString();
            orderEntityList =adoptOrderSearch(scope,2,storetype,0,0);

        }else {
            //默认查询所有的
            orderEntityList =adoptOrderSearch(scope,3,null,0,0);
        }


        return  null;
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
    public  List adoptOrderSearch(String scope, int way, String storetype, double Lon, double Lat)
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
            OrderEntity<UntreatedOrder> untreatedOrderOrder=new OrderEntity<UntreatedOrder>();
            //查询该订单所有的图片
            List<OrderImage> orderImages=orderImageMapper.inquireOrderImage(order.getOrderId());
            //查询该订单的发布用户
            UserAccount orderuser=usermapper.queryUserByOpenId(order.getOpenId());

            //构造订单
            untreatedOrderOrder.setOrder(order);
            untreatedOrderOrder.setOrderImages(orderImages);
            untreatedOrderOrder.setOrderWxName(orderuser.getWxName());
            untreatedOrderOrder.setOrderHeadPortrait(orderuser.getHeadPortrait());

            //该订单的内容，图片，发布者已经构造完成，将该订单添加入列表
            orderEntityList.add(untreatedOrderOrder);
        }

        return orderEntityList;
    }
}
