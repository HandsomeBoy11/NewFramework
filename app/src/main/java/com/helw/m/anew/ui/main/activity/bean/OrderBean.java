package com.helw.m.anew.ui.main.activity.bean;

import com.helw.m.anew.framework.base.BaseResponse;

/**
 * Created by user on 2018/7/25.
 */

public class OrderBean extends BaseResponse {

    /**
     * code : 0
     * data : [{"id":"0001","type":"20","seller":{"id":0,"name":"一品木桶饭"},"rider":{"id":1,"name":"江西骑士","phone":"13888888888"},"goodsInfos":[{"id":0,"name":"土豆炒牛肉","monthSaleNum":0,"bargainPrice":false,"isNew":false,"newPrice":"10.00","oldPrice":0,"sellerId":0},{"id":0,"name":"湘味腊肉饭","monthSaleNum":0,"bargainPrice":false,"isNew":false,"newPrice":"10.00","oldPrice":0,"sellerId":0}],"distribution":{"type":"yes","des":"湘赣木桶饭，好吃到爆"},"detail":{"username":"用户250","phone":"18575627762","address":"留仙大道999号","pay":"微信支付","time":"2016-8-8 18:00"}},{"id":"0002","type":"20","seller":{"id":0,"name":"西安老蔡家面庄"},"rider":{"id":1,"name":"西安骑士","phone":"13755556666"},"goodsInfos":[{"id":0,"name":"三鲜牛肉米粉","monthSaleNum":0,"bargainPrice":false,"isNew":false,"newPrice":"10.00","oldPrice":0,"sellerId":0},{"id":0,"name":"纯廋肉夹馍","monthSaleNum":0,"bargainPrice":false,"isNew":false,"newPrice":"10.00","oldPrice":0,"sellerId":0}],"distribution":{"type":"yes","des":"地道陕西面食"},"detail":{"username":"用户180","phone":"18575627762","address":"留仙大道999号","pay":"微信支付","time":"2016-8-8 18:00"}}]
     */

    private String code;
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
