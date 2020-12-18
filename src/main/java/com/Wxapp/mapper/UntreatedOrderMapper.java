package com.Wxapp.mapper;

import com.Wxapp.dao.UntreatedOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 未处理订单数据库接口
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

}
