package com.helw.m.anew.ui.main.presenter;

import com.helw.m.anew.ui.main.view.Tab3View;

import mvp.cn.rx.MvpRxSimplePresenter;

/**
 * Created by hh on 2017/5/12.
 */

public class Tab3Presenter extends MvpRxSimplePresenter<Tab3View> {


    public void getData(String serviceType) {
       /* final Observable personInfo = RetrofitUtils.getInstance().getPersonInfo(serviceType);
        getNetWork(personInfo, new RetrofitCallBack<PersonInfoBean>() {
            @Override
            public void onPostFail(Throwable e) {
                LogUtils.d(e.toString());
            }

            @Override
            public void onSuccess(PersonInfoBean personInfoBean) {
                getView().getSuccess(personInfoBean);
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
