package com.Wxapp.dao.userdao;

/**
 * @author ding
 * 数据库收藏实体类
 */
public class Collect {
    String OpenId;
    String CommunityId;

    public Collect(String openId, String communityId) {
        OpenId = openId;
        CommunityId = communityId;
    }

    public Collect() {
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getCommunityId() {
        return CommunityId;
    }

    public void setCommunityId(String communityId) {
        CommunityId = communityId;
    }
}
