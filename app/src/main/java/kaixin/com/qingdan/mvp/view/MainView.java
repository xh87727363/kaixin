package kaixin.com.qingdan.mvp.view;

import kaixin.com.qingdan.entity.ResponseBatching;
import kaixin.com.qingdan.entity.ResponseDailyTips;

/**
 * Created by Administrator on 2016/10/20.
 */

public interface MainView {
    void loadBatchingSuccess(ResponseBatching batching);
    void loadBatchingFialed();
    void showDailyTips(ResponseDailyTips dailyTips);
    void laodDailyTipsFailed();
}
