package com.andrew.controller.managepersonalinfo;

import com.andrew.mapper.manageuserinfomapper.UserMapper;
import com.andrew.model.SessionUser;
import com.andrew.model.User;
import com.andrew.service.managepersonalinfo.ManagePersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/9
 */
@Controller
public class ManagerPersonalInfoController {

    @Autowired
    private ManagePersonalInfoService managePersonalInfoServicel;

    @PostMapping("/userpage/changePersonalInfo")
    public String changePersonalInfo(HttpSession session,User user){
        SessionUser login =(SessionUser) session.getAttribute("login");
        login.setUsername(user.getUsername());
        user.setAccountId(login.getAccountId());
        managePersonalInfoServicel.updatePersonalInfo(user);
        return "redirect:changeprofile.html?msg=chginf";
    }


    @PostMapping("/userpage/viewPersonalInfo")
    @ResponseBody
    public User viewPersonalInfo(HttpSession session){

        SessionUser login = (SessionUser)session.getAttribute("login");
        Integer accountId = login.getAccountId();
        User personalInfo = managePersonalInfoServicel.getPersonalInfo(accountId);
        return personalInfo;
    }

    @PostMapping("/userpage/changePassword")
    public String changePassword(HttpServletRequest request){
        Integer accountId =((SessionUser) request.getSession().getAttribute("login")).getAccountId();
        String password = request.getParameter("password");
        managePersonalInfoServicel.changePassword(accountId,password);
        return "redirect:changeprofile.html?msg=chgpwd";
    }

    @PostMapping("/userpage/changeImg")
    public String changeImg(HttpServletRequest request,MultipartFile picture) throws IOException {
        if(picture.getOriginalFilename().equals("")){
            return "redirect:changeprofile.html";
        }
        String rootPath = request.getSession().getServletContext().getRealPath("/img/usericon/");
        String originalFile = picture.getOriginalFilename();
        String postFix = originalFile.substring(originalFile.lastIndexOf("."));
        String newFileName = System.currentTimeMillis()+postFix;
        File newFile = new File(rootPath+"/"+newFileName);
        if(!newFile.getParentFile().exists()){
            newFile.getParentFile().mkdirs();
        }
        picture.transferTo(newFile);
        SessionUser login = (SessionUser)request.getSession().getAttribute("login");
        managePersonalInfoServicel.updatePersonalImg(newFileName,login.getAccountId());
        login.setUserImg(newFileName);
        return "redirect:changeprofile.html?msg=chgimg";
    }

    @PostMapping("/getUserPageInfo")
    @ResponseBody
    public User getUserPageInfo(int accountId){
        return managePersonalInfoServicel.getUserPageInfo(accountId);
    }


}
