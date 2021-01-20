package com.Wxapp.mapper;

import com.Wxapp.dao.orderdao.OrderImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author ding
 */
@Mapper
@Repository
public interface OrderImageMapper {

    /**
     * 添加订单图片
     * @param orderimage 订单图片实体类
     * @return
     */
    int insertImage(OrderImage orderimage);

    /**
     * 查询订单图片
     * @param OrderId 订单编号
     * @return
     */
    List<OrderImage> inquireOrderImage(String OrderId);

}
