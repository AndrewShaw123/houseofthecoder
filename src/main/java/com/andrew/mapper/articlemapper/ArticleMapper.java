package com.andrew.mapper.articlemapper;

import com.andrew.model.Article;
import com.andrew.model.SimpleArticle;
import com.andrew.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/8
 */
public interface ArticleMapper {

    /**
     * 保存文章的信息到数据库
     *
     * @param article 文章信息
     */
    void saveNewArticle(@Param("article") Article article);

    /**
     * 查看文章
     *
     * @return 文章信息
     */
    Article queryOneArticleByArticleId(@Param("articleid")Integer articleId);

    /**
     *
     * @param sortId
     * @return
     */
    String querySortBySortId(@Param("sortId") Integer sortId);

    /**
     *  根据AccountId获得用户名
     *
     * @param accountId
     * @return
     */
    User queryWriterByAccountId(@Param("accountId") Integer accountId);

    /**
     *  更新文章浏览数量
     *
     * @param articleId 唯一标识文章的id号
     */
    void updateViewCount(@Param("articleId")Integer articleId,@Param("viewcount")Integer viewcount);

    /**
     * 分页获得所有的文章
     *
     * @return 分页文章
     */
    List<SimpleArticle> queryAllArticleByPageOrderByViewCount(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    /**
     * 分页获得所有我的文章
     *
     * @return 分页文章
     */
    List<SimpleArticle> queryAllArticleByPageOrderByDate(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("accountId")Integer accountId);

    /**
     * 分页获得所有我关注的文章
     *
     * @return 分页文章
     */
    List<SimpleArticle> queryAllFollowArticleByPageOrderByDate(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,@Param("whoFollowId")Integer whoFollowId);

    /**
     * 根据分类查询分页文章
     *
     * @param sortId 分页号
     * @return 同一类的文章
     */
    List<SimpleArticle> queryAllSortArticle(@Param("sortId")Integer sortId, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 查询文章数量
     *
     * @param accountId 用户id
     * @return 文章数量
     */
    int queryArticleCount(@Param("accountId") Integer accountId);

    /**
     * 查询分类文章数量
     *
     * @param sortId 文章分类id
     * @return 分类文章数量
     */
    int queryArticleCountBySortId(@Param("sortId")Integer sortId);

    /**
     * 通过分类id获得分类的名称
     *
     * @param sortId 分类id
     * @return 分类名称
     */
    Map<String,String> getSortNameBySortId(@Param("sortId")Integer sortId);

    /**
     * 通过文章id查找作者用户id
     *
     * @param articleId 文章Id
     * @return 发表这篇文章的用户id
     */
    int queryAccountIdByArticleId(@Param("articleId")Integer articleId);

    /**
     * 查询用户所有文章被访问的总数量
     *
     * @param accountId 用户id
     * @return 数量
     */
    Integer querySumViewCountByAccountId(@Param("accountId") Integer accountId);

    /**
     * 查询文章数量
     *
     * @param whoFollowId 用户id
     * @return 文章数量
     */
    int queryFollowArticleCount(@Param("whoFollowId") Integer whoFollowId);

    void deleteArticleByArticleId(@Param("articleId")int articleId,@Param("content")String content);

}
