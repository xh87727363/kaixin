package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import kaixin.com.qingdan.entity.ResponseArticleCollections;
import kaixin.com.qingdan.mvp.model.ArticleCollectionModel;
import kaixin.com.qingdan.mvp.model.modelImpl.ArticleCollectionModelImpl;
import kaixin.com.qingdan.mvp.presenter.ArticleCollectionsPresenter;
import kaixin.com.qingdan.mvp.view.ArticleColltationsView;

/**
 * Created by Administrator on 2016/11/3.
 */

public class ArticleCollectionsPresenterImpl implements ArticleCollectionsPresenter {
    private ArticleCollectionModel model;
    private ArticleColltationsView view;

    public ArticleCollectionsPresenterImpl(ArticleColltationsView view) {
        this.view = view;
        model = new ArticleCollectionModelImpl();

    }

    @Override
    public void loadDatas(int article_ID) {
        model.loaddatas(article_ID, new ArticleCollectionModel.ArticleCoollectionCallback() {
            @Override
            public void loadDatasSuccess(ResponseArticleCollections articleCollections) {
                view.showDatas(articleCollections);
            }

            @Override
            public void loadDatasFailed() {
            }
        });
    }
}
