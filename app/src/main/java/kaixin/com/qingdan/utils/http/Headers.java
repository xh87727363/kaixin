package kaixin.com.qingdan.utils.http;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/17.
 */

public class Headers {
    private List<String> nameAndValues;
    private Headers(Builder buidler){
        this.nameAndValues =buidler.nameAndValues;
    }

    public List<String> getNameAndValues() {
        return nameAndValues;
    }
    public static class Builder{
        private List<String> nameAndValues;

        public Builder() {
            nameAndValues = new ArrayList<>();
        }
        public Builder addHeader(String name, String value){
            nameAndValues.add(name);
            nameAndValues.add(value);
            return this;
        }
        public Builder addHeaders(Headers headers){
            nameAndValues.addAll(headers.nameAndValues);
            return this;
        }
        public Headers build(){
            return new Headers(this);
        }
    }
}
