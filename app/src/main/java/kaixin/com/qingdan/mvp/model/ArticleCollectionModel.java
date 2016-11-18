package kaixin.com.qingdan.mvp.model;

import kaixin.com.qingdan.entity.ResponseArticleCollections;

/**
 * Created by Administrator on 2016/11/3.
 */

public interface ArticleCollectionModel {
    void loaddatas(int article_ID,ArticleCoollectionCallback callback);
    interface  ArticleCoollectionCallback{
        void loadDatasSuccess(ResponseArticleCollections articleCollections);
        void loadDatasFailed();
    }
}
