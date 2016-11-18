package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import kaixin.com.qingdan.entity.ResponseCategory;
import kaixin.com.qingdan.mvp.model.CategoryModel;
import kaixin.com.qingdan.mvp.model.modelImpl.CategoryModelImpl;
import kaixin.com.qingdan.mvp.presenter.CategoryPresenter;
import kaixin.com.qingdan.mvp.view.CategoryView;
import kaixin.com.qingdan.utils.Apis;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class CategoryPresenterImpl implements CategoryPresenter{
    private CategoryModel model;
    private CategoryView view;

    public CategoryPresenterImpl(CategoryView view) {
        this.view = view;
        model = new CategoryModelImpl();
    }

    @Override
    public void loadData() {
        model.loadData(Apis.URL_CATEGORY, new CategoryModel.CategoryCallbcak() {
            @Override
            public void loadCategorySuccess(ResponseCategory.DataBean1 data) {
                view.showData(data);
            }

            @Override
            public void loadFialed() {
                view.showFailed();
            }
        });
    }
}
