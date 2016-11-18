package kaixin.com.qingdan.mvp.model;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseMouthList;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public interface MouthListModel {
    void loadNextPageDatas(MouthListCallback callback);
    interface MouthListCallback{
        void loadNxetPageSuccess(List<ResponseMouthList.DataBean.RankingsBean> rankings);
        void loadNxetPageFailed();
        void noMoreData();
    }
}
