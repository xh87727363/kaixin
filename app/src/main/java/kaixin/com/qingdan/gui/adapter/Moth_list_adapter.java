package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseMouthList;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class Moth_list_adapter extends BaseAdapter {
    private List<ResponseMouthList.DataBean.RankingsBean> rankings;
    private LayoutInflater inflater;
    private Context context;

    public Moth_list_adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        rankings = new ArrayList<>();
    }

    public void addRankings(List<ResponseMouthList.DataBean.RankingsBean> rankings) {
        this.rankings.addAll(rankings);
        notifyDataSetChanged();
    }
    public void clearRankings(){
        this.rankings.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return rankings.size();
    }

    @Override
    public Object getItem(int position) {
        return rankings.get(position);
    }
    public ResponseMouthList.DataBean.RankingsBean getItemData(int position){
        return rankings.get(position-1);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.mouth_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textviewMouthTitle.setText(rankings.get(position).getTitle());
        holder.textviewShopCount.setText(context.getString(R.string.shopNum,rankings.get(position).getThingCount()));
        holder.textHitCommentsCount.setText(context.getString(R.string.reviewCount,rankings.get(position).getReviewCount()));

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.textview_mouth_title)
        TextView textviewMouthTitle;
        @BindView(R.id.textview_shop_count)
        TextView textviewShopCount;
        @BindView(R.id.text_hit_comments_count)
        TextView textHitCommentsCount;
        @BindView(R.id.linear_mouth_item)
        LinearLayout linearMouthItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
