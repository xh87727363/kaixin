package kaixin.com.qingdan.mvp.model.modelImpl;

import com.alibaba.fastjson.JSON;

import kaixin.com.qingdan.entity.ResponseMainListData;
import kaixin.com.qingdan.entity.ResponseReputation;
import kaixin.com.qingdan.mvp.model.MainListModel;
import kaixin.com.qingdan.utils.Apis;
import kaixin.com.qingdan.utils.http.HttpUtil;
import kaixin.com.qingdan.utils.http.Request;
import kaixin.com.qingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/10/24.
 */

public class MainListModelImpl implements MainListModel {

    /**
     * 加载数据
     * @param callBack
     */
    @Override
    public void loadNextPageDatas(String url,final CallBack callBack) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseMainListData data = JSON.parseObject(response, ResponseMainListData.class);
                if (data.getData().getMeta().getPagination().getTotal_pages() == data.getData().getMeta().getPagination().getCurrent_page()){
                    callBack.noMoreData();
                }
                if (data.getData().getCollections() !=null){
                    callBack.loadCollectionsSuccess(data.getData().getCollections());
                }else if (data.getData().getArticles() !=null){
                    callBack.loadArticlesSuccess(data.getData().getArticles());
                }else if (data.getData().getNodes() != null){
                    callBack.loadNodesSuccess(data.getData().getNodes());
                }
            }

            @Override
            public void onError() {
                    callBack.loadFailedData();
            }
        });
    }

    @Override
    public void loadReputationData(final ReputationCallback callback) {
        Request.Builder builder = new Request.Builder()
                .url(Apis.URL_REPUTATION)
                .get();
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseReputation reputation = JSON.parseObject(response, ResponseReputation.class);
                if (reputation.getCode() == 0){
                    callback.loadRequtataionSuccess(reputation.getData().getRankings());
                }
            }

            @Override
            public void onError() {
                callback.loadRequtationFailed();
            }
        });
    }
}
