package com.Wxapp.mapper;

import com.Wxapp.dao.CommunityContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 *订单内容数据库接口
 */
@Mapper
@Repository
public interface CommunityContentMapper {

    /**
     *插入社区内容
     * @param communityContent
     * @return
     */
    void insertCommunityContent(CommunityContent communityContent);


    /**
     * 根据类型，搜索内容查询（搜索内容匹配社区描述）
     * @param communityKind 社区种类
     * @param searchContent 搜索内容
     * @return
     */
    List<CommunityContent> selectByKindADescription(String communityKind,String searchContent);


    /**
     * 社区内容评论数加一
     * @param communityId
     */
    void updateCommentNumber(String communityId);


    /**
     * 社区点赞数更新
     * @param communityId
     */
    void updateLikeNumber(String communityId);

    /**
     * 根据社区号查询设
     * @param communityId
     * @return
     */
    CommunityContent selectBycommunityId(String communityId);

}
