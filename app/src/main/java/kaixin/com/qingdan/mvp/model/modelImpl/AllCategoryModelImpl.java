package kaixin.com.qingdan.mvp.model.modelImpl;

import com.alibaba.fastjson.JSON;

import kaixin.com.qingdan.entity.ResponseAllCategory;
import kaixin.com.qingdan.mvp.model.AllCategoryModel;
import kaixin.com.qingdan.utils.Apis;
import kaixin.com.qingdan.utils.http.HttpUtil;
import kaixin.com.qingdan.utils.http.Request;
import kaixin.com.qingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class AllCategoryModelImpl implements AllCategoryModel {
    @Override
    public void loadData(final Callback callback) {
        Request.Builder builder = new Request.Builder()
                .url(Apis.URL_ALLCATEGORY).get();
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseAllCategory allCategory = JSON.parseObject(response, ResponseAllCategory.class);
                if (allCategory.getCode()==0){
                    callback.loadDataSuccess(allCategory);
                }else {
                    callback.loadDataFailed();
                }
            }

            @Override
            public void onError() {
                callback.loadDataFailed();
            }
        });
    }
}
