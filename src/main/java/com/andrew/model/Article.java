package com.andrew.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public class Article implements Serializable {

    private Integer articleId;
    private Integer accountId;
    private Integer sortId;
    private String title;
    private String content;
    private Timestamp uploadTime;
    private Integer likeCount;
    private Integer hateCount;
    private Integer viewCount;

    public Article(){

    }

    public Article(Integer articleId, Integer accountId, Integer sortId, String title, String content, Timestamp uploadTime, Integer likeCount, Integer hateCount, Integer viewCount) {
        this.articleId = articleId;
        this.accountId = accountId;
        this.sortId = sortId;
        this.title = title;
        this.content = content;
        this.uploadTime = uploadTime;
        this.likeCount = likeCount;
        this.hateCount = hateCount;
        this.viewCount = viewCount;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
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

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", accountId=" + accountId +
                ", sortId=" + sortId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", uploadTime=" + uploadTime +
                ", likeCount=" + likeCount +
                ", hateCount=" + hateCount +
                ", viewCount=" + viewCount +
                '}';
    }
}
