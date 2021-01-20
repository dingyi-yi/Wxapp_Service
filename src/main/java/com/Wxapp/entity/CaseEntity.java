package com.Wxapp.entity;

import com.Wxapp.dao.casesharedao.CaseContent;
import com.Wxapp.dao.casesharedao.CaseImage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ding
 */
@Component
public class CaseEntity {
    String CaseWxName;
    String CaseHeadPortrait;
    CaseContent caseContent;
    List<CaseImage> caseImageList;

    public CaseEntity(String caseWxName, String caseHeadPortrait, CaseContent caseContent, List<CaseImage> caseImageList) {
        CaseWxName = caseWxName;
        CaseHeadPortrait = caseHeadPortrait;
        this.caseContent = caseContent;
        this.caseImageList = caseImageList;
    }

    public CaseEntity() {
    }

    public String getCaseWxName() {
        return CaseWxName;
    }

    public void setCaseWxName(String caseWxName) {
        CaseWxName = caseWxName;
    }

    public String getCaseHeadPortrait() {
        return CaseHeadPortrait;
    }

    public void setCaseHeadPortrait(String caseHeadPortrait) {
        CaseHeadPortrait = caseHeadPortrait;
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
