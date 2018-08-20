package com.helw.m.anew.framework.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.helw.m.anew.ui.tab2.adapter.TabTwoAdapter;

/**
 * Created by user on 2018/8/13.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bindHolder(T itemData, int position, boolean isShow, TabTwoAdapter.OnItemClickListener listener);
}
