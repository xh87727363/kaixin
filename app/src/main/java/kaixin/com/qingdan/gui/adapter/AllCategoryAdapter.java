package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseAllCategory;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class AllCategoryAdapter extends BaseRecycleViewAdapter<ResponseAllCategory.DataBean.CategoriesBean> {
    public AllCategoryAdapter(Context context) {
        super(context);
    }

    @Override
    public int getFooterCount() {
        return 0;
    }

    @Override
    public int getHeaderCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("AllCategoryAdapter", "onCreateViewHolder");
        View view = inflater.inflate(R.layout.all_category_left_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mholder = (ViewHolder) holder;
        ResponseAllCategory.DataBean.CategoriesBean bean = getItem(position);
        Log.d("AllCategoryAdapter", "bean.getIcons().getActive():" + bean.getIcons().getActive());
        if (position == curentPosition){
            mholder.allCategoryImage.setImageURI(bean.getIcons().getActive().getImageUrl());
        }else {
            mholder.allCategoryImage.setImageURI(bean.getIcons().getInactive().getImageUrl());
        }
    }

    private  int curentPosition;

    public void setCurentPosition(int curentPosition) {
        this.curentPosition = curentPosition;
        notifyDataSetChanged();
    }

     class ViewHolder extends BaseViewHolder{
        @BindView(R.id.all_category_image)
        SimpleDraweeView allCategoryImage;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
