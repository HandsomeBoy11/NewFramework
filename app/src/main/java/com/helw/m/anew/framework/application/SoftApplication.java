package com.helw.m.anew.framework.application;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDex;
import android.util.Log;
import com.google.gson.Gson;
import com.helw.m.anew.framework.config.AppConfig;
import com.helw.m.anew.framework.config.AppInfo;
import com.helw.m.anew.framework.config.UserInfo;
import com.helw.m.anew.framework.spfs.SharedPrefHelper;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
//import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mvp.cn.common.QuickApplication;
import mvp.cn.util.DateUtil;
import mvp.cn.util.NetUtil;
import mvp.cn.util.lib_zxing.activity.ZXingLibrary;


public class SoftApplication extends QuickApplication {
    /**
     * 存放活动状态的(未被销毁)的Activity列表
     */
    public static List<Activity> unDestroyActivityList = new ArrayList<Activity>();
    public static SoftApplication softApplication;
    private static AppInfo appInfo;
    private static UserInfo userInfo ;
    public static boolean isLogin;// 判断是否已经登录
    private static String token = "";
    private static int authStatus;
    private static int serviceId;            // 用户的服务类型Id;

    private double longitude;
    private double latitude;
    private RefWatcher refWatcher;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        /*if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);*/
        ZXingLibrary.initDisplayOpinion(this);
        softApplication = this;
        MultiDex.install(this);
        refWatcher =  LeakCanary.install(this);

        // 获取用户的服务ID
        getLoginState();


        /*initIM();
        EMClient.getInstance().init(this,new EMOptions());*/
//        appInfo = initAppInfo();

//		CrashHandler catchHandler = CrashHandler.getInstance();
//      catchHandler.init(getApplicationContext());
        //腾讯 bugly:账号：qq@cm-2.cn   已绑定QQ号码:3419836168  密码：yunyin@cm2
//		CrashReport.initCrashReport(getApplicationContext(), "d58a02c7f5", true);

        //极光推送
//		JPushInterface.setDebugMode(true);
//		JPushInterface.init(this);

    }

    private void initIM() {

        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
// 如果APP启用了远程的service，此application:onCreate会被调用2次
// 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
// 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回

        if (processAppName == null ||!processAppName.equalsIgnoreCase(this.getPackageName())) {
            Log.e("111", "enter the service process!");

            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }

    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }

    /**
     * leak检测内存泄露
     * @return
     */
    @Override
    public RefWatcher getRefWatcher() {
        return refWatcher;
    }

    /**
     *  获取用户信息,判断登录状态
     */
    public void getLoginState() {
        boolean hasLogin = SharedPrefHelper.getInstance().getHasLogin();
        if (hasLogin) {
            isLogin = true;
            token = SharedPrefHelper.getInstance().getToken();
        }
    }

    /**
     * 实例化AppInfo
     */

    private AppInfo initAppInfo() {
        AppInfo appInfo = AppConfig.getAppConfigInfo(softApplication);
        appInfo.imei = NetUtil.getIMEI(getApplicationContext());
        appInfo.imsi = NetUtil.getIMSI(getApplicationContext()) == null ? "" : NetUtil.getIMSI(getApplicationContext());
        appInfo.osVersion = getOSVersion();
        appInfo.appVersionCode = getAppVersionCode();
        return appInfo;
    }

    /**
     * 得到系统的版本号
     *
     * @return
     */
    public String getOSVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 得到应用的版本号
     *
     * @return
     */
    public int getAppVersionCode() {
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        int versionCode = 0;
        try {
            packInfo = packageManager.getPackageInfo(getPackageName(), 0);
            versionCode = packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 得到应用的版本号
     *
     * @return
     */
    public String getAppVersionName() {
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        String versionCode = "";
        try {
            packInfo = packageManager.getPackageInfo(getPackageName(), 0);
            versionCode = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取Assert文件夹中的配置文件信息
     *
     * @return
     */
    public AppInfo getAppInfo() {
        return appInfo;
    }

    public String getFrom() {
        return appInfo == null ? "" : appInfo.os;
    }

    public String getApiUser() {
        return appInfo == null ? "" : appInfo.api_user;
    }

    public String getApiPassword() {
        return appInfo == null ? "" : appInfo.api_pwd;
    }

    /**
     * 得到请求头JsonObject
     *
     * @return
     */
    public String getAuthJsonObject(String jsonString) {
        try {
            String timeStamp = DateUtil.getCurrentDateTimeyyyyMMddHHmmss();
            Map<String,Object> authJsonObject = new HashMap<>();
            authJsonObject.put("app_key", appInfo.appKey);
            authJsonObject.put("imei", appInfo.imei);
            authJsonObject.put("os", appInfo.os);
            authJsonObject.put("os_version", appInfo.osVersion);
            authJsonObject.put("app_version", appInfo.appVersionCode);
//            authJsonObject.put("source_id", appInfo.sourceId);
//            authJsonObject.put("ver", appInfo.ver);
            authJsonObject.put("uid", isLogin ? userInfo.uid : "");
            authJsonObject.put("time_stamp", timeStamp);
//            authJsonObject.put("crc", CrcUtil.getCrc(timeStamp, appInfo.imei, (isLogin ? userInfo.uid : appInfo.uid), (isLogin ? passwordWithMd5 : CrcUtil.MD5(appInfo.crc)), jsonString));
//            authJsonObject.put("token", getToken(timeStamp));
            return new Gson().toJson(authJsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 退出应用
     */
    public void quit() {
        for (Activity activity : unDestroyActivityList) {
            if (null != activity) {
                activity.finish();
            }
        }
        unDestroyActivityList.clear();
        logout();
    }

    /**
     * 注销帐号
     */
    public void logout() {
        /**
         * 退出登录,清空数据
         */
        userInfo = null;
        isLogin = false;
        SharedPrefHelper.getInstance().setUserInfo(null);
    }

    /**
     * 保存登录成功之后用户的信息
     *
     * @param result
     */
    public void setUserInfo(UserInfo result) {
        userInfo = result;
        if (result != null) {
            isLogin = true;
        }
    }

    public boolean isLogin() {
        return isLogin;
    }

    /**
     * 获取用户的信息
     *
     * @return
     */
    public UserInfo getUserInfo() {
        if (userInfo == null) {
            userInfo = SharedPrefHelper.getInstance().getUserInfo();
        }
        return userInfo;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String tokens) {
        token = tokens;
    }

    public String getServiceId() {
        return String.valueOf(serviceId);
    }

    public void setServiceId(int serviceId){
        this.serviceId = serviceId;
    }

    /**
     * 关闭出了登录页面的其他所有页面
     */
//    public void finishOther() {
//        for (int i = 0; i < unDestroyActivityList.size(); i++) {
//            if (unDestroyActivityList.get(i) instanceof LoginActivity) {
//
//            } else {
//                unDestroyActivityList.get(i).finish();
//                unDestroyActivityList.remove(i);
//                i--;
//            }
//        }
//    }
}

