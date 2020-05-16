package com.andrew.service.managearticle.impl;

import com.andrew.mapper.articlemapper.ArticleMapper;
import com.andrew.mapper.commentmapper.CommentMapper;
import com.andrew.model.Comment;
import com.andrew.model.CommentDetail;
import com.andrew.service.managearticle.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/24
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Comment> getArticleComment(int articleId) {
        List<Comment> comments = commentMapper.getArticleCommentByArticleId(articleId);
        return comments;
    }

    @Override
    public void userCommentArticle(int commentId,String commentName,String content, int articleId) {
        int beaccountId = articleMapper.queryAccountIdByArticleId(articleId);
        Timestamp commentTime = Timestamp.valueOf(LocalDateTime.now());
        commentMapper.insertComment(articleId,commentName,commentId,beaccountId,content,commentTime);
    }

    @Override
    public List<CommentDetail> getAllMyComment(int accountId) {
        List<CommentDetail> allMyComment = commentMapper.getAllMyComment(accountId);
        return allMyComment;
    }

    @Override
    public void deleteComment(int commentId) {
        commentMapper.deleteCommentByCommentId(commentId);
    }
}
