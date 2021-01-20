package com.Wxapp.entity;

import com.Wxapp.dao.communtitydao.CommunityComment;
import com.Wxapp.dao.communtitydao.CommunityContent;
import com.Wxapp.dao.communtitydao.CommunityImage;
import com.Wxapp.dao.communtitydao.CommunityLike;

import java.util.List;

/**
 * @author ding
 * 社区层，包括社区内容，图片，点赞，评论
 */
public class CommunityEntity {
    String CommunityWxName;
    String CommunityHeadPortrait;
    boolean IsLike;
    boolean IsCollect;
    CommunityContent communityContent;
    List<CommunityImage> communityImageList;
    List<CommunityComment> communityComment;
    List<CommunityLike> communityLike;

    public CommunityEntity(String communityWxName, String communityHeadPortrait, boolean isLike, boolean isCollect, CommunityContent communityContent, List<CommunityImage> communityImageList,
                           List<CommunityComment> communityComment, List<CommunityLike> communityLike) {
        CommunityWxName = communityWxName;
        CommunityHeadPortrait = communityHeadPortrait;
        IsLike = isLike;
        IsCollect = isCollect;
        this.communityContent = communityContent;
        this.communityImageList = communityImageList;
        this.communityComment = communityComment;
        this.communityLike = communityLike;
    }

    public CommunityEntity() {
    }

    public String getCommunityWxName() {
        return CommunityWxName;
    }

    public void setCommunityWxName(String communityWxName) {
        CommunityWxName = communityWxName;
    }

    public String getCommunityHeadPortrait() {
        return CommunityHeadPortrait;
    }

    public void setCommunityHeadPortrait(String communityHeadPortrait) {
        CommunityHeadPortrait = communityHeadPortrait;
    }

    public boolean isLike() {
        return IsLike;
    }

    public void setLike(boolean like) {
        IsLike = like;
    }

    public boolean isCollect() {
        return IsCollect;
    }

    public void setCollect(boolean collect) {
        IsCollect = collect;
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
