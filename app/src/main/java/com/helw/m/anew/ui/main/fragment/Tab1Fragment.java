package com.helw.m.anew.ui.main.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.base.MvpSimpleFragment;
import com.helw.m.anew.framework.utils.LogUtils;
import com.helw.m.anew.framework.widget.HomeTitle;
import com.helw.m.anew.framework.widget.SpaceItemDecoration;
import com.helw.m.anew.ui.main.presenter.Tab1Presenter;
import com.helw.m.anew.ui.main.view.Tab1View;
import com.helw.m.anew.ui.mywidget.DividerDecoration;
import com.helw.m.anew.ui.mywidget.HomeIcon;
import com.helw.m.anew.ui.mywidget.decoration.SpacesItemDecoration;
import com.helw.m.anew.ui.tab1.activity.AddressActivity;
import com.helw.m.anew.ui.tab1.adapter.HomeListAdapter;
import com.helw.m.anew.ui.tab1.adapter.HomeMoveAdapter;
import com.helw.m.anew.ui.tab1.containts.Containts;
import com.helw.m.anew.ui.tab1.fragment.HomeIconFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mvp.cn.util.DensityUtil;
import mvp.cn.util.lib_zxing.activity.CaptureActivity;
import mvp.cn.util.lib_zxing.activity.CodeUtils;

import static android.app.Activity.RESULT_OK;

/**
 * Created by hh on 2016/5/18.
 */
public class Tab1Fragment extends MvpSimpleFragment<Tab1View, Tab1Presenter> implements Tab1View {

    @BindView(R.id.home_title)
    HomeTitle homeTitle;
    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    private SparseArray<Boolean> map = new SparseArray<>();
    private HomeListAdapter homeListAdapter;
    private String[] iconNmaes;
    private int[] icons = Containts.arr;
    private List<Fragment> fragments = new ArrayList<>();
    private HomeIcon homeIcon;

    @Override
    public void setContentLayout(Bundle savedInstanceState) {

        setContentView(R.layout.f_tab1_1);

    }

    @Override
    public void initView(View v) {
        ButterKnife.bind(this, v);
        initEvent();
        initData();
        initList();

    }

    /**
     * 列表
     */
    private void initList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        rvHome.setLayoutManager(layoutManager);
        homeListAdapter = new HomeListAdapter(softApplication);
        rvHome.setAdapter(homeListAdapter);
        //初始化列表头布局
        View headView = LayoutInflater.from(activity).inflate(R.layout.home_head_view, rvHome, false);
        initHeadView(headView);
        //添加头布局
        homeListAdapter.setHeadView(headView);
        //增加条目分割线
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(softApplication, DividerItemDecoration.HORIZONTAL);
        rvHome.addItemDecoration(dividerItemDecoration);
        rvHome.setItemAnimator(new DefaultItemAnimator());
        //recyclerview 滚动的监听
        rvHome.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {//向下滑 返回true没有滑到最底部  false滑动到最底部
                    LogUtils.i("为1时", "false");
                }
                if (!recyclerView.canScrollVertically(-1)) {//向上滑 返回true没有滑到最顶部  false滑动到最顶部
                    LogUtils.i("为-时", "false");
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    /**
     * 初始化头布局
     *
     * @param headView
     */
    private void initHeadView(View headView) {
        //icon
        homeIcon = (HomeIcon) headView.findViewById(R.id.vp_home_icon);
        homeIcon.setData(iconNmaes, icons, fragments);

        //move
        RecyclerView rvMove = (RecyclerView) headView.findViewById(R.id.rv_move);
        rvMove.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        HomeMoveAdapter homeMoveAdapter = new HomeMoveAdapter();
        rvMove.setAdapter(homeMoveAdapter);
        //分割线
        SpacesItemDecoration itemDecoration = new SpacesItemDecoration(DensityUtil.dip2px(softApplication,
                12), DensityUtil.dip2px(softApplication, 8));
        rvMove.addItemDecoration(itemDecoration);
    }

    private void initData() {
        iconNmaes = getResources().getStringArray(R.array.icon_name);
        for (int i = 0; i < 2; i++) {
            fragments.add(HomeIconFragment.getInstance(iconNmaes, icons, i));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        homeIcon.startBanner();
    }

    @Override
    public void onStop() {
        super.onStop();
        homeIcon.stopBanner();
    }

    /**
     * 首页标题的点击事件
     */
    private void initEvent() {
        homeTitle.setListener(new HomeTitle.ScannerClickListen() {
            @Override
            public void onClick() {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, Containts.REQUEST_CODE);
            }

            @Override
            public void address() {
                startActivityForResult(new Intent(getActivity(), AddressActivity.class), Containts.ADDRESSRESULT);
            }
        });
    }

    @Override
    public Tab1Presenter createPresenter() {
        return new Tab1Presenter();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.i("调用了");
        if (resultCode == RESULT_OK) {
            if (requestCode == Containts.ADDRESSRESULT) {
                String address = data.getStringExtra("address");
                homeTitle.setAddress(address);
                Toast.makeText(softApplication, address, Toast.LENGTH_SHORT).show();
            } else if (requestCode == Containts.REQUEST_CODE) {
                //处理扫描结果（在界面上显示）
                if (null != data) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result1 = bundle.getString(CodeUtils.RESULT_STRING);
                        Toast.makeText(getActivity(), "解析结果:" + result1, Toast.LENGTH_LONG).show();
                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

}
