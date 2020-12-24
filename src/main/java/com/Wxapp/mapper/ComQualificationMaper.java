package com.Wxapp.mapper;

import com.Wxapp.dao.ComQualification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 家电维修企业资质数据库接口
 */
@Mapper
@Repository
public interface ComQualificationMaper {

    /**
     * 根据评分查询企业
     * @param EleAppliance
     * @return
     */
    List<ComQualification> QByRating(String EleAppliance );

    /**
     * 根据距离查询企业
     * @param EleAppliance
     * @param longitude
     * @param latitude
     * @return
     */
    List<ComQualification> QByDistance(String EleAppliance,double longitude,double latitude);

    /**
     * 综合信息查询
     * @param EleAppliance
     * @param longitude
     * @param latitude
     * @return
     */
    List<ComQualification> QBySynthesize(String EleAppliance,double longitude,double latitude);


    /**
     * 添加商家
     * @param comQualification
     * @return
     */
    int InsertCom(ComQualification comQualification);

    /**
     * 根据openid查询企业
     * @param OpenId
     * @return
     */
    ComQualification inquireByOpenid(String OpenId);



}
