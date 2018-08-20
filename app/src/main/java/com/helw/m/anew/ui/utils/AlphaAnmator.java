package com.helw.m.anew.ui.utils;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by user on 2018/8/10.
 */

public class AlphaAnmator {
    public static ObjectAnimator loadAnimator(View view){
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0.6f, 1);
        return alpha;
    }

}
