package kaixin.com.qingdan.mvp.model;

import kaixin.com.qingdan.entity.ResponseCategory;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public interface CategoryModel {
    void loadData(String url,CategoryCallbcak Callbcak);
    interface  CategoryCallbcak{
        void loadCategorySuccess(ResponseCategory.DataBean1 data);
        void loadFialed();
    }
}
