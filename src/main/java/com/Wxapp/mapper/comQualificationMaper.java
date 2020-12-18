package com.Wxapp.mapper;

import com.Wxapp.dao.ComQualification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 */
@Mapper
@Repository
public interface comQualificationMaper {

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

}
