package com.andrew.service.starservice.impl;

import com.andrew.mapper.starmapper.StarMapper;
import com.andrew.model.SimpleArticle;
import com.andrew.service.starservice.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/29
 */
@Service
public class StarServiceImpl implements StarService {

    @Autowired
    private StarMapper starMapper;

    @Override
    public boolean getStarOrNot(int articleId, int accountId) {
        int result = starMapper.queryStarExistByArticleIdAndAccountId(articleId, accountId);
        if(result==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void startStar(int articleId, int accountId) {
        starMapper.insertStar(articleId,accountId);
    }

    @Override
    public List<SimpleArticle> getAllStar(int accountid) {
        return starMapper.getAllStarByWhoStarId(accountid);
    }

    @Override
    public void cancelStar(int whoCancelId, int articleId) {
        starMapper.deleteStarByBeStarArticleIdAndWhoStarId(articleId,whoCancelId);
    }
}
