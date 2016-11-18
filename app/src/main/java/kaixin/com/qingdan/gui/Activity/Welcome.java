package kaixin.com.qingdan.gui.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import kaixin.com.qingdan.R;
import kaixin.com.qingdan.utils.AppVerison;

/**
 * Created by Administrator on 2016/10/14.
 */

public class Welcome extends ActivityBase{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setFullScreen();
        super.onCreate(savedInstanceState);
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isExitByUser){
                    return;
                }
                if (isVersionFirst()){
                    gotoGuide();
                }else{
                    gotoMain();
                }


            }
        }.start();
    }

    private boolean isExitByUser;

    //判断当前是不是第一次进入
    private boolean isVersionFirst() {
        //创建一个sharePreference文件存储版本号
        SharedPreferences sp = getSharedPreferences("app_version",MODE_PRIVATE);//文件名 读取类型
        String version = sp.getString("version",null);//从文件中获取数据，若没有就得到空
        //获取当前版本号
        String versionName = AppVerison.getAppVersionName(this);
        if(versionName.equals(version)){
            return false;
        }
//        sp.edit().putString("app_version",versionName).commit();//往文件中添加数据要editor，
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("version",versionName);
        editor.commit();
        return true;
    }

    private void gotoMain() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    private void gotoGuide() {
        startActivity(new Intent(this,Guide.class));
        finish();
    }

    @Override
    protected void initViews() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_welcom;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isExitByUser = true;
    }
}
