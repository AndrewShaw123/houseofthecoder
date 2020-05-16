package com.andrew.controller.followcontroller;

import com.andrew.model.SessionUser;
import com.andrew.model.User;
import com.andrew.service.followservice.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/28
 */
@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/getFollowOrNot")
    @ResponseBody
    public String getFollowOrNot(HttpSession session, int accountId){

        SessionUser login = (SessionUser) session.getAttribute("login");
        if(login==null){
            return null;
        }

        int befollowid = accountId;
        int whofollowid = login.getAccountId();

        if(followService.getFollowOrNot(befollowid,whofollowid)){
            return "exist";
        }else{
            return null;
        }

    }

    @PostMapping("/startFollow")
    @ResponseBody
    public String startFollow(HttpSession session,int accountId){

        SessionUser login = (SessionUser)session.getAttribute("login");
        if(login==null){
            return null;
        }

        int whoFollowid = login.getAccountId();
        int beFollowid = accountId;
        followService.startFollowing(beFollowid,whoFollowid);
        return "success";
    }
    
    @GetMapping("/getAllFollow")
    @ResponseBody
    public List<User> getAllFollow(HttpSession session){
        Integer accountId = ((SessionUser) session.getAttribute("login")).getAccountId();
        List<User> allFollowing = followService.getAllFollowing(accountId);
        return allFollowing;
    }

    @GetMapping("userpage/cancelFollow")
    public void cancelFollow(HttpSession session, HttpServletResponse response, int accountid) throws IOException {
        int beFollowId = accountid;
        int whoFollowId = ((SessionUser)session.getAttribute("login")).getAccountId();
        followService.cancelFollow(beFollowId,whoFollowId);
        response.sendRedirect("/houseofthecoder/userpage/ownuserpage.html?page=0");
    }


}
