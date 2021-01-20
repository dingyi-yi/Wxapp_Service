package com.Wxapp.entity;

import com.Wxapp.dao.activitydao.ActiveImage;
import com.Wxapp.dao.activitydao.ActivityContent;

import java.util.List;

/**
 * @author ding
 * 订单实体类，订单内容，订单图片，订单商家
 */
public class ActivityEntity {

    /**
     * 商店名称
     */
    String FirmName;

    /**
     * 商店头像
     */
    String TradeMark;

    /**
     * 活动地址
     */
    String ActivityAdress;

    /**
     * 活动内容
     */
    ActivityContent activityContent;

    /**
     * 活动海报
     */
    List<ActiveImage> activeImageList;

    public ActivityEntity(String firmName, String tradeMark, String activityAdress,
                          ActivityContent activityContent, List<ActiveImage> activeImageList) {
        FirmName = firmName;
        TradeMark = tradeMark;
        ActivityAdress = activityAdress;
        this.activityContent = activityContent;
        this.activeImageList = activeImageList;
    }

    public ActivityEntity() {
    }

    public String getFirmName() {
        return FirmName;
    }

    public void setFirmName(String firmName) {
        FirmName = firmName;
    }

    public String getTradeMark() {
        return TradeMark;
    }

    public void setTradeMark(String tradeMark) {
        TradeMark = tradeMark;
    }

    public String getActivityAdress() {
        return ActivityAdress;
    }

    public void setActivityAdress(String activityAdress) {
        ActivityAdress = activityAdress;
    }

    public ActivityContent getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(ActivityContent activityContent) {
        this.activityContent = activityContent;
    }

    public List<ActiveImage> getActiveImageList() {
        return activeImageList;
    }

    public void setActiveImageList(List<ActiveImage> activeImageList) {
        this.activeImageList = activeImageList;
    }
}
