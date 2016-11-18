package kaixin.com.qingdan.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseMouth_Things;
import kaixin.com.qingdan.gui.adapter.MouthThingsAdapter;
import kaixin.com.qingdan.gui.adapter.RecycleViewBaseAdapter;
import kaixin.com.qingdan.mvp.presenter.MouthThingsPreserenter;
import kaixin.com.qingdan.mvp.presenter.presenterImpl.MouthThingsPresenterImpl;
import kaixin.com.qingdan.mvp.view.MouthThingsView;


/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class MouthFragment extends FragmentBase implements MouthThingsView {
    @BindView(R.id.recycleView_ranking_thing)
    RecyclerView recycleViewRankingThing;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    private MouthThingsAdapter adapter;
    private MouthThingsPreserenter preserenter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_ranking_thing;
    }

    public static MouthFragment newInstance(int rankingsID, int storTag) {
        MouthFragment fragment = new MouthFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("rankings", rankingsID);
        bundle.putInt("storTag", storTag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
    private LinearLayoutManager layoutManager;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleViewRankingThing.setLayoutManager(layoutManager);
        adapter = new MouthThingsAdapter(getActivity());
        recycleViewRankingThing.setAdapter(adapter);
        initData();
        recycleViewRankingThing.addOnScrollListener(listener);

    }
    private RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (noMoreData){
                return;
            }
            if (!isLoading &&layoutManager.findLastVisibleItemPosition() == layoutManager.getItemCount() - 1){

                loadNextPage();
            }
        }
    };
    private boolean noMoreData;
    private boolean isLoading;
    private int ranking_id;
    private int storTag;
    private String searchKey;
    private void initData(){
        Bundle bundle = getArguments();
        ranking_id = bundle.getInt("rankings");
        storTag = bundle.getInt("storTag");
        preserenter = new MouthThingsPresenterImpl(this,storTag,ranking_id);
        loadNextPage();
    }
    public void loadNextPage(){
        preserenter.loadNextData(searchKey);
        isLoading = true;//放在这里
    }


    @Override
    public void showThings(int page, List<ResponseMouth_Things.DataBean.ThingsBean> things) {
        Log.d("MouthFragment", " showThings "+things.get(0).getFullName());
        adapter.addDatas(things);
        isLoading = false;
    }

    @Override
    public void showFooterLoading() {
            isLoading = false;
        adapter.updateFootViewState(RecycleViewBaseAdapter.STATE_LOADING);
    }

    @Override
    public void showFooterLoadFailed() {
        Toast.makeText(getContext(), "showFooterLoadFailed", Toast.LENGTH_SHORT).show();
        adapter.updateFootViewState(RecycleViewBaseAdapter.STATE_FAILED);
        isLoading = false;
    }

    @Override
    public void showFooterNoMoreData() {
        noMoreData = true;
        adapter.updateFootViewState(RecycleViewBaseAdapter.STATE_NO_MORE_DATA);
    }

    @Override
    public void showFooterNoSearchData() {
        Toast.makeText(getContext(), "showFooterNoSearchData", Toast.LENGTH_SHORT).show();
        isLoading = false;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSearchKey() {
        return searchKey;
    }
    public void showFragment(String searchKey) {
        if (searchKey.equals(this.searchKey)){
            return;
        }
        adapter.clearDatas();
        this.searchKey = searchKey;
        Log.d("MouthFragment", "search");
        preserenter.loadRefreshData(searchKey);
    }
}
