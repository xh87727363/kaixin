package kaixin.com.qingdan.utils.http;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2016/10/20.
 */

public class QinDanappliction extends Application {
    private static QinDanappliction instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);

    }
}
