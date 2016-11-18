package kaixin.com.qingdan.gui.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseMouthList;
import kaixin.com.qingdan.gui.adapter.Moth_list_adapter;
import kaixin.com.qingdan.mvp.presenter.MouthListPresenter;
import kaixin.com.qingdan.mvp.presenter.presenterImpl.MouthListPresenterImpl;
import kaixin.com.qingdan.mvp.view.MouthListView;

/**
 * Created by Administrator on 2016/11/7 0007.
 */

public class Mouth_list_Activity extends ActivityBase implements MouthListView {
    private ImageView image_back;
    LinearLayout mouthRoot;
    TextView textviewArticleSubviewTitle;
    private MaterialRefreshLayout refreshLayout;
    private Moth_list_adapter adapter;
    private ListView listview;
    private MouthListPresenter mouthListPresenter;
    @Override
    protected void initViews() {
        textviewArticleSubviewTitle = (TextView) findViewById(R.id.textview_article_subview_title);
        textviewArticleSubviewTitle.setText("口碑清单");
        image_back = (ImageView) findViewById(R.id.imageview_article_back_key);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        refreshLayout = (MaterialRefreshLayout) findViewById(R.id.mouth_list_refresh_layout);
        mouthRoot = (LinearLayout) findViewById(R.id.mouth_root);
        listview = (ListView) findViewById(R.id.listview_mouth_list);
        adapter = new Moth_list_adapter(this);
        listview.setAdapter(adapter);
        listview.addHeaderView(LayoutInflater.from(this).inflate(R.layout.mouth_list_head,null));
        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (listview.getLastVisiblePosition() == totalItemCount-1){
                        mouthListPresenter.loadNextPage();
                    }
            }
        });
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                mouthListPresenter.loadNextPage();
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position!=0){
                    Intent intent = new Intent(Mouth_list_Activity.this,MouthDestirsActivity.class);
                    intent.putExtra(MouthDestirsActivity.RANKING_ID,adapter.getItemData(position).getId());
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getContentViewResId() {
        return R.layout.mouth_list_activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int height = getStatusHeight();
        mouthRoot.setPadding(0, height, 0, 0);
        mouthListPresenter = new MouthListPresenterImpl(this);
        mouthListPresenter.loadNextPage();



    }

    private boolean noMoredata;
    private boolean isLoading;

    @Override
    public void showNextPageDatas(List<ResponseMouthList.DataBean.RankingsBean> rankings) {
        adapter.addRankings(rankings);
        refreshLayout.finishRefresh();

        isLoading = false;
    }

    @Override
    public void showNextPageFail() {
        Toast.makeText(this, "数据加载失败", Toast.LENGTH_SHORT).show();
        isLoading = false;
        refreshLayout.finishRefresh();
    }

    @Override
    public void showNoMoreData() {
        refreshLayout.finishRefresh();
        noMoredata = true;
        Toast.makeText(this, "没有更多数据", Toast.LENGTH_SHORT).show();
    }
}
