package com.helw.m.anew.ui.main.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.base.MvpSimpleFragment;
import com.helw.m.anew.framework.config.AppInfo;
import com.helw.m.anew.ui.main.presenter.Tab2Presenter;
import com.helw.m.anew.ui.main.view.Tab2View;
import com.helw.m.anew.ui.mywidget.DividerDecoration;
import com.helw.m.anew.ui.mywidget.decoration.SpacesItemDecoration;
import com.helw.m.anew.ui.tab2.adapter.TabTwoAdapter;
import com.helw.m.anew.ui.tab2.bean.ItemData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mvp.cn.util.DensityUtil;


/**
 * Created by hh on 2016/5/18.
 */
public class Tab2Fragment extends MvpSimpleFragment<Tab2View, Tab2Presenter> implements Tab2View {

    @BindView(R.id.rv_tab2)
    RecyclerView rvTab2;
    private List<ItemData> list;
    private TabTwoAdapter tabTwoAdapter;


    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.f_tab2);
    }

    @Override
    public void initView(View v) {
        ButterKnife.bind(this, v);
        initData();
        rvTab2.setLayoutManager(new LinearLayoutManager(softApplication));
        tabTwoAdapter = new TabTwoAdapter(softApplication);
        rvTab2.setAdapter(tabTwoAdapter);
        tabTwoAdapter.setData(list);

        View view = new View(softApplication);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.
                MATCH_PARENT, DensityUtil.dip2px(softApplication, 180));
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.color.red);
        tabTwoAdapter.setmHeadView(view);

        //分割线
//        DividerDecoration divider = new DividerDecoration.Builder(softApplication)
//                .setHeight(1f)
//                .setColorResource(R.color.white_light)
//                .build();
//        rvTab2.addItemDecoration(divider);
        //条目的点击事件
        tabTwoAdapter.setListener(new TabTwoAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, ItemData itemData, int position) {
                Toast.makeText(softApplication, itemData.title+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ItemData itemData = new ItemData();
            if(i<3){
                itemData.type = 1;
                itemData.title = "主题一";
            }else if(i>=6){
                itemData.type = 3;
                itemData.title = "主题三";
            }else{
                itemData.type = 2;
                itemData.title = "主题二";
            }
            list.add(itemData);
        }
    }

    @Override
    public Tab2Presenter createPresenter() {
        return new Tab2Presenter();
    }

}
