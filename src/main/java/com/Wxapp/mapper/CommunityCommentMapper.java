package com.Wxapp.mapper;

import com.Wxapp.dao.communtitydao.CommunityComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 社区评论表数据库接口
 */
@Mapper
@Repository
public interface CommunityCommentMapper {

    /**
     * 加入评论
     * @param communityComment
     */
    void insertCommunityComment(CommunityComment communityComment);


    /**
     * 根据社区号查询
     * @param communityId
     * @return
     */
    List<CommunityComment> selectByCommunityId(String communityId);
}
