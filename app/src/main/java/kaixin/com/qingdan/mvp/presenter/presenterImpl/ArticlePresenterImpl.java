package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import android.util.Log;

import kaixin.com.qingdan.entity.ResponseArticleComments;
import kaixin.com.qingdan.entity.ResponseArticlesTitle;
import kaixin.com.qingdan.entity.ResponseRelatedArticles;
import kaixin.com.qingdan.mvp.model.ArticleModel;
import kaixin.com.qingdan.mvp.model.modelImpl.ArticleModelImpl;
import kaixin.com.qingdan.mvp.presenter.ArticlePresenter;
import kaixin.com.qingdan.mvp.view.ArticleView;

/**
 * Created by Administrator on 2016/10/31.
 */

public class ArticlePresenterImpl implements ArticlePresenter {
    private ArticleModel articleModel;
    private ArticleView articleView;

    public ArticlePresenterImpl(ArticleView articleView) {
        this.articleView = articleView;
        this.articleModel = new ArticleModelImpl();
    }

    @Override
    public void loadDatas(int articleID) {
        articleModel.loadDatas(articleID, new ArticleModel.ArticleCallback() {
            @Override
            public void loadArticleTitleSuccess(ResponseArticlesTitle articlesTitle) {
                // 通知view显示TITLE部分
                articleView.showArticleTitle(articlesTitle);
                // 通知view 显示评论总数
                articleView.showCommentsCount(articlesTitle.getData().getCommentCount());
                // 通知view 显示 喜欢的总个数
                articleView.showLikedCount(articlesTitle.getData().getLikeCount());
                if (articlesTitle.getData().getThingCount() > 0){
                        articleView.showLookUpGoods();
                }
            }

            @Override
            public void loadAtricleSuccess(String url) {
                articleView.showArticle(url);
            }

            @Override
            public void loadCommentsSuccess(ResponseArticleComments articleComments) {
               // 显示评论区
                articleView.showArticleComments(articleComments.getData().getComments());
            }

            @Override
            public void loadRelatedArticlesSuccess(ResponseRelatedArticles relatedArticles) {
                Log.d("ArticlePresenterImpl", "articleView:" + articleView);
                articleView.showRelatedAtricles(relatedArticles.getData().getArticles());
            }
        });
    }
}
