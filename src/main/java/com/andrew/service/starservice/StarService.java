package com.andrew.service.starservice;

import com.andrew.model.SimpleArticle;

import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/29
 */
public interface StarService {

    boolean getStarOrNot(int articleId,int accountId);

    void startStar(int articleId,int accountId);

    List<SimpleArticle> getAllStar(int accountid);

    void cancelStar(int whoCancelId,int articleId);

}
