package com.andrew.mapper.commentmapper;

import com.andrew.model.Comment;
import com.andrew.model.CommentDetail;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/24
 */
public interface CommentMapper {

    List<Comment> getArticleCommentByArticleId(@Param("articleId")Integer articleId);

    void insertComment(@Param("articleId")int articleId,@Param("commentName")String commentName,@Param("commentId")int commentId,@Param("beaccountId")int beaccountId,@Param("content")String content,@Param("time") Timestamp time);

    Integer querySumCommentByAccountId(@Param("accountId")Integer accountId);

    List<CommentDetail> getAllMyComment(@Param("accountId")Integer accountId);

    void deleteCommentByCommentId(@Param("commentId")Integer commentId);
}
