package com.andrew.service.managearticle.impl;

import com.andrew.annotation.MyLog;
import com.andrew.mapper.articlemapper.ArticleMapper;
import com.andrew.mapper.commentmapper.CommentMapper;
import com.andrew.mapper.followmapper.FollowMapper;
import com.andrew.model.*;
import com.andrew.service.managearticle.QueryArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/8
 */
@Service
public class QueryArticleServiceImpl implements QueryArticleService {

    private static final Integer PAGE_SIZE=10;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DetailArticle getArticelDetail(Article article) {
        String sort = articleMapper.querySortBySortId(article.getSortId());
        User user = articleMapper.queryWriterByAccountId(article.getAccountId());
        LocalDateTime localDateTime = article.getUploadTime().toLocalDateTime();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = localDateTime.format(dtf);
        DetailArticle detailArticle = new DetailArticle(user.getUsername(),user.getUserImg(),article.getAccountId(),sort,article.getTitle(),article.getContent(),time,article.getLikeCount(),article.getHateCount(), article.getViewCount());
        return detailArticle;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @MyLog(operationType="查找文章操作",operationName = "查看首页文章（getPageArticle）")
    public MainPageInfo getPageArticle(Integer pageNum) {

        List<SimpleArticle> articles = articleMapper.queryAllArticleByPageOrderByViewCount(pageNum*PAGE_SIZE,PAGE_SIZE);
        int articleCount = articleMapper.queryArticleCount(null);
        MainPageInfo mainPageInfo = unitArticleAndPageInfo(articles,pageNum,articleCount);
        return mainPageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @MyLog(operationType="查找文章操作",operationName = "查看自己文章（getPageMyArticle）")
    public MainPageInfo getPageMyArticle(Integer pageNum,Integer accountId) {
        List<SimpleArticle> articles = articleMapper.queryAllArticleByPageOrderByDate(pageNum*PAGE_SIZE,PAGE_SIZE,accountId);
        int articleCount = articleMapper.queryArticleCount(accountId);
        MainPageInfo mainPageInfo = unitArticleAndPageInfo(articles,pageNum,articleCount);

        return mainPageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @MyLog(operationType="查找文章操作",operationName = "查看分类文章（getSortPageArticle）")
    public MainPageInfo getSortPageArticle(Integer sortId, Integer pageNum) {

        List<SimpleArticle> articles = articleMapper.queryAllSortArticle(sortId,pageNum*PAGE_SIZE,PAGE_SIZE);
        int articleCount = articleMapper.queryArticleCountBySortId(sortId);
        MainPageInfo mainPageInfo = unitArticleAndPageInfo(articles,pageNum,articleCount);
        return mainPageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @MyLog(operationType="查找文章操作",operationName = "查看关注作者的文章（getSortPageArticle）")
    public MainPageInfo getPageMyFollowArticle(Integer pageNum, Integer accountId) {
        List<SimpleArticle> articles = articleMapper.queryAllFollowArticleByPageOrderByDate(pageNum*PAGE_SIZE,PAGE_SIZE,accountId);
        int articleCount = articleMapper.queryFollowArticleCount(accountId);
        MainPageInfo mainPageInfo = unitArticleAndPageInfo(articles,pageNum,articleCount);
        return mainPageInfo;
    }

    @Override
    public Map<String, String> getSortName(Integer sortId) {
        Map<String, String> sortNameBySortId = articleMapper.getSortNameBySortId(sortId);
        return sortNameBySortId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserPageInfo getUserPageInfo(Integer accountId) {

        Integer viewNum = articleMapper.querySumViewCountByAccountId(accountId);
        Integer articleNum = articleMapper.queryArticleCount(accountId);
        Integer fanNum = followMapper.queryCountOfFollowing(accountId);
        Integer commentNum = commentMapper.querySumCommentByAccountId(accountId);
        UserPageInfo userPageInfo = new UserPageInfo(viewNum,articleNum,fanNum,commentNum);
        return userPageInfo;
    }

    private MainPageInfo unitArticleAndPageInfo(List<SimpleArticle> articles, int pageNum, int articleCount){
        int nextPage = pageNum+1;
        int prePage = pageNum-1;
        int total = articleCount/PAGE_SIZE;
        if(articleCount%PAGE_SIZE!=0){
            total++;
        }
        MainPageInfo mainPageInfo = new MainPageInfo(articles,total,nextPage,prePage,pageNum);
        return mainPageInfo;
    }
}
