package kaixin.com.qingdan.mvp.view;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseArticleComments;
import kaixin.com.qingdan.entity.ResponseArticlesTitle;
import kaixin.com.qingdan.entity.ResponseRelatedArticles;

/**
 * Created by Administrator on 2016/10/31.
 */

public interface ArticleView {
    void showArticleTitle(ResponseArticlesTitle articlesTitle);
    void showArticleComments(List<ResponseArticleComments.DataBean.CommentsBean> comments);
    void showArticle(String url);
    void showRelatedAtricles(List<ResponseRelatedArticles.DataBean.ArticlesBean> articles);
    void showLikedCount(int likeCount);
    void showCommentsCount(int commentCount);
    void showLookUpGoods();
}
