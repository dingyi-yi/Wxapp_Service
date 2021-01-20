package com.Wxapp.mapper;

import com.Wxapp.dao.userdao.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 收藏数据库接口
 */
@Mapper
@Repository
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
