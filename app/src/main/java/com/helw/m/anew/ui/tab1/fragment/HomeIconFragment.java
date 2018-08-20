package com.helw.m.anew.ui.tab1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.helw.m.anew.R;
import com.helw.m.anew.framework.base.BaseFragment;
import com.helw.m.anew.framework.widget.NoSlidingGridView;
import com.helw.m.anew.ui.tab1.adapter.HomeIconAdapter;
import com.helw.m.anew.ui.utils.SpeechUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by user on 2018/8/9.
 */

public class HomeIconFragment extends BaseFragment {
    @BindView(R.id.nsgv_icon)
    NoSlidingGridView nsgvIcon;
    Unbinder unbinder;
    private List<String> names1=new ArrayList<>();
    private List<String> names2=new ArrayList<>();
    private List<Integer> icon1=new ArrayList<>();
    private List<Integer> icon2=new ArrayList<>();
    private int position;

    public static HomeIconFragment getInstance(String[] iconNames, int[] icons, int position) {
        HomeIconFragment fragment = new HomeIconFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("name",iconNames);
        bundle.putIntArray("icon",icons);
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_icon_home);
    }

    @Override
    public void initView(View v) {
        ButterKnife.bind(this, v);
        HomeIconAdapter homeIconAdapter = new HomeIconAdapter(softApplication);
        nsgvIcon.setAdapter(homeIconAdapter);
        Bundle arguments = getArguments();
        if(arguments!=null){
            String[] names = arguments.getStringArray("name");
            int[] icons = arguments.getIntArray("icon");
            for (int i = 0; i < names.length; i++) {
                if(i<8){
                    names1.add(names[i]);
                    icon1.add(icons[i]);
                }else{
                    names2.add(names[i]);
                    icon2.add(icons[i]);
                }
            }
            position = arguments.getInt("position");
            if(position ==0){
                homeIconAdapter.setData(names1,icon1);
            }else if(position ==1){
                homeIconAdapter.setData(names2,icon2);
            }
        }
        nsgvIcon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(position==0){
                    Toast.makeText(softApplication, names1.get(i), Toast.LENGTH_SHORT).show();
                    SpeechUtils.getInstance(softApplication).speakText(names1.get(i));
                }else if(position==1){
                    Toast.makeText(softApplication, names2.get(i), Toast.LENGTH_SHORT).show();
                    SpeechUtils.getInstance(softApplication).speakText(names2.get(i));
                }
            }
        });
    }

}
