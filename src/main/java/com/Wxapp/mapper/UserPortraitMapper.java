package com.Wxapp.mapper;

import com.Wxapp.dao.UserPortrait;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * 用户画像数据库接口
 */
@Mapper
@Repository
public interface UserPortraitMapper {

    /**
     * 向用户画像表中插入一条数据
     * @param userPortrait 用户画像实体类
     * @return
     */
    int insertUserPortrait(UserPortrait userPortrait);

    /**
     * 更新用户画像表中，用户维修数据
     * @param userPortrait
     * @return
     */
    int updateMaintain(UserPortrait userPortrait);

    /**
     * 根据用户openid查询用户画像数据
     * @param OpenId 用户openid
     * @return
     */
    UserPortrait selectByOpenid(String OpenId);

    /**
     * 更新用户画像表中用户身份
     * @param OpenId 用户openid
     * @param Status 用户身份
     * @return
     */
    int upadteStatus(String OpenId,int Status);

}
