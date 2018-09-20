package com.example.fox28.ruier.home.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.fox28.ruier.R;
import com.example.fox28.ruier.home.fragment.HomeFragment;
import com.example.fox28.ruier.home.fragment.MineFragment;
import com.example.fox28.ruier.patient.fragment.PatientFragment;


/**
 * @Description:    主界面，管理3个fragment
 * @Company: China Citic Bank
 * @Author: Scorpion
 * @Date: 2018/9/19 22:22
 * @Tags:
 */
public class MainActivity extends AppCompatActivity {

    private Fragment[] mFragments;      // fragment数组
    private int mCurrentIndex;          // Fragment索引，当前下标
    private int mTargetIndex;           // Fragment索引，目标下标

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        StatusBarUtils.setStatusBarColor(this, R.color.status_bar_color);
        initFragment();
    }

    private void initFragment() {
        mFragments = new Fragment[3];
        HomeFragment homeFragment = new HomeFragment();
        mFragments[0] = homeFragment;
        PatientFragment patientFragment = new PatientFragment();
        mFragments[1] = patientFragment;
        MineFragment mineFragment = new MineFragment();
        mFragments[2] = mineFragment;

        //初始化Fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mFragments[0])
                .add(R.id.fragment_container, mFragments[1])
                .add(R.id.fragment_container, mFragments[2])
                .hide(mFragments[2])
                .hide(mFragments[1])
                .show(mFragments[0])
                .commit();
    }

    /**
     * 底部按钮的监听事件
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_clinic:
                mTargetIndex = 0;
                break;
            case R.id.rb_patient:
                mTargetIndex = 1;
                break;
            case R.id.rb_mine:
                mTargetIndex = 2;
                break;
        }
        updateFragment();
    }

    /**
     * 切换fragment
     */
    private void updateFragment() {
        if (mCurrentIndex != mTargetIndex) { // 页面发生变化
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // 隐藏当前页
            transaction.hide(mFragments[mCurrentIndex]);
            // 显示目标页
            if (!mFragments[mTargetIndex].isAdded()) {
                transaction.add(R.id.fragment_container, mFragments[mTargetIndex]);
            }
            transaction.show(mFragments[mTargetIndex]).commit();
            // 更新fragment索引
            mCurrentIndex = mTargetIndex;
        }
    }
}
