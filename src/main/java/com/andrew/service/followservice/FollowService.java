package com.andrew.service.followservice;

import com.andrew.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/28
 */
public interface FollowService {


    boolean getFollowOrNot(int befollowid,int whofollowid);

    void startFollowing(int befollowid,int whofollowid);

    List<User> getAllFollowing(int accountId);

    void cancelFollow(int befollowid,int whofollowid);

}
