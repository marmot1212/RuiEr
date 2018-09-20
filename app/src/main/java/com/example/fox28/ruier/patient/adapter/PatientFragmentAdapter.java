package com.example.fox28.ruier.patient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @Description: Adapter，在PatientFragment中使用
 * @Company: China Citic Bank
 * @Author: Scorpion
 * @Tags:
 */
public class PatientFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mList;


    public PatientFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }
}
