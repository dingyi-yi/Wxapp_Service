package com.Wxapp.mapper;

import com.Wxapp.dao.CaseContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 案例内容数据库接口
 */
@Mapper
@Repository
public interface CaseContentMapper {

    /**
     * 添加一条数据
     * @param caseContent
     */
    void insertCaseContent(CaseContent caseContent);

    /**
     * 查询所有的案例
     * @return
     */
    List<CaseContent> selectAll();

    /**
     * 根据家电类型查询案例
     * @param appliancesType
     * @return
     */
    List<CaseContent> selectByAppliancesType(String appliancesType);

}
