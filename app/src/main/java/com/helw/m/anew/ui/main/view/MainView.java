package com.helw.m.anew.ui.main.view;

import com.helw.m.anew.framework.base.BaseResponse;
import com.helw.m.anew.framework.config.UserInfo;
import com.helw.m.anew.ui.main.activity.bean.CaptchaBean;
import com.helw.m.anew.ui.main.activity.bean.HomeBean;
import com.helw.m.anew.ui.main.activity.bean.OrderBean;

import mvp.cn.common.MvpView;

/**
 * Created by hh on 2017/5/12.
 */

public interface MainView extends MvpView {
    void getData(HomeBean info);
    void getData2(OrderBean info);

}
