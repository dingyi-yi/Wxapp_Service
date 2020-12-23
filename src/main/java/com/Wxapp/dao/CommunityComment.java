package com.Wxapp.dao;

import java.util.Date;

/**
 * @author ding
 * 社区评论实体类
 */
public class CommunityComment {
    String CommunityId;
    String CommentOpenId;
    String CommentContent;
    Date CommentDate;

    public CommunityComment(String communityId, String commentOpenId, String commentContent, Date commentDate) {
        CommunityId = communityId;
        CommentOpenId = commentOpenId;
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

    public String getCommentOpenId() {
        return CommentOpenId;
    }

    public void setCommentOpenId(String commentOpenId) {
        CommentOpenId = commentOpenId;
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
