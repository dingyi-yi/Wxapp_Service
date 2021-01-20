package com.Wxapp.mapper;

import com.Wxapp.dao.orderdao.ProcesserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 查询个人所有已处理订单,对于普通用户来讲
     * @param OpenId
     * @return
     */
    List<ProcesserOrder> selectByOpenId(String OpenId);


    /**
     * 对于商家来讲
     * @param Handler
     * @return
     */
    List<ProcesserOrder>  selectByHandler(String Handler);


    /**
     * 获取用户的莫条订单
     * @param OpenId
     * @param OrderId
     * @return
     */
    ProcesserOrder selecteByOpenIdAOrderId(String OpenId,String OrderId);
}
