package com.Wxapp.mapper;

import com.Wxapp.dao.ComQualification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface comQualificationMaper {

    //根据评分优先查找
    List<ComQualification> QByRating(String EleAppliance );

    //根据距离优先查找
    List<ComQualification> QByDistance(String EleAppliance,double longitude,double latitude);

    //综合优先查找
    List<ComQualification> QBySynthesize(String EleAppliance,double longitude,double latitude);

}
