package com.andrew.service.managearticle;

import com.andrew.model.Article;
import com.andrew.model.DetailArticle;
import com.andrew.model.MainPageInfo;
import com.andrew.model.UserPageInfo;

import java.util.Map;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/8
 */
public interface QueryArticleService {


    /**
     * 查询 文章具体信息
     *
     * @return 文章具体信息
     */
    DetailArticle getArticelDetail(Article article);

    /**
     *  分页查询文章
     *
     * @param pageNum 请求页数
     * @return 分页文章,包含分页信息
     */
    MainPageInfo getPageArticle(Integer pageNum);

    /**
     *  分页查询我的文章
     *
     * @param pageNum 请求页数
     * @param accountId 用户id
     * @return 分页文章,包含分页信息
     */
    MainPageInfo getPageMyArticle(Integer pageNum,Integer accountId);

    /**
     *  分页查询文章
     *
     * @param sortId 分类id号
     * @param pageNum 请求页数
     * @return 分页分类文章，包含分页信息
     */
    MainPageInfo getSortPageArticle(Integer sortId,Integer pageNum);

    /**
     *  分页查询我的关注人的文章
     *
     * @param pageNum 请求页数
     * @param accountId 我的用户id
     * @return 分页文章,包含分页信息
     */
    MainPageInfo getPageMyFollowArticle(Integer pageNum,Integer accountId);

    /**
     * 返回分类名称
     * @param sortId 分类id
     * @return 分类名称
     */
    Map<String,String> getSortName(Integer sortId);

    /**
     * 获得个人主页的基本信息，文章数量，关注数量，评论数量，访问数量
     *
     * @param accountId 用户id
     * @return 文章数量，关注数量，评论数量，访问数量对象
     */
    UserPageInfo getUserPageInfo(Integer accountId);
}
