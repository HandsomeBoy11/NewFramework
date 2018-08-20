package com.helw.m.anew.ui.tab1.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.View;

import com.helw.m.anew.R;

import mvp.cn.util.DensityUtil;

/**
 * Created by user on 2018/8/16.
 */

public class SimpleItemDecoration extends RecyclerView.ItemDecoration {

    private int wight;
    private int height;
    private int item_height;
    private int item_padding;
    private Paint paint;
    public SimpleItemDecoration(Context context,int color,int itemHeightDP,int paddingDP) {
        wight=context.getResources().getDisplayMetrics().widthPixels;
        height=context.getResources().getDisplayMetrics().heightPixels;
        paint=new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(context.getResources().getColor(R.color.white_light));

//        item_height=DensityUtil.dip2px(context, 1);
        item_height=1;
        item_padding= DensityUtil.dip2px(context, 10);
    }


    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int count=parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View view=parent.getChildAt(i);
            int top=view.getBottom();
            int bottom=top+item_height;
            c.drawRect(0,top,wight,bottom,paint);

        }
    }



    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom=item_height;
    }
}
