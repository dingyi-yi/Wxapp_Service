package com.Wxapp.mapper;

import com.Wxapp.dao.CaseImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding
 * 案例图片数据库表
 */
@Mapper
@Repository
public interface CaseImageMapper {

    /**
     * 插入数据
     * @param caseImage
     * @return
     */
    void insertCaseImage(CaseImage caseImage);


    /**
     * 根据案例号查询案例
     * @param caseId
     * @return
     */
    List<CaseImage> selectByCaseId(String caseId);

}
