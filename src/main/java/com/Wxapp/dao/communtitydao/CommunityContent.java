package com.Wxapp.dao.communtitydao;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ding
 * 社区中发布内容表的实体类
 */
@Component
public class CommunityContent {
    String OpenId;
    String CommunityId;
    String CommunityKind;
    String CommunityDescription;
    Date PublishDate;
    int CommentNumber;
    int LikeNumber;

    public CommunityContent(String openId, String communityId, String communityKind, String communityDescription,
                            Date publishDate, int commentNumber, int likeNumber) {
        OpenId = openId;
        CommunityId = communityId;
        CommunityKind = communityKind;
        CommunityDescription = communityDescription;
        PublishDate = publishDate;
        CommentNumber = commentNumber;
        LikeNumber = likeNumber;
    }

    public CommunityContent() {
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

    public String getCommunityKind() {
        return CommunityKind;
    }

    public void setCommunityKind(String communityKind) {
        CommunityKind = communityKind;
    }

    public String getCommunityDescription() {
        return CommunityDescription;
    }

    public void setCommunityDescription(String communityDescription) {
        CommunityDescription = communityDescription;
    }

    public Date getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(Date publishDate) {
        PublishDate = publishDate;
    }

    public int getCommentNumber() {
        return CommentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        CommentNumber = commentNumber;
    }

    public int getLikeNumber() {
        return LikeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        LikeNumber = likeNumber;
    }
}
