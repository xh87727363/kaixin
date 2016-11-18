package kaixin.com.qingdan.gui.mytextadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseMainListData;

/**
 * Created by Administrator on 2016/10/26.
 */

public class MyNodesRecycleViewAdapter extends  MyMainBaseRecycleViewAdapter<ResponseMainListData.DataBean.NodesBean> {
    public MyNodesRecycleViewAdapter(Context context) {
        super(context);
    }
    public final int TYPE_COUNTENT =0;
    public final int TYPE_FOOTER =1;


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
        if (position == getItemCount()-1){
            return TYPE_FOOTER;
        }
        return  TYPE_COUNTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER){
            return new MyFooterViewHolder(inflater.inflate(R.layout.subview_recycleview_loadfooter,parent,false));
        }
        return new MyBaseViewHolder(inflater.inflate(R.layout.main_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < getHeaderCount() ){
            return;
        }
        if (position >= getItemCount()-getFooterCount()){
            onBindFooterViewHolder(holder,position);
            return;
        }
        MyBaseViewHolder mholder1 = (MyBaseViewHolder) holder;
        ResponseMainListData.DataBean.NodesBean nodesBean=  getItemData(position);
        mholder1.imageViewFrontTopImage.setImageURI(nodesBean.getFeaturedImageUrl());
        mholder1.textViewFrontMainTitle.setText(nodesBean.getTitle());
        mholder1.textViewFrontSubitile.setText(nodesBean.getSubtitle());
        mholder1.textViewFrontNumLiked.setText(nodesBean.getLikeCount()+"");
        mholder1.textViewNumReviews.setText(nodesBean.getHitCount()+"");
    }
}
