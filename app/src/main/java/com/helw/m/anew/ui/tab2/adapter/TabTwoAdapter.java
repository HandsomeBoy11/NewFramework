package com.helw.m.anew.ui.tab2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.base.BaseViewHolder;
import com.helw.m.anew.framework.utils.LogUtils;
import com.helw.m.anew.ui.tab2.Holder.Tab2TypeHeadHolder;
import com.helw.m.anew.ui.tab2.Holder.Tab2TypeOneHolder;
import com.helw.m.anew.ui.tab2.Holder.Tab2TypeThreeHolder;
import com.helw.m.anew.ui.tab2.Holder.Tab2TypeTwoHolder;
import com.helw.m.anew.ui.tab2.bean.ItemData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018/8/13.
 */

public class TabTwoAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private View mHeadView;
    private static final int HEADTYPE = 0;
    private List<ItemData> mDataList = new ArrayList<>();
    private final LayoutInflater inflater;

    public  TabTwoAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void setmHeadView(View headView) {
        this.mHeadView = headView;
        notifyItemChanged(0);
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeadView == null) {
            return mDataList.get(position).type;
        } else {
            if (position == 0) {
                return HEADTYPE;
            } else {
                return mDataList.get(position - 1).type;
            }
        }
//        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case HEADTYPE:
                return new Tab2TypeHeadHolder(mHeadView);
            case ItemData.TYPEONE:
                view = inflater.inflate(R.layout.item_type_one, parent, false);
                return new Tab2TypeOneHolder(view);
            case ItemData.TYPETWO:
                view = inflater.inflate(R.layout.item_type_two, parent, false);
                return new Tab2TypeTwoHolder(view);
            case ItemData.TYPETHREE:
                view = inflater.inflate(R.layout.item_type_three, parent, false);
                return new Tab2TypeThreeHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder viewHolder = (BaseViewHolder) holder;
        int realPosition=0;
        if(mHeadView!=null){
            if(position!=0)
                realPosition= getRealPosition(viewHolder,position);
        }else{
            realPosition= getRealPosition(viewHolder,position);
        }
        boolean isShowTitle = true;
        if (mDataList.size() > 0) {
            if (realPosition == 0) {
                isShowTitle = true;
            } else {
                if (mDataList.get(realPosition).type == mDataList.get(realPosition - 1).type) {
                    isShowTitle = false;
                } else {
                    isShowTitle = true;
                }
            }
            ((BaseViewHolder) holder).bindHolder(mDataList.get(realPosition), realPosition, isShowTitle, listener);
        }
    }

    @Override
    public int getItemCount() {
        return mHeadView == null ? mDataList.size() : mDataList.size() + 1;
    }

    /**
     * 获得真实条目索引
     *
     * @param holder
     * @return
     */
    public int getRealPosition(BaseViewHolder holder,int position) {
        return mHeadView == null ? position : position - 1;
    }

    /**
     * 设置数据源
     *
     * @param data
     */
    public void setData(List<ItemData> data) {
        mDataList.clear();
        mDataList.addAll(data);
        notifyDataSetChanged();
    }

    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(View view, ItemData itemData, int position);
    }
}
