package kaixin.com.qingdan.gui.Activity;

import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/10/14.
 */

public abstract  class ActivityBase extends FragmentActivity{
  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //为Activity设置视图
        setContentView(getContentViewResId());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //初始化控件
        initViews();

    }
    protected abstract void initViews();

    public abstract int getContentViewResId();

    public <T extends View>T findViewByIdNoCast(int id){
        return (T) super.findViewById(id);
    }
    /**
     * 转换像素
     */
    public  int dip2px(float dpValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
    public  boolean isNetWork(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        return  connectivityManager.getActiveNetworkInfo() !=null
                && connectivityManager !=null
                && connectivityManager.getActiveNetworkInfo().isAvailable();
    }
    /**
     * 获取状态栏高度
     */
    public  int getStatusHeight(){
        final Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int n = rect.top;
        if (n != 0){
            return  n;
        }
        try {
            final  Class<?> forName = Class.forName("com.android.internal.R$dimen");
            n = getResources().getDimensionPixelSize(Integer.parseInt(forName
            .getField("status_bar_height").get(forName.newInstance()).toString()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return  n;
    }
    protected  void setFullScreen(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
