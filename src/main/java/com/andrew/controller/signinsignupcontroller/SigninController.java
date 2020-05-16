package com.andrew.controller.signinsignupcontroller;

import com.andrew.annotation.MyLog;
import com.andrew.model.LoginResultEnum;
import com.andrew.service.signinsignupservice.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
@Controller
public class SigninController {

    @Autowired
    private SigninService signinService;

    @PostMapping("/login")
    public String login(HttpServletRequest request,String username, String password){


        String loginIpAddr = getLoginIpAddr(request);
        Timestamp loginTime = getCurrentTime();
        LoginResultEnum resultEnum = signinService.login(username,password,loginIpAddr,loginTime);
        String toPage = resultEnum.getToPage();
        String message = resultEnum.getMessage();

        if(resultEnum==LoginResultEnum.USERNAMENOTPASS||resultEnum==LoginResultEnum.PASSWORDNOTPASS){
            return "redirect:"+toPage+"?error="+message;
        }else {
            return "redirect:"+toPage+"?page=0";
        }
    }

    private String getLoginIpAddr(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private Timestamp getCurrentTime(){
        return Timestamp.valueOf(LocalDateTime.now());
    }

}
