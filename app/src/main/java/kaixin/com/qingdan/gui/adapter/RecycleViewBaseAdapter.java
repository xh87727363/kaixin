package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;

/**
 * Created by Administrator on 2016/10/25.
 */

public abstract class RecycleViewBaseAdapter <T>extends BaseRecycleViewAdapter<T>{


    public RecycleViewBaseAdapter(Context context) {
        super(context);
    }
    public static final int STATE_LOADING = 1;
    public static final int STATE_FAILED = 2;
    public static final int STATE_NO_MORE_DATA = 3;
    private int state;



    public void updateFootViewState(int state){
        this.state = state;
        notifyDataSetChanged();
    }


    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder,int position){
        MyFooterViewHolder footerHolder = (MyFooterViewHolder) holder;
        switch (state){
            case STATE_LOADING:
                footerHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                footerHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                break;
            case STATE_NO_MORE_DATA:
                footerHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                footerHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                footerHolder.textviewSubviewRecycleviewLoadfooter.setText("没有更多数据了哦~");
                break;
            case STATE_FAILED:
                footerHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                footerHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                footerHolder.textviewSubviewRecycleviewLoadfooter.setText("加载失败，点击重试~");
                break;
        }

    }





    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView_front_top_image)
        SimpleDraweeView imageViewFrontTopImage;
        @BindView(R.id.textView_front_main_title)
        TextView textViewFrontMainTitle;
        @BindView(R.id.textView_front_subitile)
        TextView textViewFrontSubitile;
        @BindView(R.id.textView_front_num_liked)
        TextView textViewFrontNumLiked;
        @BindView(R.id.textView_num_reviews)
        TextView textViewNumReviews;
        @BindView(R.id.rotate_textView_date)
        TextView rotateTextViewDate;
        LinearLayout linearLayout;


        MyViewHolder(View view) {
            super(view);
            linearLayout = (LinearLayout) view.findViewById(R.id.linear_bottom_count);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int postion = getAdapterPosition();
                    if (onItemClickListener != null){
                        onItemClickListener.onItemClick(v,postion);
                    }
                }
            });
        }
    }
     class MyFooterViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.progressbar_subview_recycleview_loadfooter)
        ProgressBar progressbarSubviewRecycleviewLoadfooter;
        @BindView(R.id.textview_subview_recycleview_loadfooter)
        TextView textviewSubviewRecycleviewLoadfooter;
        @BindView(R.id.layout_subview_recycleview_loadfooter)
        RelativeLayout layoutSubviewRecycleviewLoadfooter;

        MyFooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            textviewSubviewRecycleviewLoadfooter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.onReTryClick();
                    }
                }
            });
        }
    }
    public interface  OnReTryClickListener{
        void onReTryClick();
    }
    private OnReTryClickListener listener;
    public void setOnReTryClickListener(OnReTryClickListener listener){
        this.listener = listener;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int postion);
    }
    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
