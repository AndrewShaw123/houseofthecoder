package com.andrew.service.managearticle.impl;

import com.andrew.mapper.articlemapper.ArticleMapper;
import com.andrew.model.Article;
import com.andrew.model.DetailArticle;
import com.andrew.model.UserPageInfo;
import com.andrew.service.managearticle.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/8
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String DELETE_CONTENT = "<h3>文章已被删除</h3>";

    @Autowired
    private ArticleMapper articleMapper;

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public void postArticle(Article article) {
        articleMapper.saveNewArticle(article);
    }

    @Override
    public Article checkArticle(Integer articleid) {
        return articleMapper.queryOneArticleByArticleId(articleid);
    }

    @Override
    public void updateViewCount() {

        Set<Object> articleIds = redisTemplate.opsForHash().keys("article");

        if(articleIds.size()==0){
            logger.info("缓存中没有数据需要保存到数据库....");
            return;
        }

        for(Object articleid:articleIds){
            System.out.println(articleid);
            Integer id = Integer.parseInt(String.valueOf(articleid));
            DetailArticle article = (DetailArticle)redisTemplate.opsForHash().get("article", articleid);
            articleMapper.updateViewCount(id,article.getViewCount());
        }


    }

    @Override
    public void deleteArticle(int articleId) {

        if(redisTemplate.hasKey("article")){

            logger.info("缓存中有article");

            if(redisTemplate.opsForHash().get("article",""+articleId)!=null){
                //查询redis
                logger.info("缓存中有article，有指定的articleId="+articleId+",删除文章时同时删除缓存");
                redisTemplate.opsForHash().delete("article",""+articleId);
            }
        }

        articleMapper.deleteArticleByArticleId(articleId,DELETE_CONTENT);
    }

}
