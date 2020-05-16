package com.andrew.controller.signinsignupcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/9
 */
@Controller
public class SignoutController {

    @GetMapping("/signout")
    public String signout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/main.html?page=0";
    }

}
