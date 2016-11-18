package kaixin.com.qingdan.utils;

/**
 * Created by Administrator on 2016/10/24.
 */

public class UrlHandler {
    public static final String handlerUrl(String url,Object...params){
        for (int i = 0; i < params.length; i++) {
            url = url.replace("{"+i+"}",params[i]+"");
        }
        return  url;
    }
}
