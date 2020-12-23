package com.Wxapp.mapper;

import com.Wxapp.dao.PriceStandard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 数据库价格标准表接口
 */
@Mapper
@Repository
public interface PriceStandardMapper {

    /**
     * 根据家电种类，查询价格标准
     * @param appliancesType 家电种类
     * @return
     */
    List<PriceStandard> searchByAppliancesType(String appliancesType);
}
