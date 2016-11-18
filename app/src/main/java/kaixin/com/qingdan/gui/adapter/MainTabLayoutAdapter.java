package kaixin.com.qingdan.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kaixin.com.qingdan.entity.ResponseBatching;
import kaixin.com.qingdan.gui.fragment.MainListFragment;
import kaixin.com.qingdan.utils.http.Contants;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MainTabLayoutAdapter extends FragmentPagerAdapter {
    private  List<ResponseBatching.DataBean1.ChannelsBean1.BodyBean.DataBean.ChannelsBean> datas;
    private List<Fragment> fragments;
    public MainTabLayoutAdapter(List<ResponseBatching.DataBean1.ChannelsBean1.BodyBean.DataBean.ChannelsBean> datas,
                                FragmentManager fm) {
        super(fm);
        this.datas = datas;
        fragments = new ArrayList<>();
//        for (int i = 0; i < datas.size()+1; i++) {
//            fragments.add(new MainListFragment());
//        }
        fragments.add(MainListFragment.newInstance(Contants.TAG_NODES,"http://api.eqingdan.com/v1/front?page={0}"));
        for(ResponseBatching.DataBean1.ChannelsBean1.BodyBean.DataBean.ChannelsBean data:datas){
            String urlTag = null;
            if ("collections".equals(data.getType())){
                urlTag = "http://api.eqingdan.com/v1/collections?page={0}";
                fragments.add(MainListFragment.newInstance(Contants.TAG_COLLECTIONS,urlTag));
            }else if("articles_belong_to_category".equals(data.getType())){
                urlTag = "http://api.eqingdan.com/v1/categories/"+data.getExtra().getCategory_slug()+"/articles?page={0}";
                fragments.add(MainListFragment.newInstance(Contants.TAG_ARTICLES,urlTag));
            }else if("articles_belong_to_collection".equals(data.getType())){
                urlTag = "http://api.eqingdan.com/v1/collections/"
                        + data.getExtra().getCollection_id()
                        +"/articles?page={0}";
                fragments.add(MainListFragment.newInstance(Contants.TAG_ARTICLES,urlTag));
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position ==0){
            return "最新";
        }
        return datas.get(position-1).getTitle();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
