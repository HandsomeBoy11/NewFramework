package com.helw.m.anew.ui.main.activity.bean;

import com.helw.m.anew.framework.base.BaseResponse;

/**
 * Created by user on 2018/4/4.
 */

public class CaptchaBean extends BaseResponse {
    /**
     * captcha : 757532
     */

    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
