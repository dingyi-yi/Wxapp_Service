package com.Wxapp.dao.activitydao;

import org.springframework.stereotype.Component;

/**
 * @author ding
 *活动图片数据库表实体类
 */
@Component
public class ActiveImage {

    String OpenId;
    String ActiveId;
    byte[] ActiveImage;

    public ActiveImage(String openId, String activeId, byte[] activeImage) {
        OpenId = openId;
        ActiveId = activeId;
        ActiveImage = activeImage;
    }

    public ActiveImage() {
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

    public byte[] getActiveImage() {
        return ActiveImage;
    }

    public void setActiveImage(byte[] activeImage) {
        ActiveImage = activeImage;
    }


}
