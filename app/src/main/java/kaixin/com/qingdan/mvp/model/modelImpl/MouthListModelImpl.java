package kaixin.com.qingdan.mvp.model.modelImpl;

import com.alibaba.fastjson.JSON;

import kaixin.com.qingdan.entity.ResponseMouthList;
import kaixin.com.qingdan.mvp.model.MouthListModel;
import kaixin.com.qingdan.utils.Apis;
import kaixin.com.qingdan.utils.UrlHandler;
import kaixin.com.qingdan.utils.http.HttpUtil;
import kaixin.com.qingdan.utils.http.Request;
import kaixin.com.qingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class MouthListModelImpl implements MouthListModel {
    private int nextPage = 1;
    @Override
    public void loadNextPageDatas(final MouthListCallback callback) {
        String url = UrlHandler.handlerUrl(Apis.URL_MOUTH_LIST,nextPage);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseMouthList responseMouthList = JSON.parseObject(response, ResponseMouthList.class);
                if (responseMouthList.getData().getMeta().getPagination().getTotal_pages() == responseMouthList.getData().getMeta().getPagination().getCurrent_page()){
                    callback.noMoreData();
                }else{
                    callback.loadNxetPageSuccess(responseMouthList.getData().getRankings());
                    nextPage++;
                }
            }

            @Override
            public void onError() {
                callback.loadNxetPageFailed();
            }
        });
    }
}
