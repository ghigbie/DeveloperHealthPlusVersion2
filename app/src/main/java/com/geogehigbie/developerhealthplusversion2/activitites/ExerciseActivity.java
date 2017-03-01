package com.geogehigbie.developerhealthplusversion2.activitites;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.geogehigbie.developerhealthplusversion2.R;
import com.geogehigbie.developerhealthplusversion2.fragments.exercise_fragments.ExerciseChooserFragment;

/**
 * Created by georgehigbie on 3/1/17.
 */

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        centerActionBar();
        loadFragment();
    }

    public void centerActionBar(){
        android.app.ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //this is a soft error
        getSupportActionBar().setCustomView(R.layout.actionbar);
    }

    public void loadFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_exercises, new ExerciseChooserFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
