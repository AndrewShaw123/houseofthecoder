package com.andrew.controller.signinsignupcontroller;

import com.andrew.model.Account;
import com.andrew.service.signinsignupservice.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册功能控制器
 *
 * @author andrew
 * @date 2020/1/7
 */
@Controller
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public String signup(String username,String password){
        signupService.signupService(username,password);
        return "redirect:sign_in.html?signup=success";
    }

    @PostMapping("/validUsername")
    @ResponseBody
    public Map<String,Integer> vaildUsername(String username){
        Map<String,Integer> map = new HashMap<>(1);
        Account account = signupService.vaildUserName(username);
        if(account!=null){
            //用户名已存在
            map.put("isExist",1);
        }else{
            //用户名不存在
            map.put("isExist",0);
        }
        return map;
    }
}
