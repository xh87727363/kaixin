package kaixin.com.qingdan.gui.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.lankton.flowlayout.FlowLayout;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseAllCategory;
import kaixin.com.qingdan.gui.adapter.AllCategoryAdapter;
import kaixin.com.qingdan.gui.adapter.BaseRecycleViewAdapter;
import kaixin.com.qingdan.mvp.presenter.AllCategoryPresenter;
import kaixin.com.qingdan.mvp.presenter.presenterImpl.AllCategoryPresenterImpl;
import kaixin.com.qingdan.mvp.view.AllCategoryView;

/**
 * Created by Administrator on 2016/11/11 0011.
 */
public class AllCategoryActivity extends ActivityBase implements AllCategoryView, BaseRecycleViewAdapter.OnItemClickListener, View.OnClickListener {
    @BindView(R.id.textview_article_subview_title)
    TextView textviewArticleSubviewTitle;
    @BindView(R.id.imageview_article_back_key)
    ImageView imageviewArticleBackKey;
    @BindView(R.id.all_category_recycle_view)
    RecyclerView allCategoryRecycleView;
    @BindView(R.id.cantion_linear)
    LinearLayout cantionLinear;
    @BindView(R.id.linear_root)
    LinearLayout linearRoot;
    private AllCategoryAdapter allCategoryAdapter;
    private AllCategoryPresenter presenter;

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        linearRoot.setPadding(0, getStatusHeight(), 0, 0);
        textviewArticleSubviewTitle.setText("全部分类");
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
//        allCategoryRecycleView.setLayoutManager(manager);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        allCategoryRecycleView.setLayoutManager(layoutManager);
        allCategoryAdapter = new AllCategoryAdapter(this);
        allCategoryRecycleView.setAdapter(allCategoryAdapter);
        initDatas();
        allCategoryAdapter.setOnItemClickListener(this);
        imageviewArticleBackKey.setOnClickListener(this);
    }

    private void initDatas() {
        presenter = new AllCategoryPresenterImpl(this);
        presenter.loadData();
    }

    @Override
    public int getContentViewResId() {
        return R.layout.all_category;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showHidenLoading() {

    }

    @Override
    public void showLoadFialed() {

    }

    private ResponseAllCategory allCategory;

    @Override
    public void showDataSuccess(ResponseAllCategory allCategory) {
        Log.d("AllCategoryActivity", "ResponseAllCategory----chenggong");
        Log.d("AllCategoryActivity", allCategory.getData().getCategories().get(0).getIcons().getActive().getImageUrl());
        this.allCategory = allCategory;
        allCategoryAdapter.addDatas(allCategory.getData().getCategories());
        swithcCategory(0);
    }

    private int current=-1;

    private void swithcCategory(int position) {
        if (current == position) {
            return;
        }
        current = position;
        cantionLinear.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);
        List<ResponseAllCategory.DataBean.CategoriesBean.ChildrenBean> childrens
                = allCategory.getData().getCategories().get(position).getChildren();
        for (int i = 0; i < childrens.size(); i++) {
            View view = inflater.inflate(R.layout.all_category_item, cantionLinear, false);
            ViewHolder holder = new ViewHolder(view);
            holder.allCategoryTextviewTitle.setText(childrens.get(i).getName());
            holder.relativelLayoutTitle.setTag(childrens.get(i).getName());
            holder.relativelLayoutTitle.setOnClickListener(titleOnClickListener);
            for (int j = 0; j < childrens.get(i).getChildren().size(); j++) {
                TextView text = (TextView) inflater.inflate(R.layout.all_category_text, holder.flowLayout, false);
                text.setText(childrens.get(i).getChildren().get(j).getName());
                holder.flowLayout.addView(text);
                //TODO
                text.setTag(childrens.get(i).getChildren().get(j).getName());
                text.setOnClickListener(textOnClickListener);
            }
            cantionLinear.addView(view);
        }

    }

    private View.OnClickListener textOnClickListener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Toast.makeText(AllCategoryActivity.this, "v.getTag():" + v.getTag(), Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener titleOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Toast.makeText(AllCategoryActivity.this, "v.getTag():" + v.getTag(), Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    public void onItemClick(View v, int position) {
        allCategoryAdapter.setCurentPosition(position);
        swithcCategory(position);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageview_article_back_key:
                finish();
                break;
        }
    }

    static class ViewHolder {
        @BindView(R.id.all_category_textview_title)
        TextView allCategoryTextviewTitle;
        @BindView(R.id.relativel_layout_title)
        RelativeLayout relativelLayoutTitle;
        @BindView(R.id.flow_layout)
        FlowLayout flowLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
