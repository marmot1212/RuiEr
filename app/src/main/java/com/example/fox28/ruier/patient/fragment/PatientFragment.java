package com.example.fox28.ruier.patient.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.fox28.ruier.R;
import com.example.fox28.ruier.home.fragment.HomeFragment;
import com.example.fox28.ruier.patient.adapter.PatientFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description: 患者fragment，主界面的一级界面
 * @Company: China Citic Bank
 * @Author: Scorpion
 * @Date: 2018/9/19 22:22
 * @Tags:
 */
public class PatientFragment extends Fragment {


    @BindView(R.id.rg_titleBar)
    RadioGroup mRgTitleBar;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    Unbinder unbinder;

    private List<Fragment> mList;           // ViewPager的数据集
    private PatientFragmentAdapter  mAdapter;   // Fragment适配器

    public PatientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.p_fragment_patient, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initFragment();
        initListener();
        return inflate;
    }

    /**
     * 设置监听事件
     */
    private void initListener() {
        // 滑动ViewPager，同步顶部RadioGroup的状态
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton)mRgTitleBar.getChildAt(position)).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRgTitleBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.e("main", "开始监听事件");
                switch (checkedId) {
                    case R.id.rb_chat:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_patient_manager:
                        mViewPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    /**
     * 初始化Fragment集合的数据，并且绑定Adapter
     */
    private void initFragment() {
        mList = new ArrayList<>();
        mList.add(new HomeFragment());
        mList.add(new PatientManagerFragment());
        mAdapter = new PatientFragmentAdapter(getActivity().getSupportFragmentManager(), mList);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(1);

        ((RadioButton) mRgTitleBar.getChildAt(1)).setChecked(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
