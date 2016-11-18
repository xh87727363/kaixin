package kaixin.com.qingdan.mvp.model;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseMouth_Things;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public interface MouthThingsModel {
    void loadData(String url,MouthRankingCallback callback);
    interface  MouthRankingCallback{
        void loadSuccess(List<ResponseMouth_Things.DataBean.ThingsBean> things);
        void loadFailed();
        void noMoreData();
        void noSearchData();
    }
}
