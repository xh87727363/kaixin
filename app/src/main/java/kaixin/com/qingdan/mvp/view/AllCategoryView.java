package kaixin.com.qingdan.mvp.view;

import kaixin.com.qingdan.entity.ResponseAllCategory;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public interface AllCategoryView {
    void showLoading();
    void showHidenLoading();
    void showLoadFialed();
    void showDataSuccess(ResponseAllCategory allCategory);
}
