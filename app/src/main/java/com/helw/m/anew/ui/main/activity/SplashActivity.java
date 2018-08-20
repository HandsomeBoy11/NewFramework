package com.helw.m.anew.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.application.SoftApplication;
import com.helw.m.anew.framework.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.iv_splash)
    ImageView ivSplash;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
    }


    public void initView() {
        Animation animation = AnimationUtils.loadAnimation(SoftApplication.softApplication, R.anim.splash);
        ivSplash.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                goMain();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void goMain(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

}
