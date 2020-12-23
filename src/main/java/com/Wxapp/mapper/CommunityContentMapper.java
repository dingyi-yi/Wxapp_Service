package com.Wxapp.mapper;

import com.Wxapp.dao.CommunityContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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



}
