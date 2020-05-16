package com.andrew.service.signinsignupservice.impl;

import com.andrew.annotation.MyLog;
import com.andrew.mapper.signinsignupmapper.SigninMapper;
import com.andrew.model.Account;
import com.andrew.model.LoginLog;
import com.andrew.model.LoginResultEnum;
import com.andrew.model.SessionUser;
import com.andrew.service.signinsignupservice.SigninService;
import com.andrew.utils.Md5EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
@Service
public class SigninServiceImpl implements SigninService {

    private static final String ROLE_USER = "用户";

    @Autowired
    private SigninMapper signinMapper;

    @Override
    @MyLog(operationType="查询操作",operationName = "登录（login）")
    public LoginResultEnum login(String username, String password, String loginIpAddr, Timestamp loginTime) {
        Account dbAccount = signinMapper.selectByUsername(username);
        if(dbAccount==null){
            return LoginResultEnum.USERNAMENOTPASS;
        }else{
            if(Md5EncryptUtils.validatePassword(password,dbAccount.getPassword())){
                HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
                Integer accountId = dbAccount.getId();
                SessionUser sessionUser = signinMapper.selectBasicSessionInfo(accountId);
                String role = signinMapper.selectRoleByAccountid(dbAccount.getId());
                saveUserLoginIpAndTime(accountId,loginIpAddr,loginTime);
                sessionUser.setRole(role);
                session.setAttribute("login",sessionUser);
                if(role.equals(ROLE_USER)){
                    return LoginResultEnum.USERPASS;
                }else{
                    return LoginResultEnum.MANAGEPASS;
                }
            }else{
                return LoginResultEnum.PASSWORDNOTPASS;
            }
        }
    }

    @Override
    public void saveUserLoginIpAndTime(Integer accountId,String loginIpAddr, Timestamp loginTime) {
        LoginLog loginLog = new LoginLog();
        loginLog.setAccountId(accountId);
        loginLog.setLoginAddr(loginIpAddr);
        loginLog.setLoginTime(loginTime);
        signinMapper.insertUserLoginLog(loginLog);
    }

}
