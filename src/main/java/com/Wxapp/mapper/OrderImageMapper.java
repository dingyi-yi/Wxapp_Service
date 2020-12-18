package com.Wxapp.mapper;

import com.Wxapp.dao.OrderImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


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

}
