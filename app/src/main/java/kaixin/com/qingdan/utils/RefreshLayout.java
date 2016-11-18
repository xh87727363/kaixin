package kaixin.com.qingdan.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;

import kaixin.com.qingdan.R;

/**
 * Created by Administrator on 2016/11/4.
 */

public class RefreshLayout extends FrameLayout {
    public RefreshLayout(Context context) {
        super(context);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private View headerView;
    private View childView;
    private View image_refresh;
    private float headerHeight;

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        childView = getChildAt(0);
        headerView = LayoutInflater.from(getContext()).inflate(R.layout.refreshlayout,this,false);
        image_refresh = headerView.findViewById(R.id.image_refresh);
        addView(headerView);
        headerView.measure(0,0);
        headerHeight = headerView.getMeasuredHeight();
        ViewCompat.setTranslationY(headerView,-headerHeight);


    }
    private float touchY;
    private boolean appbar;
    public  void setAppbar(boolean appbar){
        this.appbar = appbar;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isRefreshing) return true;
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                touchY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float offsetY = ev.getY() - touchY;
                if (offsetY > 0 && !canSrcollToDown() && appbar){
                    touchY = ev.getY();
                    return  true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    private boolean canSrcollToDown() {
        return ViewCompat.canScrollVertically(childView,-1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isRefreshing) return false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                float instanceY = event.getY() -touchY;
                if (instanceY <= 0){
                    instanceY = 0;
                }
                ViewCompat.setTranslationY(headerView,-headerHeight+instanceY);
                ViewCompat.setTranslationY(childView,instanceY);
                ViewCompat.setRotation(image_refresh,instanceY*360/headerHeight);
                break;
            case MotionEvent.ACTION_UP:
                instanceY = event.getY() - touchY;
                instanceY = instanceY/5;
                if (instanceY < headerHeight){
//                    ViewCompat.setTranslationY(headerView,-headerHeight);
//                    ViewCompat.setTranslationY(childView,0);
                    smoothScroll(ViewCompat.getTranslationY(headerView),-headerHeight);
                }else {
//                    ViewCompat.setTranslationY(headerView,0);
//                    ViewCompat.setTranslationY(childView,headerHeight);
                    smoothScroll(ViewCompat.getTranslationY(headerView),0);
                    isRefreshing = true;
                }

                break;
        }
        return true;
    }
    private ValueAnimator animator;
    public  void smoothScroll(float startY,float endY){
        if (animator == null){
            animator = ValueAnimator.ofFloat(startY,endY);
            animator.setDuration(200);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float headerY = (float) animation.getAnimatedValue();
                    ViewCompat.setTranslationY(headerView,headerY);
                    ViewCompat.setTranslationY(childView,headerHeight+headerY);

                    if (headerY == 0 && isRefreshing){
                        RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                        rotateAnimation.setDuration(1000);
                        rotateAnimation.setRepeatCount(-1);
                        rotateAnimation.setInterpolator(new LinearInterpolator());
                        image_refresh.startAnimation(rotateAnimation);
                        if (listener!=null){
                            listener.onRefresh();
                        }
                    }
                }
            });
        }else {
            animator.setFloatValues(startY,endY);
        }
        animator.start();
    }
    private boolean isRefreshing;
    public interface OnRefreshListener{
        void onRefresh();
    }
    private OnRefreshListener listener;
    public void setOnRefreshListener(OnRefreshListener listener){
        this.listener = listener;
    }


    public void refreshFinish(){
        isRefreshing = false; //将状态设置为 不在刷新状态
        smoothScroll(ViewCompat.getTranslationY(headerView),-headerHeight); //让头部弹回去
        image_refresh.clearAnimation();//清除动画
    }
}
