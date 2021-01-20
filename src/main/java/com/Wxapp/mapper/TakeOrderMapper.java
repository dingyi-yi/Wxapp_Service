package com.Wxapp.mapper;

import com.Wxapp.dao.orderdao.TakeOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 商家接单数据库接口
 */
@Mapper
@Repository
public interface TakeOrderMapper {


    /**
     * 插入接单信息
     * @param takeOrder
     */
    void insertTakeOrder(TakeOrder takeOrder);


    List<TakeOrder> selectByOrderId(String orderId);


    /**
     * 根据商家号查询
     * @param MerchantId
     * @return
     */
    List<TakeOrder> selectByMerchantId(String MerchantId);


    /**
     * 根据订单号和商家id查找
     * @param OrderId
     * @param MerchantId
     * @return
     */
    TakeOrder selectByOrderIdAMerchantId(String OrderId,String MerchantId);

    /**
     * 当用户选择商家时，删除未被选择的商家
     * @param OrderId
     * @param MerchantId
     */
    void deleteUnnecessary(String OrderId,String MerchantId);

}
