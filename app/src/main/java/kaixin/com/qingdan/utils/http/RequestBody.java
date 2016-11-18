package kaixin.com.qingdan.utils.http;

/**
 * Created by Administrator on 2016/10/17.
 */

public abstract class RequestBody {
    public static final String formContentType = "application/x-www-form-urlencoded";
    public static final String jsonContentType = "application/json;Charset=utf-8";
    private String conteneType;

    public String getConteneType() {
        return conteneType;
    }

    public RequestBody(String conteneType) {
        this.conteneType = conteneType;
    }
    public abstract byte[] getBodyByte();
}
