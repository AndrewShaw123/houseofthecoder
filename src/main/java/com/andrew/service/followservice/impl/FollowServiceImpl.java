package com.andrew.service.followservice.impl;

import com.andrew.mapper.followmapper.FollowMapper;
import com.andrew.model.User;
import com.andrew.service.followservice.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/28
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowMapper followMappaer;


    @Override
    public boolean getFollowOrNot(int befollowid, int whofollowid) {
        int result = followMappaer.queryFollowExistByWhoFollowAndBeFollow(whofollowid, befollowid);
        if(result==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void startFollowing(int befollowid, int whofollowid) {
        followMappaer.inserWhoFollowIdAndBeFollowId(whofollowid,befollowid);
    }

    @Override
    public List<User> getAllFollowing(int accountId) {
        List<User> userIdUserNameUserImgByWhoFollowId = followMappaer.getUserIdUserNameUserImgByWhoFollowId(accountId);
        return userIdUserNameUserImgByWhoFollowId;
    }

    @Override
    public void cancelFollow(int befollowid, int whofollowid) {
        followMappaer.deleteByBeFollowIdAndWhoFollowId(whofollowid,befollowid);
    }
}
