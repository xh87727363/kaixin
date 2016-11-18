package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseMouth_Things;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class MouthThingsAdapter extends RecycleViewBaseAdapter<ResponseMouth_Things.DataBean.ThingsBean> {
    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;
    public MouthThingsAdapter(Context context) {
        super(context);
    }

    @Override
    public int getFooterCount() {
        return 1;
    }

    @Override
    public int getHeaderCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==getItemCount()-1){
            return TYPE_FOOTER;
        }
        return TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER){
            View view = inflater.inflate(R.layout.subview_recycleview_loadfooter,parent,false);
            return  new MyFooterViewHolder(view);
        }
        View view = inflater.inflate(R.layout.mouth_details_item, parent, false);
        return new MouthingsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position>=getItemCount() -getFooterCount()){
            onBindFooterViewHolder(holder,position);
            return;
        }
        MouthingsItemViewHolder holder1 = (MouthingsItemViewHolder) holder;
        ResponseMouth_Things.DataBean.ThingsBean bean = getItem(position);
        holder1.imageMouthPic.setImageURI(bean.getFeaturedImageUrl());
        holder1.textviewMouthTop.setText(bean.getFullName().replace(bean.getName(),""));
        holder1.textviewMouthMiddle.setText(bean.getName());
        holder1.textviewMouthBottuo.setText(getContext().getString(R.string.scre_reic,bean.getRatingScore()+"",bean.getReviewCount()));
        holder1.ratingbarMouth.setRating(bean.getRatingScore());


    }

    static class MouthingsItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image_mouth_pic)
        SimpleDraweeView imageMouthPic;
        @BindView(R.id.textview_mouth_top)
        TextView textviewMouthTop;
        @BindView(R.id.textview_mouth_middle)
        TextView textviewMouthMiddle;
        @BindView(R.id.ratingbar_mouth)
        RatingBar ratingbarMouth;
        @BindView(R.id.textview_mouth_right)
        TextView textviewMouthRight;
        @BindView(R.id.textview_mouth_bottuo)
        TextView textviewMouthBottuo;

        MouthingsItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
