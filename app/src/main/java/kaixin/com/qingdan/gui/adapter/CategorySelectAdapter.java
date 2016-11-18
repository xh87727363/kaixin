package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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

public class CategorySelectAdapter extends BaseAdapter {



    private List<ResponseCategory.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean> categories;
    private Context context;
    private LayoutInflater inflater;
    private int[] color = {0xFFdbe0eb, 0xFFe6f6f8, 0xFFf4e8e8, 0xFFefe2d3};

    public CategorySelectAdapter(Context context) {
        this.context = context;
        categories = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void addData(List<ResponseCategory.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean> categories) {
        this.categories.clear();
        this.categories.addAll(categories);
        notifyDataSetChanged();
    }

    ;

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
        ViewHolder holder = null;
//        if (position == 8){
//            holder = (ViewHolder) convertView.getTag();
//            holder.textviwCategorySelect.setText("查看更多");
//        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.category_select_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.d("CategorySelectAdapter", "categories.size()---:" + categories.size());
        if (position == 8) {

            holder = (ViewHolder) convertView.getTag();
            holder.textviwCategorySelect.setText("查看更多");
            holder.categoryLinearSelect.setBackgroundColor(color[position % 4]);
            holder.LinearlayoutText.setGravity(Gravity.CENTER);
            holder.textviwCategorySelect.setGravity(Gravity.CENTER);
        } else {
            ResponseCategory.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean bean = categories.get(position);
            holder.textviwCategorySelect.setText(bean.getName());
            holder.categoryImage.setImageURI(bean.getFeaturedImageUrl());
            holder.categoryLinearSelect.setBackgroundColor(color[position % 4]);

        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.Linearlayout_text)
        LinearLayout LinearlayoutText;
        @BindView(R.id.frameLayout)
        FrameLayout frameLayout;
        @BindView(R.id.textviw_category_select)
        TextView textviwCategorySelect;
        @BindView(R.id.category_image)
        SimpleDraweeView categoryImage;
        @BindView(R.id.category_linear_select)
        LinearLayout categoryLinearSelect;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
