package kaixin.com.qingdan.mvp.view;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseMouth_Things;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public interface MouthThingsView {
    void showThings(int page, List<ResponseMouth_Things.DataBean.ThingsBean> things);
    void showFooterLoading();
    void showFooterLoadFailed();
    void showFooterNoMoreData();
    void showFooterNoSearchData();
}
