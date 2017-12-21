package com.nyc.android_44_unit_04_mid_unit_assessment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyc.android_44_unit_04_mid_unit_assessment.R;
import com.nyc.android_44_unit_04_mid_unit_assessment.fragments.innerFragments.BottomFragment;
import com.nyc.android_44_unit_04_mid_unit_assessment.fragments.innerFragments.TopFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_display, container, false);

        BottomFragment bottomFragment = new BottomFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottom_container, bottomFragment);
        fragmentTransaction.commit();




        return rootView;
    }

}
