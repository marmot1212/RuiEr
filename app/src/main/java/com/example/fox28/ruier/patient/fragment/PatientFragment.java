package com.example.fox28.ruier.patient.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fox28.ruier.R;

/**
 * A simple {@link Fragment} subclass.
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
