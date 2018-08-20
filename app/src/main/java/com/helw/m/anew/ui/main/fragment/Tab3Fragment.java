package com.helw.m.anew.ui.main.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.helw.m.anew.R;
import com.helw.m.anew.framework.base.MvpSimpleFragment;
import com.helw.m.anew.ui.main.presenter.Tab3Presenter;
import com.helw.m.anew.ui.main.view.Tab3View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by hh on 2016/5/18.
 */
public class Tab3Fragment extends MvpSimpleFragment<Tab3View, Tab3Presenter> implements Tab3View {


    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        //setContentView(R.layout.f_tab3);
    }

    @Override
    public void initView(View v) {
//        EventBus.getDefault().register(this);
//        getPresenter().getData(SharedPrefHelper.getInstance().getServicetype() + "");
    }

//    @OnClick({R.id.iv_header, R.id.tx_name, R.id.tx_dis, R.id.rl_order, R.id.rl_comment, R.id.rl_wallet, R.id.rl_sys})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.iv_header:
//                UIManager.turnToAct(getActivity(), PersonInfoActivity.class);
//                break;
//            case R.id.tx_name:
//                /*Bundle bundle1 = new Bundle();
//                bundle1.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
//                bundle1.putString(EaseConstant.EXTRA_USER_ID, "8");
//                bundle1.putString(EaseConstant.EXTRA_USER_NUMBER, "1000000008");
//                bundle1.putString(EaseConstant.EXTRA_USER_NAME, "王大仙");
//                bundle1.putBoolean(EaseConstant.EXTRA_CLEAR, true);
//                UIManager.turnToAct(getActivity(), ChatActivity.class, bundle1);*/
//                break;
//            case R.id.tx_dis:
//
//                break;
//            case R.id.rl_order:
//                ((MainActivity) getActivity()).refresh();
//                break;
//            case R.id.rl_comment:
//                UIManager.turnToAct(getActivity(), MyEvaluateActivity.class);
//                break;
//            case R.id.rl_wallet:
//                UIManager.turnToAct(getActivity(), MyWalletActivity.class);
//                break;
//            case R.id.rl_sys:
//                UIManager.turnToAct(getActivity(), SysSettingActivity.class);
//                break;
//        }
//    }

    @Override
    public Tab3Presenter createPresenter() {
        return new Tab3Presenter();
    }

}
