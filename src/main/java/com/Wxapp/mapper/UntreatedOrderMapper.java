package com.Wxapp.mapper;

import com.Wxapp.dao.UntreatedOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 未处理订单数据库接口
 * @author ding
 */


@Mapper
@Repository
public interface UntreatedOrderMapper {

    /**
     * 添加订单函数
     * @param Order 订单类
     * @return
     */
    int InsertOrder(UntreatedOrder Order);

    /**
     * 根据订单号查询订单
     * @param orderId
     * @return
     */
    UntreatedOrder inquireByOrderId(String orderId);

    /**
     * 查询订单
     * @param OpenId 订单发布者openid
     * @return 订单列表
     */
    List<UntreatedOrder> InquireOrder(String OpenId);

    /**
     * 根据维修范围查询
     * @param scope 商家维修范围
     * @param date 当前时间
     * @return
     */
    List<UntreatedOrder> iquireByScope(String scope,Date date);

    /**
     * 根据商家维修范围，和搜索内容查询
     * @param scope 商家维修范围
     * @param storetype 搜索内容
     * @return
     */
    List<UntreatedOrder> inquireByStoretype(String scope, String storetype, Date date);


    /**
     * 根据时间查询
     * @param scope 商家维修范围
     * @param date 当前时间
     * @return
     */
    List<UntreatedOrder> inquireByTime(String scope,Date date);

    /**
     * 根据距离查询
     * @param scope 商家维修范围
     * @param date 当前时间
     * @param Lon 经度
     * @param Lat 纬度
     * @return
     */
    List<UntreatedOrder> inquireByDistance(String scope,Date date,double Lon,double Lat);

    /**
     * 删除订单
     * @param OrderId 要删除的订单号
     * @return
     */
    int deleteByOrderId(String OrderId);


}
