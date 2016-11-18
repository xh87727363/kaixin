package kaixin.com.qingdan.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseMainListData;
import kaixin.com.qingdan.entity.ResponseReputation;
import kaixin.com.qingdan.gui.adapter.ArticlesRecycleViewAdapter;
import kaixin.com.qingdan.gui.adapter.CollectionsRecycleViewAdapter;
import kaixin.com.qingdan.gui.adapter.NodesRecycleViewAdapter;
import kaixin.com.qingdan.gui.adapter.RecycleViewBaseAdapter;
import kaixin.com.qingdan.mvp.presenter.MainListPresenter;
import kaixin.com.qingdan.mvp.presenter.presenterImpl.MainListPresenterImpl;
import kaixin.com.qingdan.mvp.view.MainListView;
import kaixin.com.qingdan.utils.http.Contants;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MainListFragment extends FragmentBase implements MainListView, View.OnClickListener {
    @BindView(R.id.recyclview)
    RecyclerView recyclview;
    @BindView(R.id.fab_mian_list_btn)
    FloatingActionButton fabMianListBtn;
    private MainListPresenter mainListPresenter;
    private RecycleViewBaseAdapter adapter;
    //代表哪种数据类型
    private int categoryTag;
    private String urlTag;

    public static MainListFragment newInstance(int categoryTag, String urlTag) {
        MainListFragment fragment = new MainListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("categoryTag", categoryTag);
        bundle.putString("urlTag", urlTag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_mian_list;

    }

    public void initFab() {
        fabMianListBtn.setOnClickListener(this);
        recyclview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (layoutManager.findFirstCompletelyVisibleItemPosition() == 0){
                    fabMianListBtn.hide();
                    return;
                }
                if (dy>0 && fabMianListBtn.getVisibility() == View.VISIBLE){
                    fabMianListBtn.hide();
                }else if (dy<0 && fabMianListBtn.getVisibility() == View.GONE){
                    fabMianListBtn.show();
                }
            }
        });
    }

    private LinearLayoutManager layoutManager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        recyclview = (RecyclerView) getActivity().findViewById(R.id.recyclView_main);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclview.setLayoutManager(layoutManager);

        super.onActivityCreated(savedInstanceState);
        /***************2016.10.24*****************/
        Bundle bundle = getArguments();
        categoryTag = bundle.getInt("categoryTag");
        urlTag = bundle.getString("urlTag");
        Log.d("MainListFragment", "categoryTag:" + categoryTag);
        Log.d("MainListFragment", urlTag);


        switch (categoryTag) {
            case Contants.TAG_ARTICLES:
                adapter = new ArticlesRecycleViewAdapter(getActivity());
                break;
            case Contants.TAG_COLLECTIONS:
                adapter = new CollectionsRecycleViewAdapter(getActivity());
                break;
            case Contants.TAG_NODES:
                adapter = new NodesRecycleViewAdapter(getActivity());
                break;
        }
        adapter.setOnReTryClickListener(new RecycleViewBaseAdapter.OnReTryClickListener() {
            @Override
            public void onReTryClick() {
                mainListPresenter.loadMainListData();
                isLoading = true;
            }
        });
        adapter.setOnItemClickListener(new RecycleViewBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                if(categoryTag == Contants.TAG_COLLECTIONS){
                    ResponseMainListData.DataBean.CollectionsBean collections
                            = (ResponseMainListData.DataBean.CollectionsBean) adapter.getItem(postion);
                    Toast.makeText(getActivity(), collections.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(),ArticleCollectionActivity.class);
                    intent.putExtra("article_ID",collections.get_id());
                    startActivity(intent);

                }else if (categoryTag == Contants.TAG_NODES){
                    ResponseMainListData.DataBean.NodesBean nodes
                            = (ResponseMainListData.DataBean.NodesBean) adapter.getItem(postion);
                    Toast.makeText(getActivity(), nodes.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(),ArticleDetailActivity.class);
                    intent.putExtra("article_ID",nodes.getTarget_id());
                    startActivity(intent);
                }else  if (categoryTag == Contants.TAG_ARTICLES){
                    ResponseMainListData.DataBean.ArticlesBean articles
                            = (ResponseMainListData.DataBean.ArticlesBean) adapter.getItem(postion);
                    Toast.makeText(getActivity(), articles.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(),ArticleDetailActivity.class);
                    intent.putExtra("article_ID",articles.getId());
                    startActivity(intent);
                }
            }
        });

        recyclview.setAdapter(adapter);
        recyclview.addOnScrollListener(onScrollListener);
        //数据加载
        mainListPresenter = new MainListPresenterImpl(this, urlTag);
        mainListPresenter.loadMainListData();
        isLoading = true;
        //如果是最新业就去加载口碑数据
        Log.d(TAG, "---------------------1 ");
        if (categoryTag == Contants.TAG_NODES) {
            Log.d(TAG, "---------------------2 ");
            mainListPresenter.loadRequtationData();
            Log.d(TAG, "---------------------3 ");
        }
        initFab();
    }

    private boolean noMoreData;
    private boolean isLoading;
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (noMoreData) {
                return;
            }
            if (!isLoading && layoutManager.findLastVisibleItemPosition() == layoutManager.getItemCount() - 1) {
                isLoading = true;
                mainListPresenter.loadMainListData();

            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showCollcotion(List<ResponseMainListData.DataBean.CollectionsBean> collectionsBeen) {
        adapter.addDatas(collectionsBeen);
        isLoading = false;
    }

    @Override
    public void showNodes(List<ResponseMainListData.DataBean.NodesBean> nodesBeen) {
        adapter.addDatas(nodesBeen);
        isLoading = false;
    }

    @Override
    public void showArticles(List<ResponseMainListData.DataBean.ArticlesBean> articlesBeen) {
        adapter.addDatas(articlesBeen);
        isLoading = false;
    }

    @Override
    public void showRecycleViewFooterLoading() {
        adapter.updateFootViewState(RecycleViewBaseAdapter.STATE_LOADING);
    }

    @Override
    public void showNoMoreData() {
        noMoreData = true;
        Toast.makeText(getActivity(), "没有数据了！", Toast.LENGTH_SHORT).show();
        Log.d("----------", "-----------------------");
        adapter.updateFootViewState(RecycleViewBaseAdapter.STATE_NO_MORE_DATA);

    }

    @Override
    public void loadDataFailed() {
        isLoading = false;
        adapter.updateFootViewState(RecycleViewBaseAdapter.STATE_FAILED);
    }

    @Override
    public void showRequtationSuccess(List<ResponseReputation.DataBean.RankingsBean> rankings) {
        if (adapter instanceof NodesRecycleViewAdapter) {
            NodesRecycleViewAdapter nodesAdapter = (NodesRecycleViewAdapter) adapter;
            nodesAdapter.setRankings(rankings);
        }
    }

    @Override
    public void showRequtataionFailed() {

    }

    @Override
    public void onClick(View v) {
        if (layoutManager.findLastVisibleItemPosition()>10){
            recyclview.scrollToPosition(9);
        }else {
            recyclview.scrollToPosition(0);
        }
    }
}
