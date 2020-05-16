package com.andrew.mapper.followmapper;

import com.andrew.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/28
 */
public interface FollowMapper {

    Integer queryCountOfFollowing(@Param("accountId")Integer accountId);

    int queryFollowExistByWhoFollowAndBeFollow(@Param("whoFollowId")Integer whoFollowId,@Param("beFollowId")Integer beFollowId);

    void inserWhoFollowIdAndBeFollowId(@Param("whoFollowId")Integer whoFollowId,@Param("beFollowId")Integer beFollowId);

    List<User> getUserIdUserNameUserImgByWhoFollowId(@Param("whoFollowId")Integer whoFollowId);

    void deleteByBeFollowIdAndWhoFollowId(@Param("whoFollowId")Integer whoFollowId,@Param("beFollowId")Integer beFollowId);

}
