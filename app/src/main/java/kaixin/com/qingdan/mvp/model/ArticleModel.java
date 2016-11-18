package kaixin.com.qingdan.mvp.model;

import kaixin.com.qingdan.entity.ResponseArticleComments;
import kaixin.com.qingdan.entity.ResponseArticlesTitle;
import kaixin.com.qingdan.entity.ResponseRelatedArticles;

/**
 * Created by Administrator on 2016/10/31.
 */

public interface ArticleModel {
    void loadDatas(int articleID,ArticleCallback callback);
    void loadArticleTitle();
    void loadAtricle();
    void loadComments();
    void loadRelatedArticles();
    public interface ArticleCallback{
        void loadArticleTitleSuccess(ResponseArticlesTitle articlesTitle);
        void loadAtricleSuccess(String url);
        void loadCommentsSuccess(ResponseArticleComments articleComments);
        void loadRelatedArticlesSuccess(ResponseRelatedArticles relatedArticles);
    }
}
