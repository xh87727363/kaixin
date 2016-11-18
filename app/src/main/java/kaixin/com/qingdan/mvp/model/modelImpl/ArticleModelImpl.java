package kaixin.com.qingdan.mvp.model.modelImpl;

import com.alibaba.fastjson.JSON;

import kaixin.com.qingdan.entity.ResponseArticleComments;
import kaixin.com.qingdan.entity.ResponseArticlesTitle;
import kaixin.com.qingdan.entity.ResponseRelatedArticles;
import kaixin.com.qingdan.mvp.model.ArticleModel;
import kaixin.com.qingdan.utils.Apis;
import kaixin.com.qingdan.utils.UrlHandler;
import kaixin.com.qingdan.utils.http.HttpUtil;
import kaixin.com.qingdan.utils.http.Request;
import kaixin.com.qingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/10/31.
 */

public class ArticleModelImpl implements ArticleModel {
    private int articleID;
    private ArticleCallback callback;
    @Override
    public void loadDatas(int articleID, ArticleCallback callback) {
        this.articleID = articleID;
        this.callback = callback;
        loadArticleTitle();
        loadAtricle();
        loadComments();
        loadRelatedArticles();
    }

    @Override
    public void loadArticleTitle() {
        if (callback == null){
            return;
        }
        String url = UrlHandler.handlerUrl(Apis.URL_ARTICLE_TITLE,articleID);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseArticlesTitle articlesTitle = JSON.parseObject(response, ResponseArticlesTitle.class);
                callback.loadArticleTitleSuccess(articlesTitle);
            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    public void loadAtricle() {
        if (callback == null){
            return;
        }
        callback.loadAtricleSuccess(UrlHandler.handlerUrl(Apis.URL_ARTICLE,articleID));

    }

    @Override
    public void loadComments() {
        if (callback == null){
            return;
        }
        String url = UrlHandler.handlerUrl(Apis.URL_ARTICLE_COMMENT,articleID);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseArticleComments articleComments = JSON.parseObject(response, ResponseArticleComments.class);
                callback.loadCommentsSuccess(articleComments);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void loadRelatedArticles() {
        if (callback == null){
            return;
        }
        String url = UrlHandler.handlerUrl(Apis.URL_RELATED_ARTICLES,articleID);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseRelatedArticles relatedArticles = JSON.parseObject(response, ResponseRelatedArticles.class);
                callback.loadRelatedArticlesSuccess(relatedArticles);
            }

            @Override
            public void onError() {

            }
        });
    }
}
