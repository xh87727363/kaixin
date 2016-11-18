package kaixin.com.qingdan.mvp.model;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public interface CategorySelectModel {
    void loadData(Callback callback);
    void loadNextData(Callback callback);
    public interface Callback{
        void loadSuccess();
        void loadFailed();
    }
}
