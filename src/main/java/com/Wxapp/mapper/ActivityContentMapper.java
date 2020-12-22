package com.Wxapp.mapper;

import com.Wxapp.dao.ActivityContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * 活动内容数据库接口
 */
@Mapper
@Repository
public interface ActivityContentMapper {

    /**
     * 向活动内容表中添加一个活动
     * @param activityContent
     * @return
     */
    int insertActivityContent(ActivityContent activityContent);
}
