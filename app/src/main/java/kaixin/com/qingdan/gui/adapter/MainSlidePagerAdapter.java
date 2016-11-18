package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseBatching;
import kaixin.com.qingdan.utils.IntentActivity;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MainSlidePagerAdapter extends PagerAdapter {
    private List<ResponseBatching.DataBean1.SlidesBean1.BodyBean.DataBean.SlidesBean> datas;
    private List<View> views;
    private Context context;

    public MainSlidePagerAdapter(Context context, final List<ResponseBatching.DataBean1.SlidesBean1.BodyBean.DataBean.SlidesBean> datas) {
        this.datas = datas;
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        views = new ArrayList<>();

        for ( int i = 0; i < datas.size(); i++) {
            View view = inflater.inflate(R.layout.subview_main_slide_page,null);
            views.add(view);

        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
       View view = views.get(position%views.size());
        SimpleDraweeView img = (SimpleDraweeView) view.findViewById(R.id.imgview_main_slide_page);
        img.setImageURI(datas.get(position%views.size()).getFeaturedImageUrl());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String target = datas.get(position%views.size()).getTarget();
                IntentActivity.IntentToActivity(Integer.valueOf(target),context);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = views.get(position%views.size());
        container.removeView(view);
    }

}
