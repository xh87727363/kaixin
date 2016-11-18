package kaixin.com.qingdan.mvp.model;

import kaixin.com.qingdan.entity.ResponseBatching;
import kaixin.com.qingdan.entity.ResponseDailyTips;

/**
 * Created by Administrator on 2016/10/20.
 */

public interface MainModel {
    void loadBatching(onBatchingLoadCallback callback);
    void loadDailyTaps(onDailyTapCallback callback);
    public interface  onBatchingLoadCallback{
        void onBatchingLoadSuccess(ResponseBatching batching);
        void  onBatchingFialed();

    }
    public interface onDailyTapCallback{
        void loadDailyTapsSuccess(ResponseDailyTips dailyTips);
        void loadDailyTapsFailed();
    }
}
