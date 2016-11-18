package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseMainListData;

/**
 * Created by Administrator on 2016/10/24.
 */

public class CollectionsRecycleViewAdapter extends RecycleViewBaseAdapter<ResponseMainListData.DataBean.CollectionsBean> {

    public CollectionsRecycleViewAdapter(Context context) {
        super(context);
    }
    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;
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
        if (position == getItemCount()-1) return TYPE_FOOTER;
        return TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            return new MyViewHolder(inflater.inflate(R.layout.main_list_item, parent, false));
        }
        return new MyFooterViewHolder(inflater.inflate(R.layout.subview_recycleview_loadfooter, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position<getHeaderCount()){
            //TODO
            return;
        }
        if (position >=getItemCount()-getFooterCount()){
            //TODO
            onBindFooterViewHolder(holder,position);
            return;
        }
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        ResponseMainListData.DataBean.CollectionsBean nodesBean = getItem(position);
        myViewHolder.imageViewFrontTopImage.setImageURI(nodesBean.getFeaturedImageUrl());
        myViewHolder.textViewFrontMainTitle.setText(nodesBean.getTitle());
        myViewHolder.textViewFrontSubitile.setText(nodesBean.getSubtitle());
        myViewHolder.textViewFrontNumLiked.setText(nodesBean.getLikeCount()+"");
        myViewHolder.linearLayout.setVisibility(View.INVISIBLE);
    }





}
