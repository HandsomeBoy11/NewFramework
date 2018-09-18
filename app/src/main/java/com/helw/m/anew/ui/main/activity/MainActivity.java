package com.helw.m.anew.ui.main.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.base.BaseActivity;
import com.helw.m.anew.framework.base.MvpSimpleActivity;
import com.helw.m.anew.framework.spfs.SharedPrefHelper;
import com.helw.m.anew.framework.utils.LogUtils;
import com.helw.m.anew.framework.widget.TabBar;
import com.helw.m.anew.ui.main.activity.bean.HomeBean;
import com.helw.m.anew.ui.main.activity.bean.OrderBean;
import com.helw.m.anew.ui.main.fragment.Tab1Fragment;
import com.helw.m.anew.ui.main.fragment.Tab2Fragment;
import com.helw.m.anew.ui.main.fragment.Tab3Fragment;
import com.helw.m.anew.ui.main.presenter.MainPresenter;
import com.helw.m.anew.ui.main.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import mvp.cn.util.LogUtil;

public class MainActivity extends BaseActivity{

    @BindView(R.id.m_frameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.m_bottom)
    TabBar mBottom;

    public static boolean isRefreshOrder = false;

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public void setContentLayout() {
        setTranslucentStatus(R.color.yellow);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void initView() {
        // TODO: 2018/9/18 提交测试
//        getPresenter().getData();
//        getPresenter().getData2();
//        getPresenter().setDatas(getPresenter().getDataSingle());
        fragments.add(new Tab1Fragment());
        fragments.add(new Tab2Fragment());
        fragments.add(new Tab3Fragment());
        //默认选中的界面
        mBottom.setOnItemChangedListener(onBottomItemClickListener);
        mBottom.setItemChecked(0);

        LogUtil.log(SharedPrefHelper.getInstance().getServicetype() + "==============登录类型====================");

    }

    /**
     * 底部导航栏的点击
     * 未登录状态下
     */
    TabBar.OnItemChangedListener onBottomItemClickListener = new TabBar.OnItemChangedListener() {
        @Override
        public boolean onItemChecked(int position) {
            changeFragment(position);
            return false;
        }
    };

    public void refresh() {
        mBottom.setItemChecked(0);
        changeFragment(0);
    }
    private Fragment currentFragment;
    private void changeFragment(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fragments.get(index);
        if(fragment.isAdded()){
            if(currentFragment==null){
                ft.show(fragment);
            }else{
                ft.hide(currentFragment).show(fragment);
            }
        }else{
            if(currentFragment==null){
                ft.add(R.id.m_frameLayout,fragment);
            }else{
                ft.hide(currentFragment).add(R.id.m_frameLayout,fragment);
            }
        }
        ft.commit();
        currentFragment=fragment;
    }

    public Tab1Fragment getTab1Fragment() {
        return (Tab1Fragment) fragments.get(0);
    }


/*
    @Override
    public void getData(HomeBean info) {
        LogUtils.i("BaseResponse==="+info);
        //GlideLoading.getInstance().LoaderCircle();
    }

    @Override
    public void getData2(OrderBean info) {
        LogUtils.i("BaseResponse2==="+info.getCode()+info.getData());
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }*/
}
