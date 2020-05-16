package com.andrew.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/8
 */
public class DetailArticle implements Serializable {


    private String writer;
    private String writerImg;
    private Integer accountId;
    private String sort;
    private String title;
    private String content;
    private String uploadTime;
    private Integer likeCount;
    private Integer hateCount;
    private Integer viewCount;

    public DetailArticle(){

    }

    public DetailArticle(String writer, String writerImg, Integer accountId, String sort, String title, String content, String uploadTime, Integer likeCount, Integer hateCount, Integer viewCount) {
        this.writer = writer;
        this.writerImg = writerImg;
        this.accountId = accountId;
        this.sort = sort;
        this.title = title;
        this.content = content;
        this.uploadTime = uploadTime;
        this.likeCount = likeCount;
        this.hateCount = hateCount;
        this.viewCount = viewCount;
    }

    public String getWriterImg() {
        return writerImg;
    }

    public void setWriterImg(String writerImg) {
        this.writerImg = writerImg;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
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
        return "DetailArticle{" +
                "writer='" + writer + '\'' +
                ", writerImg='" + writerImg + '\'' +
                ", accountId=" + accountId +
                ", sort='" + sort + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", likeCount=" + likeCount +
                ", hateCount=" + hateCount +
                ", viewCount=" + viewCount +
                '}';
    }
}
