package kaixin.com.qingdan.mvp.view;

import kaixin.com.qingdan.entity.ResponseCategory;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public interface CategoryView {
    void showData(ResponseCategory.DataBean1 data);
    void showFailed();
}
