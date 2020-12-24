package com.Wxapp.mapper;

import com.Wxapp.dao.Collect;

import java.util.List;

/**
 * @author ding
 * 收藏数据库接口
 */
public interface CollectMapper {

    /**
     * 插入一个收藏
     * @param collect
     */
    void  insertCollect(Collect collect);

    /**
     * 查询收藏
     * @param OpenId
     * @return
     */
    List<Collect> selectByOpenId(String OpenId);

    /**
     * 查询是否已经收藏
     * @param OpenId
     * @param CommunityId
     * @return
     */
    Collect selectByOpenIdACommunityId(String OpenId,String CommunityId);
}
