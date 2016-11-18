package kaixin.com.qingdan.gui.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kaixin.com.qingdan.R;
import kaixin.com.qingdan.gui.adapter.MainFragmentAdapter;
import kaixin.com.qingdan.gui.fragment.CategoryFragment;
import kaixin.com.qingdan.gui.fragment.MainFragment;
import kaixin.com.qingdan.gui.fragment.MineFragment;

public class MainActivity extends ActivityBase implements View.OnClickListener{
    private ViewPager mviewPager;
    //底部控件
    private int [] mTabsId;
    //是否退出
    private boolean isExit;
    //
    private CheckedTextView [] mTabs;
    private MainFragmentAdapter mainFragmentAdapter;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mTabs[0].isChecked()){
            if (fragments.get(0) instanceof MainFragment){
                MainFragment fragment = (MainFragment) fragments.get(0);
                if (fragment.isShowDailyTapWinds){
                    fragment.hidDailyTap();
                    return false;
                }
            }
        }
        if (keyCode == KeyEvent.KEYCODE_BACK){
            isExit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void isExit() {
        if (!isExit){
            isExit = true;
            Toast.makeText(this, "在按一次退出", Toast.LENGTH_SHORT).show();
            handler.sendEmptyMessageDelayed(0,2000);
        }else {
            finish();
            System.exit(0);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initViews() {
        mviewPager = findViewByIdNoCast(R.id.viewPager_main);
        mTabsId = new int[]{R.id.CheckTextView_list_home,R.id.CheckTextView_list_categry,R.id.CheckTextView_list_mine};
        mTabs = new CheckedTextView [mTabsId.length];
        for (int i = 0; i < mTabsId.length; i++) {
            mTabs[i] =findViewByIdNoCast(mTabsId[i]);
            mTabs[i].setOnClickListener(this);
        }
        mviewPager.setOffscreenPageLimit(2);
        mainFragmentAdapter = new MainFragmentAdapter(getFragments(),getSupportFragmentManager());
        mviewPager.setAdapter(mainFragmentAdapter);
        mviewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                showPager(position);
            }
        });
        showPager(0);

    }
    private List<Fragment> fragments;
    private List<Fragment> getFragments() {
        fragments =  new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new MineFragment());
        return fragments;
    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i <mTabs.length ; i++) {
            if(mTabs[i]==v){
                showPager(i);
                return;
            }
        }
    }

    private void showPager(int index) {
        if(mTabs[index].isChecked()){
            return;
        }
        for (int i = 0; i < mTabs.length; i++) {
            if (i == index){
                mTabs[i].setChecked(true);
            }else{
                mTabs[i] .setChecked(false);
            }
        }
        mviewPager.setCurrentItem(index);
    }

}
