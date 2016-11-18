package kaixin.com.qingdan.mvp.model;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseMainListData;
import kaixin.com.qingdan.entity.ResponseReputation;

/**
 * Created by Administrator on 2016/10/24.
 */

public interface MainListModel {
    void loadNextPageDatas(String url,CallBack callBack);
    public interface  CallBack{
        void loadCollectionsSuccess(List<ResponseMainListData.DataBean.CollectionsBean> collectionsBeen);
        void loadNodesSuccess(List<ResponseMainListData.DataBean.NodesBean> nodesBeen);
        void loadArticlesSuccess(List<ResponseMainListData.DataBean.ArticlesBean> articlesBeen);
        void noMoreData();
        void loadFailedData();
    }
    void loadReputationData(ReputationCallback callback);
    public interface ReputationCallback{
        void loadRequtataionSuccess(List<ResponseReputation.DataBean.RankingsBean> rankings);
        void loadRequtationFailed();
    }
}
