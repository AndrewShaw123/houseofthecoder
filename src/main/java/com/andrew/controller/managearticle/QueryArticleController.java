package com.andrew.controller.managearticle;

import com.andrew.model.*;
import com.andrew.service.managearticle.ArticleService;
import com.andrew.service.managearticle.QueryArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/8
 */
@Controller
public class QueryArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private QueryArticleService queryArticleService;

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/seeDetail")
    @ResponseBody
    public DetailArticle seeDetail(HttpServletRequest request){

        int articleId = Integer.parseInt(request.getParameter("accountid"));
        DetailArticle articelDetail;

        if(redisTemplate.hasKey("article")){

            logger.info("缓存中有article");

            if(redisTemplate.opsForHash().get("article",""+articleId)!=null){
                //查询redis
                logger.info("缓存中有article，有指定的articleId="+articleId+",直接返回缓存");


                articelDetail = (DetailArticle)redisTemplate.opsForHash().get("article",""+articleId);

                //多线程问题
                AtomicInteger viewCount = new AtomicInteger(articelDetail.getViewCount());
                articelDetail.setViewCount(viewCount.incrementAndGet());
                //更新缓存
                redisTemplate.opsForHash().put("article",""+articleId,articelDetail);
            }else{
                //查询数据库

                logger.info("缓存中有article，但是没有指定的articleId="+articleId);

                Article article = articleService.checkArticle(articleId);
                articelDetail = queryArticleService.getArticelDetail(article);
                //多线程问题
                AtomicInteger viewCount = new AtomicInteger(articelDetail.getViewCount());
                articelDetail.setViewCount(viewCount.incrementAndGet());
                //加入缓存
                redisTemplate.opsForHash().put("article",""+articleId,articelDetail);
            }

        }else{
            logger.info("缓存中没有article,直接查询数据库");
            //查询数据库
            Article article = articleService.checkArticle(articleId);
            articelDetail = queryArticleService.getArticelDetail(article);
            //多线程问题
            AtomicInteger viewCount = new AtomicInteger(articelDetail.getViewCount());
            articelDetail.setViewCount(viewCount.incrementAndGet());
            redisTemplate.opsForHash().put("article",""+articleId,articelDetail);
        }
        return articelDetail;
    }




    @GetMapping("/viewAllArticle")
    @ResponseBody
    public MainPageInfo getPageArticle(HttpServletRequest request){
        Integer page = Integer.parseInt(request.getParameter("page"));
        MainPageInfo pageArticle = queryArticleService.getPageArticle(page);
        return pageArticle;
    }

    @GetMapping("/viewAllMyArticle")
    @ResponseBody
    public MainPageInfo getPageMyArticle(HttpServletRequest request){
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer accountId = ((SessionUser)(request.getSession().getAttribute("login"))).getAccountId();
        MainPageInfo pageArticle = queryArticleService.getPageMyArticle(page,accountId);
        return pageArticle;
    }

    @GetMapping("/viewAllOtherArticle")
    @ResponseBody
    public MainPageInfo viewAllOtherArticle(HttpServletRequest request){
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer accountId = Integer.parseInt(request.getParameter("accountId"));
        MainPageInfo pageArticle = queryArticleService.getPageMyArticle(page,accountId);
        return pageArticle;
    }

    @GetMapping("/viewAllSortArticle")
    @ResponseBody
    public MainPageInfo viewAllSortArticle(HttpServletRequest request){
        Integer sortId = Integer.parseInt(request.getParameter("sortid"));
        Integer page = Integer.parseInt(request.getParameter("page"));
        MainPageInfo sortPageArticle = queryArticleService.getSortPageArticle(sortId, page);
        return sortPageArticle;
    }

    @GetMapping("userpage/viewAllFollowArticle")
    @ResponseBody
    public MainPageInfo viewAllFollowArticle(HttpServletRequest request){
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer accountId = ((SessionUser)request.getSession().getAttribute("login")).getAccountId();
        MainPageInfo pageArticle = queryArticleService.getPageMyFollowArticle(page,accountId);
        return pageArticle;
    }

    @GetMapping("/getSortName")
    @ResponseBody
    public Map<String,String> getSortName(HttpServletRequest request){
        Integer sortid = Integer.parseInt(request.getParameter("sortid"));
        Map<String, String> sortName = queryArticleService.getSortName(sortid);
        return sortName;
    }


    @GetMapping("/getBasicUserPageInfo")
    @ResponseBody
    public UserPageInfo getBasicUserPageInfo(HttpServletRequest request){
        int accountId = ((SessionUser)request.getSession().getAttribute("login")).getAccountId();
        UserPageInfo userPageInfo = queryArticleService.getUserPageInfo(accountId);
        return userPageInfo;
    }

    @GetMapping("/getBasicOtherUserPageInfo")
    @ResponseBody
    public UserPageInfo getBasicOtherUserPageInfo(HttpServletRequest request){
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        UserPageInfo userPageInfo = queryArticleService.getUserPageInfo(accountId);
        return userPageInfo;
    }

    @GetMapping("/userpage/deleteArticle")
    public void deleteArticle(HttpServletResponse response, int articleid) throws IOException {
        articleService.deleteArticle(articleid);
        response.sendRedirect("/houseofthecoder/userpage/ownuserpage.html?page=0");
    }
}
