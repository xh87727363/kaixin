package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import kaixin.com.qingdan.entity.ResponseBatching;
import kaixin.com.qingdan.entity.ResponseDailyTips;
import kaixin.com.qingdan.mvp.model.MainModel;
import kaixin.com.qingdan.mvp.model.modelImpl.MainModelImpl;
import kaixin.com.qingdan.mvp.presenter.MainPresenter;
import kaixin.com.qingdan.mvp.view.MainView;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainModel mainModel;
    private MainView mainView;
    public MainPresenterImpl(MainView mainView) {
        this.mainModel = new MainModelImpl();
        this.mainView = mainView;

    }

    @Override
    public void loadBatching() {
        mainModel.loadBatching(new MainModel.onBatchingLoadCallback() {
            @Override
            public void onBatchingLoadSuccess(ResponseBatching batching) {
                mainView.loadBatchingSuccess(batching);
            }

            @Override
            public void onBatchingFialed() {
                mainView.loadBatchingFialed();
            }
        });
    }

    @Override
    public void loadDailyTap() {
        mainModel.loadDailyTaps(new MainModel.onDailyTapCallback() {
            @Override
            public void loadDailyTapsSuccess(ResponseDailyTips dailyTips) {
                mainView.showDailyTips(dailyTips);
            }

            @Override
            public void loadDailyTapsFailed() {
                mainView.laodDailyTipsFailed();
            }
        });
    }
}
