package com.helw.m.anew.ui.tab1.utils;

import com.helw.m.anew.framework.utils.LogUtils;
import com.helw.m.anew.framework.utils.PinyinUtil;
import com.helw.m.anew.ui.tab1.AddressBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 2018/8/16.
 */

public class CommentUtils {
    private static CommentUtils instance;
    private CommentUtils(){}
    public static CommentUtils getInstance(){
        if(instance==null){
            synchronized (CommentUtils.class){
                if(instance==null){
                    instance=new CommentUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 排序
     * @param addressBeans
     * @return
     */
    public List<String> sort(List<String> addressBeans){
        CityComparator cityComparator = new CityComparator();
        Collections.sort(addressBeans,cityComparator);
        return addressBeans;
    }

    /**
     * 获得每个首字母
     * @param addressBeans
     * @return
     */
    public List<String> getSortChar(List<String> addressBeans){
        List<String> chars=new ArrayList();
        PinyinUtil instance =null;
        if(instance==null){
            instance= PinyinUtil.getInstance();
        }
        for (String c:addressBeans) {
            String pinyin = instance.getStringPinyin(c);
            chars.add(pinyin.substring(0,1));
        }
        return chars;
    }

    /**
     * 获得没有重复的首字母
     * @param addressBeans
     * @return
     */
    public List<String> getChar(List<String> addressBeans){
        List<String> chars=new ArrayList();

        for (String c:addressBeans) {
            if(!chars.contains(c))
            chars.add(c);
        }
        return chars;
    }

    /**
     * sort by a-z
     */
    private class CityComparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            PinyinUtil instance =null;
            if(instance==null){
               instance= PinyinUtil.getInstance();
            }
            String aPinyin =instance.getStringPinyin(lhs);
            String bPinyin = instance.getStringPinyin(rhs);
            String a = aPinyin.substring(0,1);
            String b = bPinyin.substring(0,1);
            LogUtils.i("获取到的首字母："+a+"    "+b);
            return a.compareTo(b);
        }
    }
    private class CharComparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            return lhs.compareTo(rhs);
        }
    }
}
