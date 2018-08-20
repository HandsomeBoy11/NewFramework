package com.helw.m.anew.ui.tab1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.application.SoftApplication;
import com.helw.m.anew.framework.base.BaseActivity;
import com.helw.m.anew.framework.utils.LogUtils;
import com.helw.m.anew.framework.widget.TitleBar;
import com.helw.m.anew.ui.tab1.AddressBean;
import com.helw.m.anew.ui.tab1.adapter.AddressAdapter;
import com.helw.m.anew.ui.tab1.utils.CommentUtils;
import com.helw.m.anew.ui.tab1.utils.SectionItemDecoration;
import com.helw.m.anew.ui.tab1.utils.SimpleItemDecoration;
import com.helw.m.anew.ui.tab1.weight.SideIndexBar;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends BaseActivity {

    @BindView(R.id.address_title)
    TitleBar addressTitle;
    @BindView(R.id.bt_back)
    Button btBack;
    @BindView(R.id.rv_address)
    RecyclerView rvAddress;
    @BindView(R.id.sideIndexBar)
    SideIndexBar sideIndexBar;
    private AddressAdapter addressAdapter;

    /**
     * 目标项是否在最后一个可见项之后
     */
    private boolean mShouldScroll;
    /**
     * 记录目标项位置
     */
    private int mToPosition;

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_address);
    }

    @Override
    public  void initView() {
        ButterKnife.bind(this);
        addressTitle.setBack(true);
        final String[] addressNames = getResources().getStringArray(R.array.address_name);
        List<String> addressList= Arrays.asList(addressNames);
        final List<String> sort = CommentUtils.getInstance().sort(addressList);//获得的地址数据
        final List<String> firstChar = CommentUtils.getInstance().getSortChar(sort);//获得所有首字母
        List<String> aChar = CommentUtils.getInstance().getChar(firstChar);
        LogUtils.i("aChar    "+aChar.size());
//        sideIndexBar.setChar(aChar);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(softApplication,1);
        rvAddress.setLayoutManager(gridLayoutManager);
        addressAdapter = new AddressAdapter();
        rvAddress.setAdapter(addressAdapter);
        addressAdapter.setData(sort);
        SectionItemDecoration sectionItemDecoration = new SectionItemDecoration(softApplication, firstChar);
        int color = getResources().getColor(R.color.white_light);
        SimpleItemDecoration simpleItemDecoration =
                new SimpleItemDecoration(softApplication,color,30,10);
        rvAddress.addItemDecoration(sectionItemDecoration);
        rvAddress.addItemDecoration(simpleItemDecoration);

        addressAdapter.setOnItemClickListener(new AddressAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("address",sort.get(position));
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        sideIndexBar.setOnIndexChangedListener(new SideIndexBar.OnIndexTouchedChangedListener() {
            @Override
            public void onIndexChanged(String index, int position) {
                LogUtils.i("打印   "+firstChar.size()+"      "+index);
                for (int i = 0; i < firstChar.size(); i++) {
                    if(index.equalsIgnoreCase(firstChar.get(i))){
                        if(i==0){
                            smoothMoveToPosition(rvAddress,i);
                        }else{
                            smoothMoveToPosition(rvAddress,i-1);
                        }

                        break;
                    }
                }
            }
        });


    }

    @OnClick(R.id.bt_back)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.putExtra("address", "address");
        setResult(RESULT_OK, intent);
        finish();
    }
    /**
     * 滑动到指定位置
     *
     * @param mRecyclerView
     * @param position
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));

        if (position < firstItem) {
            // 如果跳转位置在第一个可见位置之前，就smoothScrollToPosition可以直接跳转
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 跳转位置在第一个可见项之后，最后一个可见项之前
            // smoothScrollToPosition根本不会动，此时调用smoothScrollBy来滑动到指定位置
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 如果要跳转的位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }
}
