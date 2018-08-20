package com.helw.m.anew.ui.main.presenter;


import com.helw.m.anew.framework.base.BaseResponse;
import com.helw.m.anew.framework.config.UserInfo;
import com.helw.m.anew.framework.network.callback.RetrofitCallBack;
import com.helw.m.anew.framework.network.retrofit.RetrofitUtils;
import com.helw.m.anew.framework.utils.LogUtils;
import com.helw.m.anew.ui.main.activity.bean.CaptchaBean;
import com.helw.m.anew.ui.main.activity.bean.HomeBean;
import com.helw.m.anew.ui.main.activity.bean.OrderBean;
import com.helw.m.anew.ui.main.view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import mvp.cn.rx.MvpRxSimplePresenter;
import mvp.cn.util.LogUtil;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by hh on 2017/5/12.
 */

public class MainPresenter extends MvpRxSimplePresenter<MainView> {


    List<Observable> list=new ArrayList();
    public void setDatas(Observable o) {
        list.add(o);
    }
    public void getDatas() {
        Observable.just(list).subscribe(new Action1<List<Observable>>() {
            @Override
            public void call(List<Observable> observables) {
                for(Observable observable:observables){
                    observable.timer(1000, TimeUnit.MILLISECONDS).subscribe();
                }

            }
        });
//        list.clear();
    }
    public Observable getDataSingle() {

        return  RetrofitUtils.getInstance().getHomeData();
    }


    public void getData() {
        LogUtils.i("MainPresenter发出请求");

        Observable login = RetrofitUtils.getInstance().getHomeData();
        getNetWork(login, new RetrofitCallBack<HomeBean>() {
            @Override
            public void onPostFail(Throwable e) {
                LogUtils.i("出现了问题+"+e.getMessage());
            }

            @Override
            public void onSuccess(HomeBean homeBean) {
                getView().getData(homeBean);
            }

            @Override
            public void onComplete() {

            }
        });
      /*  login.subscribe(new Subscriber<HomeBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.i("出现了问题+"+e.getMessage());
            }

            @Override
            public void onNext(HomeBean o) {
                getView().getData(o);
            }
        });*/


   /*     getNetWork(login, new RetrofitCallBack<HomeBean>() {

            @Override
            public void onPostFail(Throwable e) {
                LogUtils.i("出现了问题+"+e.getMessage());
            }

            @Override
            public void onSuccess(HomeBean baseResponse) {
                getView().getData(baseResponse);
            }

            @Override
            public void onComplete() {

            }
        });*/
    }
    public void getData2() {
        LogUtils.i("MainPresenter发出请求2");
        Observable login = RetrofitUtils.getInstance().getOrder();
        getNetWork(login, new RetrofitCallBack<OrderBean>() {
            @Override
            public void onPostFail(Throwable e) {
                LogUtils.i("出现了问题2+"+e.getMessage());
            }

            @Override
            public void onSuccess(OrderBean orderBean) {
                getView().getData2(orderBean);
            }

            @Override
            public void onComplete() {

            }
        });

      /*
        login.subscribe(new Subscriber<OrderBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.i("出现了问题2+"+e.getMessage());
            }

            @Override
            public void onNext(OrderBean baseResponse) {
//                getView().getData2(baseResponse);
            }
        });*/
       /* getNetWork(login, new RetrofitCallBack<OrderBean>() {

            @Override
            public void onPostFail(Throwable e) {
                LogUtils.i("出现了问题2+"+e.getMessage());
            }

            @Override
            public void onSuccess(OrderBean baseResponse) {
                getView().getData2(baseResponse);
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
