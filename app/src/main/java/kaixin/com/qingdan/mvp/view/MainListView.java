package kaixin.com.qingdan.mvp.view;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseMainListData;
import kaixin.com.qingdan.entity.ResponseReputation;

/**
 * Created by Administrator on 2016/10/24.
 */

public interface MainListView {
    void showCollcotion(List<ResponseMainListData.DataBean.CollectionsBean> collectionsBeen);
    void showNodes(List<ResponseMainListData.DataBean.NodesBean> nodesBeen);
    void showArticles(List<ResponseMainListData.DataBean.ArticlesBean> articlesBeen);

    void showRecycleViewFooterLoading();
    void showNoMoreData();
    void loadDataFailed();

    void showRequtationSuccess(List<ResponseReputation.DataBean.RankingsBean> rankings);

    void showRequtataionFailed();
}
