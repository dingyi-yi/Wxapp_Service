package com.Wxapp.mapper;

import com.Wxapp.dao.communtitydao.CommunityImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 社区图片表数据库接口
 */
@Mapper
@Repository
public interface CommunityImageMapper {

    /**
     * 插入社区图片
     * @param communityImage
     * @return
     */
    void insertCommunityImage(CommunityImage communityImage);


    /**
     * 根据社区号查询社区图片
     * @param communityId
     * @return
     */
    List<CommunityImage> selectByCommunityId(String communityId);


}
