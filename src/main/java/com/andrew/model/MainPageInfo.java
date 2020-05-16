package com.andrew.model;

import java.io.Serializable;
import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/9
 */
public class MainPageInfo implements Serializable {

    private List<SimpleArticle> article;
    private Integer totalPage;
    private Integer nextPage;
    private Integer prePage;
    private Integer pageNum;

    public MainPageInfo(){

    }

    public MainPageInfo(List<SimpleArticle> article, int totalPage, Integer nextPage, Integer prePage,Integer pageNum) {
        this.article = article;
        this.totalPage = totalPage;
        this.nextPage = nextPage;
        this.prePage = prePage;
        this.pageNum = pageNum;
    }

    public List<SimpleArticle> getArticle() {
        return article;
    }

    public void setArticle(List<SimpleArticle> article) {
        this.article = article;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
