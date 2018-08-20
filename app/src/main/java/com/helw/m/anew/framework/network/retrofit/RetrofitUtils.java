package com.helw.m.anew.framework.network.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.helw.m.anew.framework.application.SoftApplication;
import com.helw.m.anew.framework.contant.Constants;
import com.helw.m.anew.framework.network.AppConstants;
import com.helw.m.anew.framework.network.ParameterKeys;
import com.helw.m.anew.framework.network.ServerConstants;
import com.helw.m.anew.framework.spfs.SharedPrefHelper;
import com.helw.m.anew.framework.utils.LogUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import mvp.cn.util.DateUtil;
import mvp.cn.util.Md5Util;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hh on 2017/5/12.
 */

public class RetrofitUtils implements AppConstants, ServerConstants {

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    private static NetAPI api;
    private static RetrofitUtils instance;

    private static RetrofitUtils createApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(NetAPI.class);
        return new RetrofitUtils();
    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    //打印retrofit日志
                    LogUtils.i("retrofit", "retrofitBack = " + message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            okHttpClient = builder.readTimeout(HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS).
                    connectTimeout(HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS).
                    addInterceptor(loggingInterceptor).build();
        }
        return okHttpClient;
    }

    private static String getSign(String biz, String timestamp) throws UnsupportedEncodingException {
        return Md5Util.getMD5(URLEncoder.encode(biz, "UTF-8") + timestamp + Constants.KEY_SECRET);
    }

    private static void addParam(Map<String, Object> paramsMap, Map<String, String> tempMap) {
        Gson gson = new Gson();
        String biz = gson.toJson(tempMap);
        paramsMap.put(ParameterKeys.BIZ, biz);
        LogUtils.d("biz请求参数：" + biz);
        String timestamp = DateUtil.getCurrentDateTimeyyyyMMddHHmmss();
        paramsMap.put(ParameterKeys.TIMESTAMP, timestamp);
        LogUtils.d("时间戳请求参数：" + timestamp);
        SoftApplication sf = new SoftApplication();
        sf.getToken();
        LogUtils.d("token::" + sf.getToken());
        if (sf.getToken() != null && !sf.getToken().equals("")) {
            paramsMap.put(ParameterKeys.TOKEN, sf.getToken());
        } else {
            paramsMap.put(ParameterKeys.TOKEN, "");
        }
        try {
            paramsMap.put(ParameterKeys.SIGN, getSign(biz, timestamp));
            //   LogUtils.d("sign戳请求参数：" + getSign(device,biz, timestamp));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static RetrofitUtils getInstance() {
        if (instance == null) {
            createApi();
        }
        return instance;
    }

    //-------------------------------------------请求内容----------------------------------------------

    /**
     * 获取一张图片
     *
     * @return
     */
    public static Observable getHomeData(/*Map<String,Object> params*/) {
      /*  Gson gson = new Gson();
        String s = gson.toJson(params);
        Map<String, Object> paramsMap = new HashMap<>();
        try {
//            Map<String, String> tempMap = new HashMap<String, String>();
//            tempMap.put("username", username);
//            tempMap.put("password", pwd);
//            tempMap.put("servicetypeid", service);
//            addParam(paramsMap,tempMap);
            Map<String, String> tempMap = new HashMap<String, String>();
            paramsMap.put("requestParams", s);

//            addParam(paramsMap, tempMap);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return api.home();
    }
    public static Observable getOrder(/*Map<String,Object> params*/) {
      /*  Gson gson = new Gson();
        String s = gson.toJson(params);
        Map<String, Object> paramsMap = new HashMap<>();
        try {
//            Map<String, String> tempMap = new HashMap<String, String>();
//            tempMap.put("username", username);
//            tempMap.put("password", pwd);
//            tempMap.put("servicetypeid", service);
//            addParam(paramsMap,tempMap);
            Map<String, String> tempMap = new HashMap<String, String>();
            paramsMap.put("requestParams", s);

//            addParam(paramsMap, tempMap);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return api.order();
    }


    /**
     * 登陆
     *
     * @param pwd
     * @return
     */
    public static Observable login(String username, String pwd, String service) {
        Map<String, Object> paramsMap = new HashMap<>();
        try {
            Map<String, String> tempMap = new HashMap<String, String>();
            tempMap.put("username", username);
            tempMap.put("password", pwd);
            tempMap.put("servicetypeid", service);
            addParam(paramsMap, tempMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return /*api.login(paramsMap)*/null;
    }

    /**
     * 校验验证码
     */
    public static Observable checkcapture(String mobile, String serviceid, String capture, String uid) {
        Map<String, Object> paramsMap = new HashMap<>();
        try {
            Map<String, String> tempMap = new HashMap<String, String>();
            tempMap.put("mobile", mobile);
            tempMap.put("servicetypeid", serviceid);
            tempMap.put("captcha", capture);
            tempMap.put("uid", uid);
            addParam(paramsMap, tempMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return /*api.checkcapture(paramsMap)*/null;
    }

    /**
     * 注册
     *
     * @return
     */
    public static Observable register(String mobile, String password, String servicetypeid, String captcha) {
        Map<String, Object> paramsMap = new HashMap<>();
        try {
            Map<String, String> tempMap = new HashMap<String, String>();
            tempMap.put("username", mobile);
            tempMap.put("password", password);
            tempMap.put("servicetypeid", servicetypeid);
            tempMap.put("captcha", captcha);
            addParam(paramsMap, tempMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return /*api.register(paramsMap)*/null;
    }
    /********************************* 用户信息 ***********************************************/
    /**
     * 获取用户信息
     */
    public static Observable getPersonInfo(String serviceType) {
        Map<String, Object> paramsMap = new HashMap<>();
        try {
            Map<String, String> tempMap = new HashMap<>();
            tempMap.put("serviceType", serviceType);
            addParam(paramsMap, tempMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return /*api.getPersonInfo(paramsMap)*/null;
    }

    /**
     * 修改头像
     */
    public static Observable updataPhoto(String photo) {
        Map<String, Object> paramsMap = new HashMap<>();
        RequestBody requestBody = null;
        try {
            Map<String, String> tempMap = new HashMap<String, String>();
            tempMap.put("servicetypeid", SharedPrefHelper.getInstance().getServicetype() + "");

            Gson gson = new Gson();
            String biz = gson.toJson(tempMap);


            LogUtils.d("biz请求参数：" + biz);
            String timestamp = DateUtil.getCurrentDateTimeyyyyMMddHHmmss();


            LogUtils.d("时间戳请求参数：" + timestamp);
            SoftApplication sf = new SoftApplication();
            String token = "";
            sf.getToken();
            LogUtils.d("token::" + sf.getToken());
            if (sf.getToken() != null && !sf.getToken().equals("")) {
                token = sf.getToken();
            }
            LogUtils.d("sign" + getSign(biz, timestamp));

            File file = new File(photo);
            LogUtils.d("photo" + file.length());
            requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart(ParameterKeys.BIZ, biz)
                    .addFormDataPart(ParameterKeys.TIMESTAMP, timestamp)
                    .addFormDataPart(ParameterKeys.TOKEN, token)
                    .addFormDataPart(ParameterKeys.SIGN, getSign(biz, timestamp))
                    .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("\"image/*\""), file))
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return /*api.upPhoto(requestBody)*/null;
    }
}
