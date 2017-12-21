package com.nyc.android_44_unit_04_mid_unit_assessment.fragments.innerFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyc.android_44_unit_04_mid_unit_assessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    private TextView author,title,year;


    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_top, container, false);
        author = rootView.findViewById(R.id.author);
        title =rootView.findViewById(R.id.title);
        year = rootView.findViewById(R.id.year);

        Bundle bundle = getArguments();
        author.setText(bundle.getString("author"));
        title.setText(bundle.getString("title"));
        year.setText(String.valueOf(bundle.getInt("year")));



        return rootView;
    }

}
