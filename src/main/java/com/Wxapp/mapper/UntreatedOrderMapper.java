package com.Wxapp.mapper;

import com.Wxapp.dao.UntreatedOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
     * 查询订单
     * @param OpenId 订单发布者openid
     * @return 订单列表
     */
    List<UntreatedOrder> InquireOrder(String OpenId);


}
