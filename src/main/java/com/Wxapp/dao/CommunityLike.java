package com.Wxapp.dao;

import java.util.Date;

/**
 * @author ding
 * 社区点赞实体类
 */
public class CommunityLike {

    String CommunityId;
    String LikeOpenId;
    Date LikeDate;

    public CommunityLike(String communityId, String likeOpenId, Date likeDate) {
        CommunityId = communityId;
        LikeOpenId = likeOpenId;
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

    public String getLikeOpenId() {
        return LikeOpenId;
    }

    public void setLikeOpenId(String likeOpenId) {
        LikeOpenId = likeOpenId;
    }

    public Date getLikeDate() {
        return LikeDate;
    }

    public void setLikeDate(Date likeDate) {
        LikeDate = likeDate;
    }
}
