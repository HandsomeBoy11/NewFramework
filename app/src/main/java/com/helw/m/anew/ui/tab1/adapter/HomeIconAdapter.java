package com.helw.m.anew.ui.tab1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.helw.m.anew.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/8/9.
 */

public class HomeIconAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mNames = new ArrayList<>();
    private List<Integer> mIcon = new ArrayList<>();

    public HomeIconAdapter(Context softApplication) {
        this.mContext = softApplication;
    }

    @Override
    public int getCount() {
        return mNames.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view == null) {
            view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_icon_item, viewGroup, false);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        if(mNames.size()>0){
            holder.ivItem.setImageResource(mIcon.get(i));
            holder.tvItem.setText(mNames.get(i));
        }
        return view;
    }

    public void setData(List<String> names, List<Integer> icon) {
        mIcon.clear();
        mNames.clear();
        this.mNames.addAll(names);
        this.mIcon.addAll(icon);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @BindView(R.id.iv_item)
        ImageView ivItem;
        @BindView(R.id.tv_item)
        TextView tvItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
