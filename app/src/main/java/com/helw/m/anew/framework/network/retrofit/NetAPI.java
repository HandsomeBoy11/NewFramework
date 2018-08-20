package com.helw.m.anew.framework.network.retrofit;

import com.helw.m.anew.framework.base.BaseResponse;
import com.helw.m.anew.ui.main.activity.bean.CaptchaBean;
import com.helw.m.anew.ui.main.activity.bean.HomeBean;
import com.helw.m.anew.ui.main.activity.bean.OrderBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by hh on 2017/5/12.
 */

public interface NetAPI {

//    @FormUrlEncoded
//    @POST(NetUrl.image)
//    Observable<CaptchaBean> getIagme (@FieldMap Map<String, Object> map);

    @GET(NetUrl.home)
    Observable<HomeBean> home(/*@QueryMap Map<String, Object> map*/);
    @GET(NetUrl.order)
    Observable<OrderBean> order(/*@QueryMap Map<String, Object> map*/);
//    @FormUrlEncoded
//    @POST(NetUrl.login)
//    Observable<LoginBean> login (@FieldMap Map<String, Object> map);
//    @FormUrlEncoded
//    @POST(NetUrl.capture)
//    Observable<CaptchaBean> capture (@FieldMap Map<String, Object> map);
//    @FormUrlEncoded
//    @POST(NetUrl.checkcapture)
//    Observable<CommonBean> checkcapture (@FieldMap Map<String, Object> map);
//    @FormUrlEncoded
//    @POST(NetUrl.register)
//    Observable<CommonBean> register (@FieldMap Map<String, Object> map);
//
//    // 上传头像
//    @POST(NetUrl.upPhoto)
//    Observable<PhotoBean> upPhoto(@Body RequestBody Body);

}
