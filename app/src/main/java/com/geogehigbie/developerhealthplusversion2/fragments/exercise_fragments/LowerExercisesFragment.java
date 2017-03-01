package com.geogehigbie.developerhealthplusversion2.fragments.exercise_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geogehigbie.developerhealthplusversion2.R;


public class LowerExercisesFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lower_exercises, container, false);




        return view;
    }

}
