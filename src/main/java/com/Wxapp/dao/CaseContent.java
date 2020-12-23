package com.Wxapp.dao;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ding
 * 案例实体类，对应数据库中案例表
 */
@Component
public class CaseContent {
    String OpenId;
    String CaseId;
    String AppliancesType;
    String CaseDescription;
    String MaintenanceTime;
    int Price;
    Date PublishTime;
    String MaintenanceCompany;

    public CaseContent(String openId, String caseId, String appliancesType, String caseDescription, String maintenanceTime,
                       int price, Date publishTime, String maintenanceCompany) {
        OpenId = openId;
        CaseId = caseId;
        AppliancesType = appliancesType;
        CaseDescription = caseDescription;
        MaintenanceTime = maintenanceTime;
        Price = price;
        PublishTime = publishTime;
        MaintenanceCompany = maintenanceCompany;
    }

    public CaseContent() {
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

    public String getAppliancesType() {
        return AppliancesType;
    }

    public void setAppliancesType(String appliancesType) {
        AppliancesType = appliancesType;
    }

    public String getCaseDescription() {
        return CaseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        CaseDescription = caseDescription;
    }

    public String getMaintenanceTime() {
        return MaintenanceTime;
    }

    public void setMaintenanceTime(String maintenanceTime) {
        MaintenanceTime = maintenanceTime;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Date getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(Date publishTime) {
        PublishTime = publishTime;
    }

    public String getMaintenanceCompany() {
        return MaintenanceCompany;
    }

    public void setMaintenanceCompany(String maintenanceCompany) {
        MaintenanceCompany = maintenanceCompany;
    }
}
