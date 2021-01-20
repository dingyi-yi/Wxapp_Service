package com.Wxapp.dao.merchantdao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.annotation.Order;

/**
 * @author ding
 * 用户对商家的评价体系
 */
public class Evaluation {
    String OrderId ;
    String OpenId;
    String  MerchantId;
    int ComprehensiveGrade;
    int   AttitudeGrade;
    int   QualityGrade;
    int  DurationGrade ;
    String   EvaluationText ;

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getMerchantId() {
        return MerchantId;
    }

    public void setMerchantId(String merchantId) {
        MerchantId = merchantId;
    }

    public int getComprehensiveGrade() {
        return ComprehensiveGrade;
    }

    public void setComprehensiveGrade(int comprehensiveGrade) {
        ComprehensiveGrade = comprehensiveGrade;
    }

    public int getAttitudeGrade() {
        return AttitudeGrade;
    }

    public void setAttitudeGrade(int attitudeGrade) {
        AttitudeGrade = attitudeGrade;
    }

    public int getQualityGrade() {
        return QualityGrade;
    }

    public void setQualityGrade(int qualityGrade) {
        QualityGrade = qualityGrade;
    }

    public int getDurationGrade() {
        return DurationGrade;
    }

    public void setDurationGrade(int durationGrade) {
        DurationGrade = durationGrade;
    }

    public String getEvaluationText() {
        return EvaluationText;
    }

    public void setEvaluationText(String evaluationText) {
        EvaluationText = evaluationText;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public boolean setvalue(JSONObject data)
    {

        if (    data.get("OrderId")!=null &&
                data.get("ComprehensiveGrade")!=null &&
                data.get("AttitudeGrade")!=null &&
                data.get("QualityGrade")!=null &&
                data.get("DurationGrade")!=null &&
                data.get("OrderId")!=null)
        {
            OrderId=data.getString("OrderId");
            ComprehensiveGrade = (int) data.get("ComprehensiveGrade");
            AttitudeGrade =(int) data.get("AttitudeGrade");
            QualityGrade = (int) data.get("QualityGrade");
            DurationGrade = (int) data.get("DurationGrade");
            EvaluationText = data.getString("EvaluationText");
            return true;
        }
        return false;
    }

    public Evaluation(String orderId, String openId, String merchantId, int comprehensiveGrade,
                      int attitudeGrade, int qualityGrade, int durationGrade, String evaluationText) {
        OrderId = orderId;
        OpenId = openId;
        MerchantId = merchantId;
        ComprehensiveGrade = comprehensiveGrade;
        AttitudeGrade = attitudeGrade;
        QualityGrade = qualityGrade;
        DurationGrade = durationGrade;
        EvaluationText = evaluationText;
    }



    public Evaluation() {
    }
}
