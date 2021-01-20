package com.Wxapp.mapper;

import com.Wxapp.dao.merchantdao.Evaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * 评价数据库接口
 */
@Mapper
@Repository
public interface EvaluationMapper {


    /**
     * 插入一条评论
     * @param evaluation
     */
    void insertEvaluationMapper(Evaluation evaluation);


    /**
     * 获取用户对某个订单的评价
     * @param OpenId
     * @param OrderId
     * @return
     */
    Evaluation selectByOpenIdAOrderId(String OpenId ,String OrderId);

    /**
     * 获取商家莫条订单的评价
     * @param MerchantId
     * @param OrderId
     * @return
     */
    Evaluation selectByMerchantIdAOrderId(String MerchantId,String OrderId);

}
