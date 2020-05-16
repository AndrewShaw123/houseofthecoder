package com.andrew.controller.managearticle;

import com.andrew.model.Comment;
import com.andrew.model.CommentDetail;
import com.andrew.model.SessionUser;
import com.andrew.service.managearticle.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/24
 */
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/getArticleComment")
    @ResponseBody
    public List<Comment> getArticleComment(Integer articleId){
        List<Comment> articleComment = commentService.getArticleComment(articleId);
        return articleComment;
    }


    @PostMapping("/userComment")
    @ResponseBody
    public String userComment(String commentcontent,int articleId,HttpSession session){
        SessionUser login = (SessionUser)session.getAttribute("login");
        System.out.println(login);
        if(login==null){
            return "notlogin";
        }
        String commentName = login.getUsername();
        int commentId = login.getAccountId();
        commentService.userCommentArticle(commentId,commentName,commentcontent,articleId);
        return "commentsuccess";

    }

    @GetMapping("/viewAllMyComment")
    @ResponseBody
    public List<CommentDetail> viewAllMyComment(HttpSession session){
        int accountId = ((SessionUser)session.getAttribute("login")).getAccountId();
        List<CommentDetail> allMyComment = commentService.getAllMyComment(accountId);

        return allMyComment;
    }

    @GetMapping("/userpage/deleteComment")
    public void deleteComment(int commentId, HttpServletResponse response) throws IOException {
        commentService.deleteComment(commentId);
        response.sendRedirect("/houseofthecoder/userpage/ownuserpage.html?page=0");
    }

}
