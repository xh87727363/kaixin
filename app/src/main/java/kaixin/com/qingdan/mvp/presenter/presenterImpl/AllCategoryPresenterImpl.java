package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import kaixin.com.qingdan.entity.ResponseAllCategory;
import kaixin.com.qingdan.mvp.model.AllCategoryModel;
import kaixin.com.qingdan.mvp.model.modelImpl.AllCategoryModelImpl;
import kaixin.com.qingdan.mvp.presenter.AllCategoryPresenter;
import kaixin.com.qingdan.mvp.view.AllCategoryView;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class AllCategoryPresenterImpl implements AllCategoryPresenter, AllCategoryModel.Callback {
    private AllCategoryModel model;
    private AllCategoryView view;

    public AllCategoryPresenterImpl(AllCategoryView view) {
        this.view = view;
        model = new AllCategoryModelImpl();
    }

    @Override
    public void loadData() {
        view.showLoading();
        model.loadData(this);
    }

    @Override
    public void loadDataSuccess(ResponseAllCategory allCategory) {
        view.showHidenLoading();
        view.showDataSuccess(allCategory);
    }

    @Override
    public void loadDataFailed() {
        view.showHidenLoading();
        view.showLoadFialed();
    }
}
