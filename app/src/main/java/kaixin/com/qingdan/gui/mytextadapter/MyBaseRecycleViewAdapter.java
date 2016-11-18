package kaixin.com.qingdan.gui.mytextadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/10/26.
 */

public abstract class MyBaseRecycleViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private List<T> datas;
    public LayoutInflater inflater;
    //初始化数据
    public MyBaseRecycleViewAdapter(Context context) {
        this.datas = new ArrayList<T>();
        inflater = LayoutInflater.from(context);
    }

    /**
     * 添加数据源
     * @param datas
     */
    public void addDatas(List<T> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 返回脚部Item数量
     * @return
     */
    public abstract int getFooterCount();

    /**
     * 返回头部Item数量
     * @return
     */
    public abstract  int getHeaderCount();

    /**
     * 返回总的Item数量
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size()+getHeaderCount()+getFooterCount();
    }

    /**
     * 返回对应Item位置的数据源
     * @param position
     * @return
     */
    public  T getItemData(int position){
        return datas.get(position-getHeaderCount());
    }
}
