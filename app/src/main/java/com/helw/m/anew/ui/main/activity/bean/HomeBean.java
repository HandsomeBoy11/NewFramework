package com.helw.m.anew.ui.main.activity.bean;

import com.helw.m.anew.framework.base.BaseResponse;

import java.util.List;

/**
 * Created by user on 2018/7/25.
 */

public class HomeBean  extends BaseResponse{


    private List<CategorieListBean> categorieList;
    private List<NearbySellerListBean> nearbySellerList;
    private List<OtherSellerListBean> otherSellerList;
    private List<PromotionListBean> promotionList;

    public List<CategorieListBean> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<CategorieListBean> categorieList) {
        this.categorieList = categorieList;
    }

    public List<NearbySellerListBean> getNearbySellerList() {
        return nearbySellerList;
    }

    public void setNearbySellerList(List<NearbySellerListBean> nearbySellerList) {
        this.nearbySellerList = nearbySellerList;
    }

    public List<OtherSellerListBean> getOtherSellerList() {
        return otherSellerList;
    }

    public void setOtherSellerList(List<OtherSellerListBean> otherSellerList) {
        this.otherSellerList = otherSellerList;
    }

    public List<PromotionListBean> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<PromotionListBean> promotionList) {
        this.promotionList = promotionList;
    }

    public static class CategorieListBean {
        /**
         * id : 1
         * name : 李先生牛肉面
         * pic : http://192.168.1.146:8080/TakeoutService/imgs/category/1.png
         */

        private int id;
        private String name;
        private String pic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }

    public static class NearbySellerListBean {
        /**
         * activityList : []
         * deliveryFee : 4
         * distance : 200米/33分钟
         * ensure :
         * icon : http://192.168.1.146:8080/TakeoutService/imgs/seller/0.jpg
         * id : 0
         * invoice :
         * name : 附近第0家分店
         * pic :
         * recentVisit :
         * sale : 月售99份
         * score : 5
         * sendPrice : 20
         * time :
         */

        private String deliveryFee;
        private String distance;
        private String ensure;
        private String icon;
        private int id;
        private String invoice;
        private String name;
        private String pic;
        private String recentVisit;
        private String sale;
        private String score;
        private String sendPrice;
        private String time;
        private List<?> activityList;

        public String getDeliveryFee() {
            return deliveryFee;
        }

        public void setDeliveryFee(String deliveryFee) {
            this.deliveryFee = deliveryFee;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getEnsure() {
            return ensure;
        }

        public void setEnsure(String ensure) {
            this.ensure = ensure;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInvoice() {
            return invoice;
        }

        public void setInvoice(String invoice) {
            this.invoice = invoice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getRecentVisit() {
            return recentVisit;
        }

        public void setRecentVisit(String recentVisit) {
            this.recentVisit = recentVisit;
        }

        public String getSale() {
            return sale;
        }

        public void setSale(String sale) {
            this.sale = sale;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getSendPrice() {
            return sendPrice;
        }

        public void setSendPrice(String sendPrice) {
            this.sendPrice = sendPrice;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<?> getActivityList() {
            return activityList;
        }

        public void setActivityList(List<?> activityList) {
            this.activityList = activityList;
        }
    }

    public static class OtherSellerListBean {
        /**
         * activityList : []
         * deliveryFee : 6
         * distance : 996米/50分钟
         * ensure :
         * icon : http://192.168.1.146:8080/TakeoutService/imgs/seller/0.jpg
         * id : 0
         * invoice :
         * name : 其他第0家分店
         * pic :
         * recentVisit :
         * sale : 月售8份
         * score : 4
         * sendPrice : 30
         * time :
         */

        private String deliveryFee;
        private String distance;
        private String ensure;
        private String icon;
        private int id;
        private String invoice;
        private String name;
        private String pic;
        private String recentVisit;
        private String sale;
        private String score;
        private String sendPrice;
        private String time;
        private List<?> activityList;

        public String getDeliveryFee() {
            return deliveryFee;
        }

        public void setDeliveryFee(String deliveryFee) {
            this.deliveryFee = deliveryFee;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getEnsure() {
            return ensure;
        }

        public void setEnsure(String ensure) {
            this.ensure = ensure;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInvoice() {
            return invoice;
        }

        public void setInvoice(String invoice) {
            this.invoice = invoice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getRecentVisit() {
            return recentVisit;
        }

        public void setRecentVisit(String recentVisit) {
            this.recentVisit = recentVisit;
        }

        public String getSale() {
            return sale;
        }

        public void setSale(String sale) {
            this.sale = sale;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getSendPrice() {
            return sendPrice;
        }

        public void setSendPrice(String sendPrice) {
            this.sendPrice = sendPrice;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<?> getActivityList() {
            return activityList;
        }

        public void setActivityList(List<?> activityList) {
            this.activityList = activityList;
        }
    }

    public static class PromotionListBean {
        /**
         * id : 1
         * info : 促销信息1
         * pic : http://192.168.1.146:8080/TakeoutService/imgs/promotion/1.jpg
         */

        private int id;
        private String info;
        private String pic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
