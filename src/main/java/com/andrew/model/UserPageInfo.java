package com.andrew.model;

import java.io.Serializable;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/28
 */
public class UserPageInfo implements Serializable {

    private Integer viewCount;
    private Integer articleCount;
    private Integer fanCount;
    private Integer commentwCount;

    public UserPageInfo(){}

    public UserPageInfo(Integer viewCount, Integer articleCount, Integer fanCount, Integer commentwCount) {
        this.viewCount = viewCount;
        this.articleCount = articleCount;
        this.fanCount = fanCount;
        this.commentwCount = commentwCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getFanCount() {
        return fanCount;
    }

    public void setFanCount(Integer fanCount) {
        this.fanCount = fanCount;
    }

    public Integer getCommentwCount() {
        return commentwCount;
    }

    public void setCommentwCount(Integer commentwCount) {
        this.commentwCount = commentwCount;
    }

    @Override
    public String toString() {
        return "UserPageInfo{" +
                "viewCount=" + viewCount +
                ", articleCount=" + articleCount +
                ", fanCount=" + fanCount +
                ", commentwCount=" + commentwCount +
                '}';
    }
}
