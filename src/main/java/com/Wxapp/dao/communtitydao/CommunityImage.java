package com.Wxapp.dao.communtitydao;

/**
 * @author ding
 * 社区图片实体类
 */
public class CommunityImage {
    String OpenId;
    String CommunityId;
    byte[] CommunityImage;

    public CommunityImage(String openId, String communityId, byte[] communityImage) {
        OpenId = openId;
        CommunityId = communityId;
        CommunityImage = communityImage;
    }

    public CommunityImage() {
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

    public byte[] getCommunityImage() {
        return CommunityImage;
    }

    public void setCommunityImage(byte[] communityImage) {
        CommunityImage = communityImage;
    }
}
