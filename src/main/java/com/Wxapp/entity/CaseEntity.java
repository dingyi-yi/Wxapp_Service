package com.Wxapp.entity;

import com.Wxapp.dao.CaseContent;
import com.Wxapp.dao.CaseImage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ding
 */
@Component
public class CaseEntity {
    CaseContent caseContent;
    List<CaseImage> caseImageList;

    public CaseEntity(CaseContent caseContent, List<CaseImage> caseImageList) {
        this.caseContent = caseContent;
        this.caseImageList = caseImageList;
    }

    public CaseEntity() {
    }

    public CaseContent getCaseContent() {
        return caseContent;
    }

    public void setCaseContent(CaseContent caseContent) {
        this.caseContent = caseContent;
    }

    public List<CaseImage> getCaseImageList() {
        return caseImageList;
    }

    public void setCaseImageList(List<CaseImage> caseImageList) {
        this.caseImageList = caseImageList;
    }
}
