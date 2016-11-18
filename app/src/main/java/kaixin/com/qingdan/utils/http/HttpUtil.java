package kaixin.com.qingdan.utils.http;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/10/17.
 */

public class HttpUtil {
    //线程池
    private ExecutorService executor;
    private int maxThreadCount = 5;
    private int onnetctTimeout = 6000;
    private int readTimeout = 6000;
    private Handler handler = new Handler(Looper.getMainLooper()) {//Looper.getMainLooper()加上表示在子线程中也可以访问，默认不加在主线程中不报错。
        @Override
        public void handleMessage(Message msg) {
                ResponseCall responseCall = (ResponseCall) msg.obj;
            switch (msg.what){
                case 1:
                    Log.i(TAG, "handleMessage:1 "+responseCall);
                    Log.i(TAG, "handleMessage: 2"+responseCall.getCallBack());
                    responseCall.getCallBack().onResponse(responseCall.getResult());
                    break;
                case 2:
                    responseCall.getCallBack().onError();
                    break;
            }
        }
    };
    public HttpUtil(){
        executor = Executors.newFixedThreadPool(maxThreadCount);
    }
    private static HttpUtil instance;
    public static HttpUtil getInstance(){
        if ( instance == null){
            synchronized (HttpUtil.class){
                if (instance == null){
                    instance =new HttpUtil();
                }
            }
        }
        return  instance;
    }
    public void execute (Request request, CallBack callback) {
        HttpRunnbal runnbal = new HttpRunnbal(request,callback);
        executor.execute(runnbal);
    }
    public interface  CallBack{
        void onResponse(String response);
        void onError();
    }
    public static  class ResponseCall{
        private Object tag;
        private CallBack callBack;
        private String result;

        public Object getTag() {
            return tag;
        }

        public CallBack getCallBack() {
            return callBack;
        }

        public String getResult() {
            return result;
        }

        public ResponseCall(Object tag, CallBack callBack, String result) {
            this.tag = tag;
            this.callBack = callBack;
            this.result = result;
        }
    }
    private class HttpRunnbal implements  Runnable{
        private CallBack callBack;
        private Request request;

        public HttpRunnbal(Request request, CallBack callback) {
            this.callBack = callback;
            this.request = request;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(request.getUrl());
               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(onnetctTimeout);
                conn.setReadTimeout(readTimeout);
                conn.setRequestMethod(request.getMethod());
                //添加头部数据
                Headers headers = request.getHeaders();
                if (headers!=null){
                    List<String> headersDatas = headers.getNameAndValues();
                    for (int i = 0; i < headersDatas.size(); i+=2) {
                        conn.addRequestProperty(headersDatas.get(i),headersDatas.get(i+1));
                    }
                }
                if (request.getBody()!=null){
                    conn.setDoOutput(true);//允许向服务器写入数据
                    OutputStream outputStream = conn.getOutputStream();
                    outputStream.write(request.getBody().getBodyByte());
                }
                InputStream inputStream = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = br.readLine())!=null){
                    sb.append(line);
                }
                Log.d("HttpRunnbal", sb.toString());
                String result = sb.toString();
                if (callBack == null) return;
                ResponseCall responseCall = new ResponseCall(request.getUrl(),callBack,result);
                handler.sendMessage(handler.obtainMessage(1,responseCall));
                return;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (callBack == null) return;
            ResponseCall responseCall = new ResponseCall(request.getUrl(),callBack,null);
            handler.sendMessage(handler.obtainMessage(2,responseCall));
        }
    }

}
