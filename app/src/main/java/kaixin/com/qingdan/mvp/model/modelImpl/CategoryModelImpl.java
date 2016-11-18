package kaixin.com.qingdan.mvp.model.modelImpl;

import com.alibaba.fastjson.JSON;

import kaixin.com.qingdan.entity.ResponseCategory;
import kaixin.com.qingdan.mvp.model.CategoryModel;
import kaixin.com.qingdan.utils.http.FormBody;
import kaixin.com.qingdan.utils.http.HttpUtil;
import kaixin.com.qingdan.utils.http.Request;
import kaixin.com.qingdan.utils.http.RequestBody;
import kaixin.com.qingdan.utils.http.qingdan.HttpClient;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class CategoryModelImpl implements CategoryModel{
    @Override
    public void loadData(String url, final CategoryCallbcak Callbcak) {
        String category_body = "{\"tags\":{\"method\":\"GET\",\"relative_url\":\"/v1/tags/recommended\"},\"categories\":{\"method\":\"GET\",\"relative_url\":\"/v1/categories\"}}";

        RequestBody body = new FormBody.Builder()
                .add("requests",category_body).build();
        Request.Builder builder = new Request.Builder()
                .url(url).post(body);
        HttpClient.excute(builder, new HttpUtil.CallBack() {
            @Override
            public void onResponse(String response) {
                ResponseCategory category = JSON.parseObject(response, ResponseCategory.class);
                if (category.getCode() == 0){
                    Callbcak.loadCategorySuccess(category.getData());
                }else {
                    Callbcak.loadFialed();
                }
            }

            @Override
            public void onError() {
                Callbcak.loadFialed();
            }
        });

    }
}
