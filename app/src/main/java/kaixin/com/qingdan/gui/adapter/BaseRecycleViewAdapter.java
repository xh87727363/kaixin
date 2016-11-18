package kaixin.com.qingdan.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */

public abstract  class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<T> datas;
    public LayoutInflater inflater;
    private Context context;
    public BaseRecycleViewAdapter(Context context) {
        this.context = context;
        this.datas = new ArrayList<T>();
        inflater = LayoutInflater.from(context);
    }
    public Context getContext(){
        return context;
    }

    //添加数据
    public void addDatas(List<T> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
    public void setDatas(List<T> datas){
        this.datas.clear();
        addDatas(datas);
    }
    // 返回胶的数量
    public abstract int getFooterCount();
    //返回头的数量
    public abstract int getHeaderCount();

    /**
     * 获取对应位置的数据
     * @param position
     * @return
     */
    public T getItem(int position){
        return datas.get(position-getHeaderCount());
    }

    @Override
    public int getItemCount() {
        return datas.size()+getFooterCount()+getHeaderCount();
    }

    public void clearDatas() {
        datas.clear();
        notifyDataSetChanged();
    }
    public class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null){
                        onItemClickListener.onItemClick(v,getAdapterPosition()-getHeaderCount());
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View v ,int position);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
