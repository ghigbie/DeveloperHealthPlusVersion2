package com.geogehigbie.developerhealthplusversion2.fragments.pre_exercsie_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.geogehigbie.developerhealthplusversion2.R;


public class DayChooserFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day_chooser, container, false);


        return view;
    }


    public void setOnClickListener(){



        Button button = (Button) view.findViewById(R.id.next_button_day_Chooser);




    }


}
