package com.andrew.service.managearticle;

import com.andrew.model.Comment;
import com.andrew.model.CommentDetail;

import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/24
 */
public interface CommentService {

    List<Comment> getArticleComment(int articleId);

    void userCommentArticle(int commentId,String commentName,String content,int articleId);

    List<CommentDetail> getAllMyComment(int accountId);

    void deleteComment(int commentId);
}
