package com.helw.m.anew.ui.tab1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.helw.m.anew.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/8/9.
 */

public class HomeMoveAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_move_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_move_item)
        ImageView ivMoveItem;
        @BindView(R.id.tv_move_name)
        TextView tvMoveName;
        @BindView(R.id.tv_move_score)
        TextView tvMoveScore;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
