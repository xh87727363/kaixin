package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseCategory;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class CategoryTagAdapter extends BaseAdapter {
    private List<ResponseCategory.DataBean1.TagsBean1.BodyBean1.DataBean.TagsBean> tags;
    private Context context;
    private LayoutInflater inflater;

    public CategoryTagAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        tags = new ArrayList<>();
    }

    public void setDatas(List<ResponseCategory.DataBean1.TagsBean1.BodyBean1.DataBean.TagsBean> tags) {
        this.tags.clear();
        this.tags.addAll(tags);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyCategoryTagViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.category_tag_item, parent, false);
            holder = new MyCategoryTagViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (MyCategoryTagViewHolder) convertView.getTag();
        }
        if (position == 8){
            holder.categoryTextTag.setText("查看更多");
        }else {
            holder.categoryTextTag.setText(tags.get(position).getName());
            holder.categoryImageTag.setImageURI(tags.get(position).getCoverImage().getThumbnail().getImageUrl());
        }

        return convertView;
    }

    static class MyCategoryTagViewHolder {
        @BindView(R.id.category_image_tag)
        SimpleDraweeView categoryImageTag;
        @BindView(R.id.category_text_tag)
        TextView categoryTextTag;

        MyCategoryTagViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
