package com.helw.m.anew.ui.main.activity.bean;

/**
 * Created by liuxiu on 2017/5/12.
 */

import com.helw.m.anew.framework.base.BaseResponse;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class HomeContent extends BaseResponse implements Serializable {

    public String datetime;
    public String errCode;
    public String errMsg;
    public String status;
    public List<Response> response;

    public class Response implements Serializable {
/*
        *
         * 内容*/

        public String postContent;
        public String updateTime;
        public String shareContent;
       /* *
         * 帖子的id*/

        public int postId;
        public int sectionId;
        public String insertTime;
    /*    *
         * 显示时间*/

        public String postTime;
        public String coverId;
        public int readNum;
       /* *
         * 图片  ，分割，可为空*/

        public String coverPicurl;
       /* *
         * title*/

        public String postName;
       /* *
         * 跳转详情   需要拼接SERVER_ADDR*/

        public String detailUrl;
        public int pointNum;
       /* *
         * 管家*/

        public String lastOperator;
        public List<OutLinkGoods> outLinkGoods;

        public class OutLinkGoods {


            @Override
            public String toString() {
                String s = "";
                Field[] arr = this.getClass().getFields();
                for (Field f : getClass().getFields()) {
                    try {
                        s += f.getName() + "=" + f.get(this) + "\n,";
                    } catch (Exception e) {
                    }
                }
                return getClass().getSimpleName() + "[" + (arr.length == 0 ? s : s.substring(0, s.length() - 1)) + "]";
            }
        }

        @Override
        public String toString() {
            String s = "";
            Field[] arr = this.getClass().getFields();
            for (Field f : getClass().getFields()) {
                try {
                    s += f.getName() + "=" + f.get(this) + "\n,";
                } catch (Exception e) {
                }
            }
            return getClass().getSimpleName() + "[" + (arr.length == 0 ? s : s.substring(0, s.length() - 1)) + "]";
        }
    }

    @Override
    public String toString() {
        String s = "";
        Field[] arr = this.getClass().getFields();
        for (Field f : getClass().getFields()) {
            try {
                s += f.getName() + "=" + f.get(this) + "\n,";
            } catch (Exception e) {
            }
        }
        return getClass().getSimpleName() + "[" + (arr.length == 0 ? s : s.substring(0, s.length() - 1)) + "]";
    }
}
