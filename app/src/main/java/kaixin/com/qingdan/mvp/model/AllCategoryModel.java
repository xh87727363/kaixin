package kaixin.com.qingdan.mvp.model;

import kaixin.com.qingdan.entity.ResponseAllCategory;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public interface AllCategoryModel {
    void loadData(Callback callback);
    public  interface  Callback{
        void loadDataSuccess(ResponseAllCategory allCategory);
        void loadDataFailed();
    }
}
