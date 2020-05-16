package com.andrew.service.signinsignupservice.impl;

import com.andrew.mapper.signinsignupmapper.SignupMapper;
import com.andrew.model.Account;
import com.andrew.model.User;
import com.andrew.service.signinsignupservice.SignupService;
import com.andrew.utils.Md5EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
@Service
public class SignupServiceImpl implements SignupService {

    private static final String DEFAULT_ICON = "defaultIcon.png";
    private static final String DEFAULT_ROLE = "用户";

    @Autowired
    private SignupMapper signupMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signupService(String username, String password) {
        //MD5加密转换为byte数组存储
        byte[] pwd = Md5EncryptUtils.encryptByMD5(password);
        //注册账户信息
        Account account = new Account();
        account.setAccountName(username);
        account.setPassword(pwd);
        signupMapper.insertAccountNameAndPassword(account);
        Integer accountid = account.getId();
        System.out.println("------------------------"+accountid);

        //默认昵称为登录名，登录后可修改
        User user = new User();
        user.setAccountId(accountid);
        user.setUsername(username);
        user.setUserImg(DEFAULT_ICON);
        signupMapper.insertUserNameInUser(user);
        //添加用户角色数据
        signupMapper.insertUserRole(accountid,DEFAULT_ROLE);
    }

    @Override
    public Account vaildUserName(String username) {
        Account account = signupMapper.queryByUserName(username);
        return account;
    }
}
