package kaixin.com.qingdan.mvp.model.modelImpl;


import android.util.Log;

import com.alibaba.fastjson.JSON;

import kaixin.com.qingdan.entity.ResponseMouth_Things;
import kaixin.com.qingdan.mvp.model.MouthThingsModel;
import kaixin.com.qingdan.utils.http.HttpUtil;
import kaixin.com.qingdan.utils.http.Request;
import kaixin.com.qingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class MouthThingsModelImpl implements MouthThingsModel {
    @Override
    public void loadData(String url, final MouthRankingCallback callback) {
        Request.Builder builder = new Request.Builder()
                .url(url).get();
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseMouth_Things responseMouth_things = JSON.parseObject(response, ResponseMouth_Things.class);
                Log.d("MouthThingsModelImpl", "responseMouth_things:" + responseMouth_things);
                Log.d("MouthThingsModelImpl", "responseMouth_things.getData().getMeta():" + responseMouth_things.getData());
                Log.d("MouthThingsModelImpl", "responseMouth_things.getCode():" + responseMouth_things.getCode());
                Log.d("MouthThingsModelImpl", " -------"+responseMouth_things.getMessage());
                if (responseMouth_things.getData().getMeta().getPagination().getTotal_pages() == 0){
                    callback.noSearchData();
                    return;
                }
                if (responseMouth_things.getCode()==0 && responseMouth_things.getData().getThings()!=null && responseMouth_things.getData().getThings().size()>0){
                    callback.loadSuccess(responseMouth_things.getData().getThings());
                    if (responseMouth_things.getData().getMeta().getPagination().getTotal_pages() ==
                            responseMouth_things.getData().getMeta().getPagination().getCurrent_page()){
                        callback.noMoreData();
                    }
                }else{
                    onError();
                }
            }

            @Override
            public void onError() {
                callback.loadFailed();
            }
        });
    }
}
