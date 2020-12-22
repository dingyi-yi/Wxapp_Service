package com.Wxapp.mapper;

import com.Wxapp.dao.ProcesserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * 已处理订单数据库接口
 */
@Mapper
@Repository
public interface ProcesserOrderMapper {

    /**
     * 添加已处理订单
     * @param processerOrder 已处理订单实体类
     * @return
     */
    int insertProcesserOrder(ProcesserOrder processerOrder);


}
