package com.Wxapp.dao.casesharedao;

import org.springframework.stereotype.Component;

/**
 * @author ding
 * 案例图片实体类，对应数据库图片实体类
 */
@Component
public class CaseImage {
    String OpenId;
    String CaseId;
    byte[] CaseImage;

    public CaseImage(String openId, String caseId, byte[] caseImage) {
        OpenId = openId;
        CaseId = caseId;
        CaseImage = caseImage;
    }

    public CaseImage() {
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getCaseId() {
        return CaseId;
    }

    public void setCaseId(String caseId) {
        CaseId = caseId;
    }

    public byte[] getCaseImage() {
        return CaseImage;
    }

    public void setCaseImage(byte[] caseImage) {
        CaseImage = caseImage;
    }
}
