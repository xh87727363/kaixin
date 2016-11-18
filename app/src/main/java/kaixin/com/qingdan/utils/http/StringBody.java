package kaixin.com.qingdan.utils.http;

/**
 * Created by Administrator on 2016/10/17.
 */

public class StringBody extends RequestBody {
    private String body;
    public StringBody(String conteneType,String body) {
        super(conteneType);
        this.body = body;
    }

    @Override
    public byte[] getBodyByte() {
        return body.getBytes();
    }
}
