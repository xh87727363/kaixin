package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseRelatedArticles;

/**
 * Created by Administrator on 2016/11/3.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResponseRelatedArticles.DataBean.ArticlesBean> articles;
    private LayoutInflater inflater;

    public MyRecycleAdapter(Context context, List<ResponseRelatedArticles.DataBean.ArticlesBean> articles) {
        this.articles = articles;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.article_recycle_viev_item, parent, false);
        return new MyRecycelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyRecycelViewHolder mholder = (MyRecycelViewHolder) holder;
        mholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onItemClick(v,articles.get(position).getId());
                }
            }
        });
        mholder.imageRecycleViewIag.setImageURI(articles.get(position).getFeaturedImageUrl()+"");
        mholder.textviewRelatedTag.setText(articles.get(position).getTitle()+"");
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class MyRecycelViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image_recycle_view_iag)
        SimpleDraweeView imageRecycleViewIag;
        @BindView(R.id.textview_related_tag)
        TextView textviewRelatedTag;
        private View itemView;
        MyRecycelViewHolder(View view) {
            super(view);
            itemView = view;
            ButterKnife.bind(this, view);
        }
    }

    public OnItemClickListener listener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int article_ID);
    }
}
