package com.helw.m.anew.ui.mywidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.application.SoftApplication;
import com.helw.m.anew.framework.base.BaseActivity;
import com.helw.m.anew.framework.utils.LogUtils;
import com.helw.m.anew.ui.tab1.adapter.HomeIconPagerAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.cn.util.DensityUtil;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by user on 2018/8/9.
 */

public class HomeIcon extends LinearLayout {

    @BindView(R.id.vp_home)
    MyViewPager vpHomeIcon;
    @BindView(R.id.ll_dot)
    LinearLayout llDot;
    @BindView(R.id.home_banner)
    Banner banner;
    private LayoutInflater inflater;
    private String[] iconNmaes;
    private int[] icons;
    private BaseActivity mContext;
    private HomeIconPagerAdapter pagerAdapter;
    private List<String> bannerIamgePaths;
    private List<String> bannerTitles;

    public HomeIcon(Context context) {
        this(context, null);
    }

    public HomeIcon(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public HomeIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (context instanceof BaseActivity)
            this.mContext = ((BaseActivity) context);
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_icon, this);
        ButterKnife.bind(this, view);
        initView(view);
    }

    private void initView(View view) {

        pagerAdapter = new HomeIconPagerAdapter(mContext.getSupportFragmentManager());
        vpHomeIcon.setAdapter(pagerAdapter);
        vpHomeIcon.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < llDot.getChildCount(); i++) {
                    if (position == i) {
                        llDot.getChildAt(i).setSelected(true);
                    } else {
                        llDot.getChildAt(i).setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        LinearLayout llDot = (LinearLayout) view.findViewById(R.id.ll_dot);
    }

    public void setData(String[] iconNmaes, int[] icons, List<Fragment> fragments) {
        this.iconNmaes = iconNmaes;
        this.icons = icons;
        pagerAdapter.setData(fragments);
        for (int i = 0; i < fragments.size(); i++) {
            ImageView view = new ImageView(mContext);
            LayoutParams layoutParams = new LayoutParams(DensityUtil.dip2px(SoftApplication.softApplication, 5)
                    , DensityUtil.dip2px(SoftApplication.softApplication, 5));
            layoutParams.setMargins(5, 0, 5, 0);
            view.setLayoutParams(layoutParams);
            view.setImageResource(R.drawable.dot);
            if (i == 0) {
                view.setSelected(true);
            }
            llDot.addView(view);
        }

        bannerIamgePaths = Arrays.asList("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg",
                "http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg",
                "http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        bannerTitles = Arrays.asList("题目一", "题目二", "题目三");
        initBanner();
    }


    private void initBanner() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(bannerIamgePaths);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(bannerTitles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1800);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.NOT_INDICATOR);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(mContext, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void startBanner() {
        if (banner != null)
            banner.startAutoPlay();
    }

    public void stopBanner() {
        if (banner != null)
            banner.stopAutoPlay();
    }
}
