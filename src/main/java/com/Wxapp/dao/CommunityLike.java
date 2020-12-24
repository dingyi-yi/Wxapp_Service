package com.Wxapp.dao;

import java.util.Date;

/**
 * @author ding
 * 社区点赞实体类
 */
public class CommunityLike {

    String CommunityId;
    String LikeWxName;
    String LikeHeadPortrait;
    Date LikeDate;

    public CommunityLike(String communityId, String likeWxName, String likeHeadPortrait, Date likeDate) {
        CommunityId = communityId;
        LikeWxName = likeWxName;
        LikeHeadPortrait = likeHeadPortrait;
        LikeDate = likeDate;
    }

    public CommunityLike() {
    }

    public String getCommunityId() {
        return CommunityId;
    }

    public void setCommunityId(String communityId) {
        CommunityId = communityId;
    }

    public String getLikeWxName() {
        return LikeWxName;
    }

    public void setLikeWxName(String likeWxName) {
        LikeWxName = likeWxName;
    }

    public String getLikeHeadPortrait() {
        return LikeHeadPortrait;
    }

    public void setLikeHeadPortrait(String likeHeadPortrait) {
        LikeHeadPortrait = likeHeadPortrait;
    }

    public Date getLikeDate() {
        return LikeDate;
    }

    public void setLikeDate(Date likeDate) {
        LikeDate = likeDate;
    }
}
