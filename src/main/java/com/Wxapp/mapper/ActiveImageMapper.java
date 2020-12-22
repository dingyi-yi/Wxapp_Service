package com.Wxapp.mapper;

import com.Wxapp.dao.ActiveImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * 活动图片表数据库接口
 */
@Mapper
@Repository
public interface ActiveImageMapper {

    /**
     * 插入活动图片
     * @param activeImage 活动图片类对象
     * @return
     */
    int insertActiveImage(ActiveImage activeImage);
}