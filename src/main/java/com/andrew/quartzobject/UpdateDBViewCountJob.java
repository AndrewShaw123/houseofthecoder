package com.andrew.quartzobject;

import com.andrew.service.managearticle.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/9
 */
@Component
public class UpdateDBViewCountJob {

    @Autowired
    private ArticleService articleService;

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void execute() {
        logger.info("quartz执行方法...");

        articleService.updateViewCount();
        //设置缓存过期
        redisTemplate.delete("article");
    }
}
