package kaixin.com.qingdan.utils.http.qingdan;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import kaixin.com.qingdan.utils.http.HttpUtil;
import kaixin.com.qingdan.utils.http.Request;
import kaixin.com.qingdan.utils.http.RequestBody;
import kaixin.com.qingdan.utils.http.StringBody;

/**
 * Created by Administrator on 2016/10/19.
 */

public class HttpClient {
    private static String authorization;
    private static long validTime;
    public static void excute(final Request.Builder request, final HttpUtil.CallBack callBack){
        if (!checkAuthorization()){
            Log.d("HttpClient", "token为空，去申请token吧");
            String json = "{\"client_id\":\"herEv4O9tg4PuviM\",\"client_secret\":\"v20ulmkZP5ykQMn9uUwNbyEiuTkzFfPn\",\"grant_type\":\"client_credentials\"}";
            RequestBody body = new StringBody(RequestBody.jsonContentType,json);
            Request requestToken = new Request.Builder()
                    .url("http://api.eqingdan.com/v1/oauth2/access-token")
                    .post(body)
                    .build();
            HttpUtil.getInstance().execute(requestToken,new HttpUtil.CallBack(){

                @Override
                public void onResponse(String response) {
                    Log.d("HttpClient",response);
                    AuthoriaztionObj authoriaztionObj = JSON.parseObject(response,AuthoriaztionObj.class);
                    AuthoriaztionObj.DataBean data =authoriaztionObj.getData();
                    authorization = data.getToken_type()+" "+data.getAccess_token();
                    validTime = System.currentTimeMillis()+data.getExpires_in()*1000;
                    request.addHeader("authorization",authorization);
                    HttpUtil.getInstance().execute(request.build(),callBack);
                }

                @Override
                public void onError() {

                }
            });

        }else {
            Log.d("HttpClient","Token为:"+authorization);
            request.addHeader("authorization",authorization);
            HttpUtil.getInstance().execute(request.build(),callBack);
        }
    }

    private static boolean checkAuthorization() {
        if (TextUtils.isEmpty(authorization)|| isTokenTnvalid()){
            return  false;
        }
        return  true;
    }
    // 判断authorization是否已失效
    private static boolean isTokenTnvalid() {
        return System.currentTimeMillis()> validTime;
    }
}
