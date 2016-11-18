package kaixin.com.qingdan.mvp.presenter.presenterImpl;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import kaixin.com.qingdan.entity.ResponseMouth_Things;
import kaixin.com.qingdan.mvp.model.MouthThingsModel;
import kaixin.com.qingdan.mvp.model.modelImpl.MouthThingsModelImpl;
import kaixin.com.qingdan.mvp.presenter.MouthThingsPreserenter;
import kaixin.com.qingdan.mvp.view.MouthThingsView;
import kaixin.com.qingdan.utils.Apis;
import kaixin.com.qingdan.utils.UrlHandler;
import kaixin.com.qingdan.utils.http.Contants;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class MouthThingsPresenterImpl implements MouthThingsPreserenter, MouthThingsModel.MouthRankingCallback {
    private MouthThingsModel mouthThingsModel;
    private MouthThingsView view;
    private int sortTag;
    private int nextPage = 1;
    private int ranking_id;

    public MouthThingsPresenterImpl(MouthThingsView view, int sortTag, int ranking_id) {
        this.view = view;
        this.sortTag = sortTag;
        this.ranking_id = ranking_id;
        mouthThingsModel = new MouthThingsModelImpl();
    }

    @Override
    public void loadNextData(String key) {
        if (!TextUtils.isEmpty(key)) {
            try {
                key = URLEncoder.encode(key, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            key = "";
        }
        String url = "";
        switch (sortTag) {
            case Contants.SORT_BY_REVIEW_COUNT:
                url = UrlHandler.handlerUrl(Apis.API_REPUTATION_THING_SORT_BY_REVIEW_COUNT, ranking_id, key, nextPage);
                break;
            case Contants.SORT_BY_rating_score:
                url = UrlHandler.handlerUrl(Apis.API_REPUTATION_THING_SORT_BY_rating_score, ranking_id, key, nextPage);
                break;
            case Contants.SORT_BY_BRAND_NAME:
                url = UrlHandler.handlerUrl(Apis.API_REPUTATION_THING_SORT_BY_BRAND_NAME, ranking_id, key, nextPage);
                break;
        }
        mouthThingsModel.loadData(url, this);
        view.showFooterLoading();
    }

    @Override
    public void loadRefreshData(String key) {
        nextPage = 1;
        loadNextData(key);
    }

    @Override
    public void loadSuccess(List<ResponseMouth_Things.DataBean.ThingsBean> things) {
        view.showThings(nextPage, things);
        nextPage++;
    }

    @Override
    public void loadFailed() {
        view.showFooterLoadFailed();
    }

    @Override
    public void noMoreData() {
        view.showFooterNoMoreData();
    }

    @Override
    public void noSearchData() {
        view.showFooterNoSearchData();
    }
}
