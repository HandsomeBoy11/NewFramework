package com.helw.m.anew.framework.network.callback;

import com.helw.m.anew.framework.application.SoftApplication;
import com.helw.m.anew.framework.base.BaseResponse;
import com.helw.m.anew.framework.contant.Constants;
import com.helw.m.anew.framework.utils.LogUtils;

import mvp.cn.util.LogUtil;
import mvp.cn.util.ToastUtil;
import rx.Subscriber;

/**
 * Created by hh on 2017/8/28.
 */

public abstract class RetrofitCallBack<T extends BaseResponse> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        LogUtils.i("onCompleted");
        onComplete();
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.logError("error:" + e.getMessage());
        onComplete();
        onPostFail(e);
    }

    @Override
    public void onNext(T t) {
        if (t == null) {
            onPostFail(new Throwable("解析出问题,可能您需要检查bean"));
            return;
        }
        onSuccess(t);
       /* if (t.errCode == Constants.ERROR_CODE_OK) {
            onSuccess(t);
        } else {
            onCodeError(t);
        }*/
    }

    public abstract void onPostFail(Throwable e);

    public void onCodeError(T t) {
        ToastUtil.showToast(SoftApplication.softApplication, t.msg);
    }

    public abstract void onSuccess(T t);

    public abstract void onComplete();
}
