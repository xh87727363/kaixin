package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import java.util.List;

import kaixin.com.qingdan.entity.ResponseMouthList;
import kaixin.com.qingdan.mvp.model.MouthListModel;
import kaixin.com.qingdan.mvp.model.modelImpl.MouthListModelImpl;
import kaixin.com.qingdan.mvp.presenter.MouthListPresenter;
import kaixin.com.qingdan.mvp.view.MouthListView;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class MouthListPresenterImpl implements MouthListPresenter{
    private MouthListModel mouthListModel;
    private MouthListView view;

    public MouthListPresenterImpl(MouthListView view) {
        this.view = view;
        mouthListModel = new MouthListModelImpl();
    }

    @Override
    public void loadNextPage() {
        mouthListModel.loadNextPageDatas(new MouthListModel.MouthListCallback() {
            @Override
            public void loadNxetPageSuccess(List<ResponseMouthList.DataBean.RankingsBean> rankings) {
                view.showNextPageDatas(rankings);
            }

            @Override
            public void loadNxetPageFailed() {
                view.showNextPageFail();
            }

            @Override
            public void noMoreData() {
                view.showNoMoreData();
            }
        });
    }
}
