package com.helw.m.anew.ui.main.presenter;

import android.util.Log;

import com.helw.m.anew.framework.network.callback.RetrofitCallBack;
import com.helw.m.anew.framework.network.retrofit.RetrofitUtils;
import com.helw.m.anew.framework.utils.LogUtils;
import com.helw.m.anew.ui.main.activity.bean.HomeContent;
import com.helw.m.anew.ui.main.view.Tab1View;

import java.util.Map;

import mvp.cn.rx.MvpRxSimplePresenter;
import rx.Observable;

/**
 * Created by hh on 2017/5/12.
 */

public class Tab1Presenter extends MvpRxSimplePresenter<Tab1View> {

    public void getOrder(Map<String,Object> map) {
        LogUtils.d("tab1_1发出请求");
        Observable login = RetrofitUtils.getInstance().getHomeData();
        getNetWork(login, new RetrofitCallBack<HomeContent>() {
            @Override
            public void onPostFail(Throwable e) {
                LogUtils.d("erre...." + e);
            }

            @Override
            public void onSuccess(HomeContent baseResponse) {
                Log.e("TAG","11111111111111111111111");

            }

            @Override
            public void onComplete() {

            }
        });
    }

    // 获取办公用品订单列表:
    public void getStationeryOrder(String serviceType, String page, String limit, String orderstatus) {
      /*  Observable stationeryOrder = RetrofitUtils.getInstance().getStationeryOrder(serviceType, page, limit, orderstatus);
        getNetWork(stationeryOrder,new RetrofitCallBack<StationeryNewBean>() {

            @Override
            public void onPostFail(Throwable e) {
                LogUtils.d("erre...." + e);
            }

            @Override
            public void onSuccess(StationeryNewBean stationeryNewBean) {
                getView().getStationeryNewSucc(stationeryNewBean);
            }

            @Override
            public void onComplete() {

            }
        });*/
    }


    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
