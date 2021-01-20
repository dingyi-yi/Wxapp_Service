package com.Wxapp.mapper;

import com.Wxapp.dao.communtitydao.CommunityLike;
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

    /**
     * 根据openid和社区编号查询
     * @param OpenId
     * @param communityId
     * @return
     */
    CommunityLike selectByOpenIdACommunityId(String OpenId,String communityId);
}
