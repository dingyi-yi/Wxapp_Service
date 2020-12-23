package com.Wxapp.mapper;

import com.Wxapp.dao.CommunityLike;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 社区点赞表数据库接口
 */
@Mapper
@Repository
public interface CommunityLikeMapper {

    /**
     * 插入社区点赞
     * @param communityLike
     */
    void  insertCommunityLike(CommunityLike communityLike);


    /**
     * 根据社区编号，查询社区点赞
     * @param communityId
     * @return
     */
    List<CommunityLike> selectByCommunityId(String communityId);
}
