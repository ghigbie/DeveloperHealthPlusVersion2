package com.geogehigbie.developerhealthplusversion2.activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.geogehigbie.developerhealthplusversion2.R;
import com.geogehigbie.developerhealthplusversion2.fragments.pre_exercsie_fragments.TimeChooserFragment;


public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        centerActionBar();
        setOnClickListener();
    }

    public void centerActionBar(){
        android.app.ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //this is a soft error
        getSupportActionBar().setCustomView(R.layout.actionbar);
    }

    public void setOnClickListener(){

        Button button = (Button) findViewById(R.id.improve);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent = new Intent(getApplicationContext(), TimeChooserFragment.class);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, new TimeChooserFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }
}
