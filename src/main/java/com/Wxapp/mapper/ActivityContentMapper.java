package com.Wxapp.mapper;

import com.Wxapp.dao.ActivityContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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

    /**
     * 根据用户维修内容查找
     * @param MaintainContent 维修内容
     * @param date
     * @return
     */
    List<ActivityContent> selectByActiveDescription(String MaintainContent, Date date);


    /**
     * 查询
     * @param OpenId
     * @return
     */
    List<ActivityContent> selectByOpenId(String OpenId);
}
