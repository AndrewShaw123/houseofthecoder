package com.andrew.service.managearticle;


import com.andrew.model.Article;
import com.andrew.model.UserPageInfo;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/8
 */
public interface ArticleService {

    /**
     * 发表文章
     *
     * @param  article 文章信息
     */
    void postArticle(Article article);

    /**
     * 查看文章的具体信息
     *
     * @param articleid 唯一标识文章的id
     * @return 文章信息
     */
    Article checkArticle(Integer articleid);

    /**
     * 更新浏览数量
     *
     */
    void updateViewCount();

    /**
     * 删除文章
     */
    void deleteArticle(int articleId);

}
