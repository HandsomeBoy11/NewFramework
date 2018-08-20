package com.helw.m.anew.framework.widget;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.application.SoftApplication;
import com.helw.m.anew.ui.main.activity.MainActivity;
import com.helw.m.anew.ui.tab1.activity.AddressActivity;
import com.helw.m.anew.ui.tab1.containts.Containts;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
//import com.uuzuche.lib_zxing.activity.CaptureActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 2018/8/8.
 */

public class HomeTitle extends LinearLayout implements Containts {

    private  Context mContext;
    private  Context mAppContext;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.iv_scanner)
    ImageView ivScanner;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    private LayoutInflater inflater;
    private Activity mActivity;

    public HomeTitle(Context context) {
        this(context, null);
    }

    public HomeTitle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public HomeTitle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        if(context instanceof Activity){
            mActivity = ((Activity) context);
        }
        mAppContext=mContext.getApplicationContext();
        inflater = LayoutInflater.from(context);
        initView();
    }

    private void initView() {
        View view = inflater.inflate(R.layout.home_title, this);
        ButterKnife.bind(this, view);

    }
    public void setAddress(String address){
        tvAddress.setText(address);
    }

    @OnClick({R.id.tv_address, R.id.ll_search,R.id.et_search, R.id.iv_scanner, R.id.iv_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_address:
                if(listener!=null){
                    listener.address();
                }
                Toast.makeText(mAppContext, "定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_search:
                Toast.makeText(mAppContext, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.et_search:
                etSearch.setFocusable(true);
                etSearch.setCursorVisible(true);
                break;
            case R.id.iv_scanner://打开二维码扫描
                openScanner();
                break;
            case R.id.iv_message:
                Toast.makeText(mAppContext, "消息", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private ScannerClickListen listener;

    public void setListener(ScannerClickListen listener) {
        this.listener = listener;
    }

    public interface ScannerClickListen{
        void onClick();
        void address();
    }
    /**
     *打开二维码扫描
     */
    public void openScanner() {

        Acp.getInstance(SoftApplication.softApplication).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.READ_PHONE_STATE
                                , Manifest.permission.CAMERA)
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {
                        if(listener!=null){
                            listener.onClick();
                        }
//                        Toast.makeText(mAppContext, "二维码", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onDenied(List<String> permissions) {
                        Toast.makeText(SoftApplication.softApplication, permissions.toString() + "权限拒绝", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
