package com.helw.m.anew.ui.tab2.Holder;

import android.view.View;
import android.widget.TextView;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.base.BaseViewHolder;
import com.helw.m.anew.ui.tab2.adapter.TabTwoAdapter;
import com.helw.m.anew.ui.tab2.bean.ItemData;

import java.util.List;

/**
 * Created by user on 2018/8/13.
 */

public class Tab2TypeOneHolder extends BaseViewHolder<ItemData> {

    private  TextView tvTypeName;
    private View mItemView;

    public Tab2TypeOneHolder(View itemView) {
        super(itemView);
        this.mItemView=itemView;
        tvTypeName = (TextView) itemView.findViewById(R.id.tv_type_name);
    }

    @Override
    public void bindHolder(final ItemData itemData, final int position, boolean isShow, final TabTwoAdapter.OnItemClickListener listener) {
        tvTypeName.setText(itemData.title);
        if(isShow){
            tvTypeName.setVisibility(View.VISIBLE);
        }else{
            tvTypeName.setVisibility(View.GONE);
        }
        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    listener.onItemClickListener(view,itemData,position);
                }
            }
        });
    }
}
