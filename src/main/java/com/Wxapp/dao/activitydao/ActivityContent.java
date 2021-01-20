package com.Wxapp.dao.activitydao;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ding
 * 数据库活动内容表对应的实体类
 */
@Component
public class ActivityContent {
    String OpenId;
    String ActiveId;
    String ActiveName;
    Date StartTime;
    Date EndTime;
    String  ActiveDescription;

    public ActivityContent(String openId, String activeId, String activeName,
                           Date startTime, Date endTime, String activeDescription) {
        OpenId = openId;
        ActiveId = activeId;
        ActiveName = activeName;
        StartTime = startTime;
        EndTime = endTime;
        ActiveDescription = activeDescription;
    }

    public ActivityContent() {
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getActiveId() {
        return ActiveId;
    }

    public void setActiveId(String activeId) {
        ActiveId = activeId;
    }

    public String getActiveName() {
        return ActiveName;
    }

    public void setActiveName(String activeName) {
        ActiveName = activeName;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public String getActiveDescription() {
        return ActiveDescription;
    }

    public void setActiveDescription(String activeDescription) {
        ActiveDescription = activeDescription;
    }
}
