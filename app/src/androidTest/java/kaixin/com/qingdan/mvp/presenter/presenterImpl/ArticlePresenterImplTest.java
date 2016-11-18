package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import android.util.Log;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import kaixin.com.qingdan.BuildConfig;
import kaixin.com.qingdan.entity.ResponseArticleComments;
import kaixin.com.qingdan.entity.ResponseArticlesTitle;
import kaixin.com.qingdan.entity.ResponseRelatedArticles;
import kaixin.com.qingdan.mvp.presenter.ArticlePresenter;
import kaixin.com.qingdan.mvp.view.ArticleView;

/**
 * Created by Administrator on 2016/11/1.
 */
public class ArticlePresenterImplTest implements ArticleView {
    private ArticlePresenter articlePresenter;
    @Before
    public void setUp() throws Exception {
            articlePresenter = new ArticlePresenterImpl(this);


    }

    @Test
    public void loadDatas() throws Exception {
        articlePresenter.loadDatas(806);
    }

    @Override
    public void showArticleTitle(ResponseArticlesTitle articlesTitle) {
            Log.d("ArticlePresenterImplTes", articlesTitle.getData().getAuthor().getNickname());
    }

    @Override
    public void showArticleComments(List<ResponseArticleComments.DataBean.CommentsBean> comments) {
            Log.d("ArticlePresenterImplTes", "comments.size():" + comments.size());
             Assert.assertEquals(1,comments.size());

    }

    @Override
    public void showArticle(String url) {
            if (BuildConfig.DEBUG) Log.d("ArticlePresenterImplTes", url);

    }

    @Override
    public void showRelatedAtricles(List<ResponseRelatedArticles.DataBean.ArticlesBean> articles) {
            Log.d("ArticlePresenterImplTes", "articles.size():" + articles.size());
    }

    @Override
    public void showLikedCount(int likeCount) {
        if (BuildConfig.DEBUG) Log.d("ArticlePresenterImplTes", "likeCount:" + likeCount);
    }

    @Override
    public void showCommentsCount(int commentCount) {
    if (BuildConfig.DEBUG) Log.d("ArticlePresenterImplTes", "commentCount:" + commentCount);
    }

    @Override
    public void showLookUpGoods() {
            if (BuildConfig.DEBUG) Log.d("ArticlePresenterImplTes", "lookUp");
    }
}