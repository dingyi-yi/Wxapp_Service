package com.Wxapp.dao.communtitydao;

import java.util.Date;

/**
 * @author ding
 * 社区评论实体类
 */
public class CommunityComment {
    String CommunityId;
    String CommentWxName;
    String CommentHeadPortrait;
    String CommentContent;
    Date CommentDate;

    public CommunityComment(String communityId, String commentWxName,
                            String commentHeadPortrait, String commentContent, Date commentDate) {
        CommunityId = communityId;
        CommentWxName = commentWxName;
        CommentHeadPortrait = commentHeadPortrait;
        CommentContent = commentContent;
        CommentDate = commentDate;
    }

    public CommunityComment() {
    }

    public String getCommunityId() {
        return CommunityId;
    }

    public void setCommunityId(String communityId) {
        CommunityId = communityId;
    }

    public String getCommentWxName() {
        return CommentWxName;
    }

    public void setCommentWxName(String commentWxName) {
        CommentWxName = commentWxName;
    }

    public String getCommentHeadPortrait() {
        return CommentHeadPortrait;
    }

    public void setCommentHeadPortrait(String commentHeadPortrait) {
        CommentHeadPortrait = commentHeadPortrait;
    }

    public String getCommentContent() {
        return CommentContent;
    }

    public void setCommentContent(String commentContent) {
        CommentContent = commentContent;
    }

    public Date getCommentDate() {
        return CommentDate;
    }

    public void setCommentDate(Date commentDate) {
        CommentDate = commentDate;
    }
}
