package com.Wxapp.entity;

import com.Wxapp.dao.CommunityComment;
import com.Wxapp.dao.CommunityContent;
import com.Wxapp.dao.CommunityImage;
import com.Wxapp.dao.CommunityLike;

import java.util.List;

/**
 * @author ding
 * 社区层，包括社区内容，图片，点赞，评论
 */
public class CommunityEntity {
    CommunityContent communityContent;
    List<CommunityImage> communityImageList;
    List<CommunityComment> communityComment;
    List<CommunityLike> communityLike;

    public CommunityEntity(CommunityContent communityContent, List<CommunityImage> communityImageList,
                           List<CommunityComment> communityComment, List<CommunityLike> communityLike) {
        this.communityContent = communityContent;
        this.communityImageList = communityImageList;
        this.communityComment = communityComment;
        this.communityLike = communityLike;
    }

    public CommunityEntity() {
    }

    public CommunityContent getCommunityContent() {
        return communityContent;
    }

    public void setCommunityContent(CommunityContent communityContent) {
        this.communityContent = communityContent;
    }

    public List<CommunityImage> getCommunityImageList() {
        return communityImageList;
    }

    public void setCommunityImageList(List<CommunityImage> communityImageList) {
        this.communityImageList = communityImageList;
    }

    public List<CommunityComment> getCommunityComment() {
        return communityComment;
    }

    public void setCommunityComment(List<CommunityComment> communityComment) {
        this.communityComment = communityComment;
    }

    public List<CommunityLike> getCommunityLike() {
        return communityLike;
    }

    public void setCommunityLike(List<CommunityLike> communityLike) {
        this.communityLike = communityLike;
    }
}
