package kaixin.com.qingdan.gui.fragment;


import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseBatching;
import kaixin.com.qingdan.entity.ResponseDailyTips;
import kaixin.com.qingdan.gui.adapter.MainSlidePagerAdapter;
import kaixin.com.qingdan.gui.adapter.MainTabLayoutAdapter;
import kaixin.com.qingdan.gui.widget.IndicatorContainer;
import kaixin.com.qingdan.mvp.presenter.MainPresenter;
import kaixin.com.qingdan.mvp.presenter.presenterImpl.MainPresenterImpl;
import kaixin.com.qingdan.mvp.view.MainView;
import kaixin.com.qingdan.utils.RefreshLayout;

/**
 * Created by Administrator on 2016/10/17.
 */

public class MainFragment extends FragmentBase implements MainView {
    @BindView(R.id.refresh_main_fragment)
    RefreshLayout refreshMainFragment;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    private ViewPager mainSlideViewPager;
    private MainSlidePagerAdapter mainSlidePagerAdapter;
    private LinearLayout mainIndicatorContainer;
    private IndicatorContainer mIndicatorContainer;
    // 底部viewPager
    private ViewPager mainFragmentViewpager;
    private TabLayout tabLayout;
    private MainTabLayoutAdapter mainTabLayoutAdapter;
    private MainPresenter mainPresenter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainSlideViewPager = (ViewPager) getView().findViewById(R.id.viewPager_main_list_slide);
        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.loadBatching();
        mainIndicatorContainer = (LinearLayout) getView().findViewById(R.id.linearLayout_pager_indicator);
        mIndicatorContainer = new IndicatorContainer(getActivity(), mainIndicatorContainer, mainSlideViewPager);
        mIndicatorContainer.setDorRes(R.drawable.pic, R.drawable.pig);
        refreshMainFragment.setOnRefreshListener(new RefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.loadBatching();
            }
        });
        //底部viewPager
        mainFragmentViewpager = (ViewPager) getView().findViewById(R.id.viewPager_main_fragmnet);
        tabLayout = (TabLayout) getView().findViewById(R.id.tabLayout_main);
        tabLayout.setupWithViewPager(mainFragmentViewpager);
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i == 0) {
                    //TODO
                    refreshMainFragment.setAppbar(true);
                } else {
                    refreshMainFragment.setAppbar(false);
                }
            }
        });
    }

    @Override
    public void loadBatchingSuccess(ResponseBatching batching) {
        refreshMainFragment.refreshFinish();
        Toast.makeText(getActivity(), "batching:" + batching, Toast.LENGTH_SHORT).show();
        mainSlidePagerAdapter = new MainSlidePagerAdapter(getActivity(), batching.getData().getSlides().getBody().getData().getSlides());
        //设置adapter
        mainSlideViewPager.setAdapter(mainSlidePagerAdapter);
        int size = batching.getData().getSlides().getBody().getData().getSlides().size();
        mIndicatorContainer.setDotNum(size);
        // 设置下面的viewPager
        mainTabLayoutAdapter = new MainTabLayoutAdapter(batching.getData().getChannels().getBody().getData().getChannels(), getChildFragmentManager());
        mainFragmentViewpager.setAdapter(mainTabLayoutAdapter);

    }

    @Override
    public void loadBatchingFialed() {
        refreshMainFragment.refreshFinish();
        Toast.makeText(getActivity(), "加载失败", Toast.LENGTH_SHORT).show();
    }

    private WindowManager windowManager;
    private View dailyTipsView;
    private WindowManager.LayoutParams windoLayoutParams;
    private DailyTipsViewHolder dailyTipsViewHolder;
    public boolean isShowDailyTapWinds;

    @Override
    public void showDailyTips(ResponseDailyTips dailyTips) {
        Toast.makeText(getContext(), "chenggogn", Toast.LENGTH_SHORT).show();
        if (windowManager == null) {
            windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
            dailyTipsView = LayoutInflater.from(getActivity()).inflate(R.layout.subview_daily_tips, null);
            dailyTipsViewHolder = new DailyTipsViewHolder(dailyTipsView);
            //创建窗口的布局参数 使用带参构造将异常new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT)
            windoLayoutParams = new WindowManager.LayoutParams();
            windoLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;//全屏
            windoLayoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;//quanp
            windoLayoutParams.format = PixelFormat.RGBA_8888;//设置背景透明
            //给Windows设置flag 状态栏透明 可以接受返回键
            windoLayoutParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            //监听View和window的关联和取消
            dailyTipsView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    isShowDailyTapWinds = true;
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    isShowDailyTapWinds = false;
                }
            });
        }
        windowManager.addView(dailyTipsView, windoLayoutParams);//添加View
        dailyTipsViewHolder.imgDailyTips.setImageURI(dailyTips.getData().getImageUrl());
    }

    @Override
    public void laodDailyTipsFailed() {
        Toast.makeText(getContext(), "shibai", Toast.LENGTH_SHORT).show();
    }

    public void hidDailyTap() {
        if (isShowDailyTapWinds) {
            windowManager.removeView(dailyTipsView);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }



    @OnClick({R.id.img_title_left, R.id.img_title_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_title_left:
                mainPresenter.loadDailyTap();
                Toast.makeText(getContext(), "开始下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_title_right:
                break;
        }
    }

     class DailyTipsViewHolder {
        @BindView(R.id.img_daily_tips)
        SimpleDraweeView imgDailyTips;
        @BindView(R.id.img_btn_moments)
        ImageView imgBtnMoments;
        @BindView(R.id.img_btn_download)
        ImageView imgBtnDownload;
        @BindView(R.id.img_btn_off)
        ImageView imgBtnOff;
        @BindView(R.id.root_daily_tips)
        RelativeLayout rootDailyTips;

        DailyTipsViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
        @OnClick({R.id.img_daily_tips, R.id.img_btn_moments, R.id.img_btn_download, R.id.img_btn_off, R.id.root_daily_tips})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.img_daily_tips:
                    Toast.makeText(getActivity(), "微信", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.img_btn_moments:
                    Toast.makeText(getContext(), "朋友圈", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.img_btn_download:
                    Toast.makeText(getContext(), "下载", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.img_btn_off:
                    hidDailyTap();
                    break;
                case R.id.root_daily_tips:
                    break;
            }
        }
    }
}
