package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseMainListData;
import kaixin.com.qingdan.entity.ResponseReputation;
import kaixin.com.qingdan.gui.Activity.MouthDestirsActivity;
import kaixin.com.qingdan.gui.Activity.Mouth_list_Activity;



/**
 * Created by Administrator on 2016/10/24.
 */

public class NodesRecycleViewAdapter extends RecycleViewBaseAdapter<ResponseMainListData.DataBean.NodesBean> {

    @BindView(R.id.img_ranking_all_topic_enter)
    ImageView imgRankingAllTopicEnter;
    private Context context;
    public NodesRecycleViewAdapter(Context context) {
        super(context);
        this.context = context;
        rankings = new ArrayList<>();
    }

    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_HEADER = 2;

    @Override
    public int getFooterCount() {
        return 1;
    }

    @Override
    public int getHeaderCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1)
            return TYPE_FOOTER;
        if (position == 0)
            return TYPE_HEADER;
        return TYPE_CONTENT;
    }

    private List<ResponseReputation.DataBean.RankingsBean> rankings;

    public void setRankings(List<ResponseReputation.DataBean.RankingsBean> rankings) {
        //TODO gaibian
        this.rankings = rankings;
//        this.rankings.clear();
//        this.rankings.addAll(rankings);
        Log.d("TAG", "111111111111111c" + this.rankings);
        notifyItemChanged(0);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            return new MyViewHolder(inflater.inflate(R.layout.main_list_item, parent, false));
        }
        if (viewType == TYPE_HEADER)
            return new MyHeaderViewHOlder(inflater.inflate(R.layout.layout_head_enter_rankings, parent, false));
        return new MyFooterViewHolder(inflater.inflate(R.layout.subview_recycleview_loadfooter, parent, false));
    }

    private List<SimpleDraweeView> simpleDraweeView;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position < getHeaderCount()) {
            //TODO
            Log.d("TAG", "111111111111111a" + rankings);
            MyHeaderViewHOlder headerHolder = (MyHeaderViewHOlder) holder;
            if (headerHolder.llItemRankingEnter.getChildCount() == 0) {
                Log.d("TAG", "111111111111111b" + this.rankings.size());
                simpleDraweeView = new ArrayList<>();
                for (final ResponseReputation.DataBean.RankingsBean ranking : rankings) {
                    Log.d("TAG", headerHolder.llItemRankingEnter.getChildAt(position) + "111111111111111");
                    View view = inflater.inflate(R.layout.subview_reputation, headerHolder.llItemRankingEnter, false);
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(), MouthDestirsActivity.class);
                            intent.putExtra(MouthDestirsActivity.RANKING_ID,ranking.getId());
                            getContext().startActivity(intent);
                        }
                    });
                    simpleDraweeView.add((SimpleDraweeView) view.findViewById(R.id.img_ranking_all_topic_enter));
                    headerHolder.llItemRankingEnter.addView(view);
                }
            }
            for (int i = 0; i < headerHolder.llItemRankingEnter.getChildCount(); i++) {
//                SimpleDraweeView view = (SimpleDraweeView)
//                        headerHolder.llItemRankingEnter.getChildAt(i).findViewById(R.id.img_ranking_all_topic_enter);
//                view.setImageURI(rankings.get(i).getThumbnailImageUrl());
                simpleDraweeView.get(i).setImageURI(rankings.get(i).getThumbnailImageUrl());
            }
            return;
        }
        if (position >= getItemCount() - getFooterCount()) {
            //TODO
            onBindFooterViewHolder(holder, position);
            return;
        }
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        ResponseMainListData.DataBean.NodesBean nodesBean = getItem(position);
        myViewHolder.imageViewFrontTopImage.setImageURI(nodesBean.getFeaturedImageUrl());
        myViewHolder.textViewFrontMainTitle.setText(nodesBean.getTitle());
        myViewHolder.textViewFrontSubitile.setText(nodesBean.getSubtitle());
        myViewHolder.textViewFrontNumLiked.setText(nodesBean.getLikeCount() + "");
        myViewHolder.textViewNumReviews.setText(nodesBean.getHitCount() + "");
    }

    class MyHeaderViewHOlder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_item_ranking_enter)
        LinearLayout llItemRankingEnter;
        @BindView(R.id.img_ranking_all_topic_enter)
        ImageView imgRankingAllTopicEnter;

        public MyHeaderViewHOlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            imgRankingAllTopicEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Mouth_list_Activity.class);
                    context.startActivity(intent);
                }
            });
        }
    }


}
