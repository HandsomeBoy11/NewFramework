package com.helw.m.anew.framework.spfs;


import android.content.Context;
import android.content.SharedPreferences;

import com.helw.m.anew.framework.application.SoftApplication;
import com.helw.m.anew.framework.config.UserInfo;


public class SharedPrefHelper {
    /**
     * SharedPreferences的名字
     */
    private static final String SP_FILE_NAME = "APPLICATION_SP";
    private static SharedPrefHelper sharedPrefHelper = null;
    private static SharedPreferences sharedPreferences;
    /**
     * 经度
     */
    private static final String LONGITUDE = "LONGITUDE";
    /**
     * 纬度
     */
    private static final String LATITUDE = "LATITUDE";
    private static final String USER = "data";
    private static final String HELP = "help";

    public static synchronized SharedPrefHelper getInstance() {
        if (null == sharedPrefHelper) {
            sharedPrefHelper = new SharedPrefHelper();
        }
        return sharedPrefHelper;
    }

    private SharedPrefHelper() {
        sharedPreferences = SoftApplication.softApplication.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void setPhoneNumber(String phoneNumber) {
        sharedPreferences.edit().putString("phoneNumber", phoneNumber).commit();
    }

    public String getPhoneNumber() {
        return sharedPreferences.getString("phoneNumber", "");
    }

    public void setToken(String token) {
        sharedPreferences.edit().putString("token",token).commit();
    }

    public String getToken() {
        return sharedPreferences.getString("token","");
    }

    public void setPhoto(String photo) {
        sharedPreferences.edit().putString("photo",photo).commit();
    }

    public String getPhoto() {
        return sharedPreferences.getString("photo","");
    }

    public void setPassword(String password) {
        sharedPreferences.edit().putString("password", password).commit();
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }

    public void setRememberAccount(boolean bool) {
        sharedPreferences.edit().putBoolean("rememberAccount", bool).commit();
    }

    public boolean isRememberAccount() {
        return sharedPreferences.getBoolean("rememberAccount", false);
    }
    /**
     * 是否登录状态
     *
     * @param hasLogin
     */
    public void setHasLogin(boolean hasLogin) {
        sharedPreferences.edit().putBoolean("hasLogin", hasLogin).commit();
    }

    public boolean getHasLogin() {
        return sharedPreferences.getBoolean("hasLogin", false);
    }

    /**
     * 是否第一次
     *
     * @param isFirst
     */
    public void setIsFirst(boolean isFirst) {
        sharedPreferences.edit().putBoolean("isFirst", isFirst).commit();
    }

    public boolean getIsFirst() {
        return sharedPreferences.getBoolean("isFirst", true);
    }

    public void setUserInfo(Object userInfo) {
    }

    public UserInfo getUserInfo() {
        return null;
    }
  /*
  服务类型
    1维修人员端，2办公用品服务端，3订水服务端 4.会议室服务端
  * */
  public  void setServicetype(int servicetype){
     sharedPreferences.edit().putInt("serivcetype",servicetype).commit();
  }
  public  int  getServicetype(){
      return sharedPreferences.getInt("serivcetype",1);
  }
    /*
   姓名
   * */
    public  void setUserName(String name){
        sharedPreferences.edit().putString("userName",name).commit();
    }
    public String getUserName(){
        return sharedPreferences.getString("userName","");
    }
    /*
 真实电话
  * */
    public  void setRealPhone(String realPhone){
        sharedPreferences.edit().putString("realPhone",realPhone).commit();
    }
    public String getRealPhone(){
        return sharedPreferences.getString("realPhone","");
    }
}
