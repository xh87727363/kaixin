package kaixin.com.qingdan.mvp.view;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseMouthList;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public interface MouthListView {
    void showNextPageDatas(List<ResponseMouthList.DataBean.RankingsBean> rankings);
    void showNextPageFail();

    void showNoMoreData();
}
