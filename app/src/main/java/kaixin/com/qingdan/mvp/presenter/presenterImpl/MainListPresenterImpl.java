package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseMainListData;
import kaixin.com.qingdan.entity.ResponseReputation;
import kaixin.com.qingdan.mvp.model.MainListModel;
import kaixin.com.qingdan.mvp.model.modelImpl.MainListModelImpl;
import kaixin.com.qingdan.mvp.presenter.MainListPresenter;
import kaixin.com.qingdan.mvp.view.MainListView;
import kaixin.com.qingdan.utils.UrlHandler;

/**
 * Created by Administrator on 2016/10/24.
 */

public class MainListPresenterImpl implements MainListPresenter {
    private MainListModel mainListModel;
    private MainListView mainListView;
    private String urlTag;
    private int nextPage =1;

    public MainListPresenterImpl(MainListView mainListView,String urlTag) {
        this.mainListView = mainListView;
        this.urlTag = urlTag;
        mainListModel = new MainListModelImpl();
    }

    @Override
    public void loadMainListData() {
        mainListView.showRecycleViewFooterLoading();
        String url = UrlHandler.handlerUrl(urlTag,nextPage);
        mainListModel.loadNextPageDatas(url,new MainListModel.CallBack() {
            @Override
            public void loadCollectionsSuccess(List<ResponseMainListData.DataBean.CollectionsBean> collectionsBeen) {
                mainListView.showCollcotion(collectionsBeen);
            }

            @Override
            public void loadNodesSuccess(List<ResponseMainListData.DataBean.NodesBean> nodesBeen) {
                mainListView.showNodes(nodesBeen);
            }

            @Override
            public void loadArticlesSuccess(List<ResponseMainListData.DataBean.ArticlesBean> articlesBeen) {
                mainListView.showArticles(articlesBeen);
            }

            @Override
            public void noMoreData() {
                mainListView.showNoMoreData();
            }

            @Override
            public void loadFailedData() {
                mainListView.loadDataFailed();
                nextPage--;
            }
        });
        nextPage++;
    }

    @Override
    public void loadRequtationData() {
        mainListModel.loadReputationData(new MainListModel.ReputationCallback() {
            @Override
            public void loadRequtataionSuccess(List<ResponseReputation.DataBean.RankingsBean> rankings) {
                mainListView.showRequtationSuccess(rankings);
            }

            @Override
            public void loadRequtationFailed() {
                mainListView.showRequtataionFailed();
            }
        });
    }
}
