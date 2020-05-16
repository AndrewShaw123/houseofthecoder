package com.andrew.controller.starcontroller;

import com.andrew.model.SessionUser;
import com.andrew.model.SimpleArticle;
import com.andrew.service.starservice.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/29
 */
@Controller
public class StarController {

    @Autowired
    private StarService starService;

    @PostMapping("/getStarOrNot")
    @ResponseBody
    public String getStarOrNot(HttpSession session,int articleId){

        SessionUser login = (SessionUser) session.getAttribute("login");
        if(login==null){
            return null;
        }
        int accountId = login.getAccountId();
        if(starService.getStarOrNot(articleId,accountId)){
            return "exist";
        }else{
            return null;
        }
    }

    @PostMapping("/startStar")
    @ResponseBody
    public String startStar(HttpSession session,int articleId){

        SessionUser login = (SessionUser)session.getAttribute("login");
        if(login==null){
            return null;
        }
        int accountId = login.getAccountId();
        starService.startStar(articleId,accountId);
        return "success";
    }

    @GetMapping("/getAllStar")
    @ResponseBody
    public List<SimpleArticle> getAllStar(HttpSession session){
        Integer accountId = ((SessionUser) session.getAttribute("login")).getAccountId();
        List<SimpleArticle> allStar = starService.getAllStar(accountId);
        return allStar;
    }

    @GetMapping("userpage/cancelStar")
    public void cancelStar(HttpSession session, HttpServletResponse response, int articleid) throws IOException {
        int whoCancelId = ((SessionUser)session.getAttribute("login")).getAccountId();
        starService.cancelStar(whoCancelId,articleid);
        response.sendRedirect("/houseofthecoder/userpage/ownuserpage.html?page=0");
    }


}
