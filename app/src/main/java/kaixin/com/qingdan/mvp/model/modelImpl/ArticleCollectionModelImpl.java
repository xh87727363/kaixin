package kaixin.com.qingdan.mvp.model.modelImpl;

import com.alibaba.fastjson.JSON;

import kaixin.com.qingdan.entity.ResponseArticleCollections;
import kaixin.com.qingdan.mvp.model.ArticleCollectionModel;
import kaixin.com.qingdan.utils.Apis;
import kaixin.com.qingdan.utils.UrlHandler;
import kaixin.com.qingdan.utils.http.FormBody;
import kaixin.com.qingdan.utils.http.HttpUtil;
import kaixin.com.qingdan.utils.http.Request;
import kaixin.com.qingdan.utils.http.RequestBody;
import kaixin.com.qingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/3.
 */

public class ArticleCollectionModelImpl implements ArticleCollectionModel {
    @Override
    public void loaddatas(int article_ID, final ArticleCoollectionCallback callback) {
        String url = Apis.URL_ARTICLE_COLLECTION;
        String collection_body = UrlHandler.handlerUrl(Apis.URL_ARTICLE_COLLECTION_BODY,article_ID);
        RequestBody body= new FormBody.Builder()
                .add("requests",collection_body).build();
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(body);
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseArticleCollections articleCollections = JSON.parseObject(response, ResponseArticleCollections.class);
                if (articleCollections != null){
                    callback.loadDatasSuccess(articleCollections);
                }
            }

            @Override
            public void onError() {
                    callback.loadDatasFailed();
            }
        });
    }
}
