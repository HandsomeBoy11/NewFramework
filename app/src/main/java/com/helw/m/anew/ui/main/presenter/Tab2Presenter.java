package com.helw.m.anew.ui.main.presenter;

import com.helw.m.anew.ui.main.view.Tab2View;

import mvp.cn.rx.MvpRxSimplePresenter;

/**
 * Created by hh on 2017/5/12.
 */

public class Tab2Presenter extends MvpRxSimplePresenter<Tab2View> {


    public void getOrderMessage(String serviceTypeId, String page, String limit) {
//        Observable orderMessage = RetrofitUtils.getInstance().getOrderMessage(serviceTypeId, page, limit);
//        getNetWork(orderMessage, new RetrofitCallBack<OrderMessageBean>() {
//            @Override
//            public void onPostFail(Throwable e) {
//                LogUtils.d(e.toString());
//            }
//
//            @Override
//            public void onSuccess(OrderMessageBean orderMessageBean) {
//                getView().orderMessageSucc(orderMessageBean);
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
