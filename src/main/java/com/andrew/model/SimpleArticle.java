package com.andrew.model;

import java.io.Serializable;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/27
 */
public class SimpleArticle implements Serializable {

    private Integer articleId;
    private String title;


   public SimpleArticle(){

   }

    public SimpleArticle(Integer articleId, String title) {
        this.articleId = articleId;
        this.title = title;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SimpleArticle{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                '}';
    }
}
