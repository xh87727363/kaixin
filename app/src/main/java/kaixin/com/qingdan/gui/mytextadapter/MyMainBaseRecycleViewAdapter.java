package kaixin.com.qingdan.gui.mytextadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;

/**
 * Created by Administrator on 2016/10/26.
 */

public abstract class MyMainBaseRecycleViewAdapter<T> extends MyBaseRecycleViewAdapter<T> {
    public MyMainBaseRecycleViewAdapter(Context context) {
        super(context);
    }

    public final int STATE_LOADING = 1;
    public final int STATE_FAILED = 2;
    public final int STATE_NO_MORE_DATAS = 3;
    private int state;

    public void updataFooterViewState(int state) {
        this.state = state;
        notifyDataSetChanged();
    }
    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder, int position){
        MyFooterViewHolder footerHolder = (MyFooterViewHolder) holder;
        switch (state){
            case STATE_LOADING:
                footerHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                footerHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                break;
            case STATE_NO_MORE_DATAS:
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

    static class MyBaseViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView_front_top_image)
        SimpleDraweeView imageViewFrontTopImage;
        @BindView(R.id.view_temp)
        View viewTemp;
        @BindView(R.id.textView_front_main_title)
        TextView textViewFrontMainTitle;
        @BindView(R.id.textView_front_subitile)
        TextView textViewFrontSubitile;
        @BindView(R.id.imageView_front_like)
        ImageView imageViewFrontLike;
        @BindView(R.id.textView_front_num_liked)
        TextView textViewFrontNumLiked;
        @BindView(R.id.textView_num_reviews)
        TextView textViewNumReviews;
        @BindView(R.id.linear_bottom_count)
        LinearLayout linearBottomCount;
        @BindView(R.id.linear_temp)
        LinearLayout linearTemp;
        @BindView(R.id.rotate_textView_date)
        TextView rotateTextViewDate;
        @BindView(R.id.rela_temp)
        RelativeLayout relaTemp;
        @BindView(R.id.rela_special_tag)
        TextView relaSpecialTag;

        MyBaseViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class MyFooterViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.progressbar_subview_recycleview_loadfooter)
        ProgressBar progressbarSubviewRecycleviewLoadfooter;
        @BindView(R.id.textview_subview_recycleview_loadfooter)
        TextView textviewSubviewRecycleviewLoadfooter;
        @BindView(R.id.layout_subview_recycleview_loadfooter)
        RelativeLayout layoutSubviewRecycleviewLoadfooter;

        MyFooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
