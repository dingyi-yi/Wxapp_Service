package com.Wxapp.dao.merchantdao;


import org.springframework.stereotype.Component;

/**
 * @author ding
 * 价格标准实体类，对应数据库中价格标准表
 */
@Component
public class PriceStandard {
    String AppliancesType;
    String MaintainType;
    int SpecialGrade;
    int FirstLevel;
    int SecondLevel;
    int ThirdLevel;
    int FourthLevel;

    public PriceStandard(String appliancesType, String maintainType, int specialGrade,
                         int firstLevel, int secondLevel, int thirdLevel, int fourthLevel) {
        AppliancesType = appliancesType;
        MaintainType = maintainType;
        SpecialGrade = specialGrade;
        FirstLevel = firstLevel;
        SecondLevel = secondLevel;
        ThirdLevel = thirdLevel;
        FourthLevel = fourthLevel;
    }

    public PriceStandard() {
    }

    public String getAppliancesType() {
        return AppliancesType;
    }

    public void setAppliancesType(String appliancesType) {
        AppliancesType = appliancesType;
    }

    public String getMaintainType() {
        return MaintainType;
    }

    public void setMaintainType(String maintainType) {
        MaintainType = maintainType;
    }

    public int getSpecialGrade() {
        return SpecialGrade;
    }

    public void setSpecialGrade(int specialGrade) {
        SpecialGrade = specialGrade;
    }

    public int getFirstLevel() {
        return FirstLevel;
    }

    public void setFirstLevel(int firstLevel) {
        FirstLevel = firstLevel;
    }

    public int getSecondLevel() {
        return SecondLevel;
    }

    public void setSecondLevel(int secondLevel) {
        SecondLevel = secondLevel;
    }

    public int getThirdLevel() {
        return ThirdLevel;
    }

    public void setThirdLevel(int thirdLevel) {
        ThirdLevel = thirdLevel;
    }

    public int getFourthLevel() {
        return FourthLevel;
    }

    public void setFourthLevel(int fourthLevel) {
        FourthLevel = fourthLevel;
    }
}
