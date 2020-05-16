package com.andrew.mapper.starmapper;

import com.andrew.model.SimpleArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/29
 */
public interface StarMapper {

    int queryStarExistByArticleIdAndAccountId(@Param("articleId")int articleId,@Param("accountId")int accountId);

    void insertStar(@Param("articleId")int articleId,@Param("accountId")int accountId);

    List<SimpleArticle> getAllStarByWhoStarId(@Param("whoStarId")int whoStarId);

    void deleteStarByBeStarArticleIdAndWhoStarId(@Param("articleId")int articleId,@Param("accountId")int accountId);

}
