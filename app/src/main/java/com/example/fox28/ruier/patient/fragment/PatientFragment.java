package com.example.fox28.ruier.patient.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fox28.ruier.R;

/**
 * @Description: 患者fragment，主界面的一级界面
 * @Company: China Citic Bank
 * @Author: Scorpion
 * @Date: 2018/9/19 22:22
 * @Tags:
 */
public class PatientFragment extends Fragment {


    public PatientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.p_fragment_patient, container, false);
    }

}
