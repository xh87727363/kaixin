package kaixin.com.qingdan.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseCategory;
import kaixin.com.qingdan.gui.Activity.AllCategoryActivity;
import kaixin.com.qingdan.gui.Activity.CategoryShopDetailes;
import kaixin.com.qingdan.gui.adapter.CategorySelectAdapter;
import kaixin.com.qingdan.gui.adapter.CategoryTagAdapter;
import kaixin.com.qingdan.mvp.presenter.CategoryPresenter;
import kaixin.com.qingdan.mvp.presenter.presenterImpl.CategoryPresenterImpl;
import kaixin.com.qingdan.mvp.view.CategoryView;
import kaixin.com.qingdan.utils.http.KeyBoardUtils;

/**
 * Created by Administrator on 2016/10/17.
 */

public class CategoryFragment extends FragmentBase implements CategoryView {
    @BindView(R.id.search_edit_input)
    EditText searchEditInput;
    @BindView(R.id.image_search)
    ImageView imageSearch;
    @BindView(R.id.img_search_delete)
    ImageView imgSearchDelete;
    @BindView(R.id.tv_text_search_cancel)
    TextView tvTextSearchCancel;
    @BindView(R.id.gridView_select_categories)
    GridView gridViewSelectCategories;
    @BindView(R.id.gridView_hot_tag)
    GridView gridViewHotTag;
    @BindView(R.id.materRefresh_category)
    MaterialRefreshLayout materRefreshCategory;
    private CategoryPresenter presenter;
    private CategorySelectAdapter selectAdapter;
    private CategoryTagAdapter tagAdapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_category;
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            materRefreshCategory.finishRefresh();
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        searchEditInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    imgSearchDelete.setVisibility(View.GONE);
                } else {
                    imgSearchDelete.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        searchEditInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    doSearch();
                }
                return false;
            }
        });
        materRefreshCategory.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                materRefreshCategory.refreshDrawableState();
                handler.sendEmptyMessageDelayed(0,1000);
            }
        });
        gridViewSelectCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==8){
                    Intent intent = new Intent(getContext(), AllCategoryActivity.class);
                    startActivity(intent);
                    return;
                }
                Intent intent = new Intent(getContext(), CategoryShopDetailes.class);
                startActivity(intent);
            }
        });
        gridViewHotTag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 8){
                    Intent intent = new Intent(getContext(),AllCategoryActivity.class);
                    startActivity(intent);
                    return;
                }
                Intent intent = new Intent(getContext(),CategoryShopDetailes.class);
                startActivity(intent);
            }
        });

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        selectAdapter = new CategorySelectAdapter(getContext());
        tagAdapter = new CategoryTagAdapter(getContext());
        presenter = new CategoryPresenterImpl(this);
        presenter.loadData();

    }


    @Override
    public void showData(ResponseCategory.DataBean1 data) {
        Log.d("CategoryFragment", "获取成功");
        List<ResponseCategory.DataBean1.CategoriesBean1.BodyBean.DataBean.CategoriesBean> categories = data.getCategories().getBody().getData().getCategories();
        List<ResponseCategory.DataBean1.TagsBean1.BodyBean1.DataBean.TagsBean> tags = data.getTags().getBody().getData().getTags();
        Log.d("CategoryFragment", "categories.size():" + categories.size());
        selectAdapter.addData(categories);
        gridViewSelectCategories.setAdapter(selectAdapter);
        tagAdapter.setDatas(tags);
        gridViewHotTag.setAdapter(tagAdapter);


    }

    @Override
    public void showFailed() {
        Log.d("CategoryFragment", "获取失败");
    }


    private void doSearch() {
    }


    @OnClick({R.id.search_edit_input, R.id.image_search, R.id.img_search_delete, R.id.tv_text_search_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_edit_input:
                tvTextSearchCancel.setVisibility(View.VISIBLE);
                break;
            case R.id.image_search:
                doSearch();
                break;
            case R.id.img_search_delete:
                searchEditInput.getText().clear();
                break;
            case R.id.tv_text_search_cancel:
                tvTextSearchCancel.setVisibility(View.GONE);
                KeyBoardUtils.closeKeybord(searchEditInput,getContext());
                break;

        }
    }

}
