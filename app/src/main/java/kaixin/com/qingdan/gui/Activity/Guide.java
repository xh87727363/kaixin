package kaixin.com.qingdan.gui.Activity;

import android.content.Intent;
import android.os.Bundle;

import kaixin.com.qingdan.R;

/**
 * Created by Administrator on 2016/10/17.
 */

public class Guide extends ActivityBase {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(Guide.this,MainActivity.class));
                finish();
            }
        }.start();

    }
    @Override
    protected void initViews() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_guide;
    }
}
