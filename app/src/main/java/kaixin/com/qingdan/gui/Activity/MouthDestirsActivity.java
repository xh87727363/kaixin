package kaixin.com.qingdan.gui.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.gui.fragment.MouthFragment;
import kaixin.com.qingdan.utils.http.Contants;
import kaixin.com.qingdan.utils.http.KeyBoardUtils;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class MouthDestirsActivity extends ActivityBase {
    @BindView(R.id.textview_article_subview_title)
    TextView textviewArticleSubviewTitle;
    @BindView(R.id.imageview_article_back_key)
    ImageView imageviewArticleBackKey;
    @BindView(R.id.radio_button_hot)
    RadioButton radioButtonHot;
    @BindView(R.id.radio_button_comments_scroe)
    RadioButton radioButtonCommentsScroe;
    @BindView(R.id.radio_button_name)
    RadioButton radioButtonName;
    @BindView(R.id.mouth_radio_group)
    RadioGroup mouthRadioGroup;
    @BindView(R.id.container)
    FrameLayout container;
    public static final String RANKING_ID = "rankings";
    @BindView(R.id.search_edit_input)
    EditText searchEditInput;
    @BindView(R.id.image_search)
    ImageView imageSearch;
    @BindView(R.id.img_search_delete)
    ImageView imgSearchDelete;
    @BindView(R.id.tv_text_search_cancel)
    TextView tvTextSearchCancel;
    private List<MouthFragment> fragments;
    private FragmentManager fragmentManager;
    private String search ="";

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        searchEditInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)){
                    imgSearchDelete.setVisibility(View.GONE);
                }else {
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
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    doSearch(searchEditInput.getText().toString());
                }
                return false;
            }
        });
        mouthRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_button_hot:
                        switchFragment(0);
                        break;
                    case R.id.radio_button_comments_scroe:
                        switchFragment(1);
                        break;
                    case R.id.radio_button_name:
                        switchFragment(2);
                        break;
                }
            }
        });
    }
    private  boolean isSearch;
    private void doSearch(String searchKey) {
        lastFragment.showFragment(searchKey);
        this.search = searchKey;
        isSearch = true;
        Toast.makeText(this, "搜索数据", Toast.LENGTH_SHORT).show();
    }

    private MouthFragment lastFragment;

    private void switchFragment(int index) {
        MouthFragment fragment = fragments.get(index);
        if (fragment == lastFragment) {
            //如果正在显示
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragment.showFragment(search);
            transaction.show(fragment);
        } else {
            fragment.setSearchKey(search);
            transaction.add(R.id.container, fragment);
        }
        if (lastFragment != null) {
            transaction.hide(lastFragment);
        }
        transaction.commit();
        lastFragment = fragment;

    }

    @Override
    public int getContentViewResId() {
        return R.layout.mouth_details;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        int rankings_id = getIntent().getIntExtra(RANKING_ID, 0);
        fragments = new ArrayList<>();
        fragments.add(MouthFragment.newInstance(rankings_id, Contants.SORT_BY_REVIEW_COUNT));
        fragments.add(MouthFragment.newInstance(rankings_id, Contants.SORT_BY_rating_score));
        fragments.add(MouthFragment.newInstance(rankings_id, Contants.SORT_BY_BRAND_NAME));
        fragmentManager = getSupportFragmentManager();
        switchFragment(0);

    }


    @OnClick({R.id.imageview_article_back_key, R.id.search_edit_input, R.id.image_search, R.id.img_search_delete, R.id.tv_text_search_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_article_back_key:
                finish();
                break;
            case R.id.search_edit_input:
                tvTextSearchCancel.setVisibility(View.VISIBLE);
                break;
            case R.id.image_search:
                doSearch(searchEditInput.getText().toString());
                break;
            case R.id.img_search_delete:
                searchEditInput.getText().clear();
                break;
            case R.id.tv_text_search_cancel:
                tvTextSearchCancel.setVisibility(View.GONE);
                searchEditInput.getText().clear();
                KeyBoardUtils.closeKeybord(searchEditInput,this);
                doSearch("");
                break;
        }
    }
}
