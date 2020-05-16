package com.andrew.controller.signinsignupcontroller;

import com.andrew.model.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/9
 */
@Controller
public class BasicController {

    @PostMapping("/getLoginOrNot")
    @ResponseBody
    public SessionUser getLoginOrNot(HttpSession session){
        SessionUser login = (SessionUser)session.getAttribute("login");
        if(login!=null){
            return login;
        }
        return null;
    }

}
