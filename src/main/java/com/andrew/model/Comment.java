package com.andrew.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public class Comment implements Serializable {

    private Integer commentId;
    private Integer subCommentId;
    private Integer whoCommentId;
    private Integer beCommentId;
    private Integer articleId;
    private String content;
    private String commentTime;
    private Integer likeCount;
    private Integer hateCount;
    private String commentName;

    public Comment(){

    }

    public Comment(Integer commentId, Integer subCommentId, Integer whoCommentId, Integer beCommentId, Integer articleId, String content, String commentTime, Integer likeCount, Integer hateCount, String commentName) {
        this.commentId = commentId;
        this.subCommentId = subCommentId;
        this.whoCommentId = whoCommentId;
        this.beCommentId = beCommentId;
        this.articleId = articleId;
        this.content = content;
        this.commentTime = commentTime;
        this.likeCount = likeCount;
        this.hateCount = hateCount;
        this.commentName = commentName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getSubCommentId() {
        return subCommentId;
    }

    public void setSubCommentId(Integer subCommentId) {
        this.subCommentId = subCommentId;
    }

    public Integer getWhoCommentId() {
        return whoCommentId;
    }

    public void setWhoCommentId(Integer whoCommentId) {
        this.whoCommentId = whoCommentId;
    }

    public Integer getBeCommentId() {
        return beCommentId;
    }

    public void setBeCommentId(Integer beCommentId) {
        this.beCommentId = beCommentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getHateCount() {
        return hateCount;
    }

    public void setHateCount(Integer hateCount) {
        this.hateCount = hateCount;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", subCommentId=" + subCommentId +
                ", whoCommentId=" + whoCommentId +
                ", beCommentId=" + beCommentId +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                ", commentTime=" + commentTime +
                ", likeCount=" + likeCount +
                ", hateCount=" + hateCount +
                ", commentName='" + commentName + '\'' +
                '}';
    }
}
