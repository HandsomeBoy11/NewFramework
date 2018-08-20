package com.helw.m.anew.ui.tab1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.helw.m.anew.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/8/9.
 */

public class HomeListAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private View headView;
    private List<String> datas = new ArrayList<>();
    private static final int HEADVIEW = 1000;
    private static final int NORMAL = 1001;
    private final LayoutInflater inflater;

    public HomeListAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (headView != null && viewType == HEADVIEW) return new ViewHolder(headView);
        if (viewType==NORMAL){
            View view = inflater.inflate(R.layout.home_list_item, parent, false);
            return new ViewHolder(view);
        }
      return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int realPosition = getRealPosition(holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "点击了条目"+realPosition, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (headView == null) return NORMAL;
        if(position==0){
            return HEADVIEW;
        }else{
            return NORMAL;
        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        return headView != null ? holder.getAdapterPosition()-1 : holder.getAdapterPosition();
    }

    @Override
    public int getItemCount() {
        return headView == null ? 10 : 10+ 1;
    }

    public void setHeadView(View headView) {
        this.headView = headView;
        notifyItemChanged(0);
    }

     class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_item)
        ImageView ivItem;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_des)
        TextView tvDes;

        ViewHolder(View view) {
            super(view);
            if(headView==view)return;
            ButterKnife.bind(this, view);
        }
    }
}
