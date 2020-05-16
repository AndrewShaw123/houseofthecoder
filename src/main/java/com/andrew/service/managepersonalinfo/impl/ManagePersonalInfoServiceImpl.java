package com.andrew.service.managepersonalinfo.impl;

import com.andrew.mapper.manageuserinfomapper.UserMapper;
import com.andrew.model.SessionUser;
import com.andrew.model.User;
import com.andrew.service.managepersonalinfo.ManagePersonalInfoService;
import com.andrew.utils.Md5EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/9
 */
@Service
public class ManagePersonalInfoServiceImpl implements ManagePersonalInfoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getPersonalInfo(Integer accountid) {
        User user = userMapper.queryUserInfoByAccountId(accountid);
        return user;
    }

    @Override
    public void updatePersonalInfo(User user) {
        userMapper.updateUserInfoByAccountId(user);
    }

    @Override
    public void updatePersonalImg(String userImg, Integer accountId) {
        userMapper.updateUserImgByAccountId(userImg,accountId);
    }

    @Override
    public void changePassword(Integer accountId, String password) {
        byte[] pwd = Md5EncryptUtils.encryptByMD5(password);
        userMapper.updateUserPasswordByAccountId(accountId,pwd);
    }

    @Override
    public User getUserPageInfo(Integer accountId) {
        User user = userMapper.queryUserInfoByAccountId(accountId);
        return user;
    }
}
