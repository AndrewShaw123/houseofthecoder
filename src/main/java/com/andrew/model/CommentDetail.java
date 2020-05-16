package com.andrew.model;

import java.io.Serializable;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/28
 */
public class CommentDetail implements Serializable {

    private Comment comment;
    private Article article;

    public CommentDetail(){}

    public CommentDetail(Comment comment, Article article) {
        this.comment = comment;
        this.article = article;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "CommentDetail{" +
                "comment=" + comment +
                ", article=" + article +
                '}';
    }
}
