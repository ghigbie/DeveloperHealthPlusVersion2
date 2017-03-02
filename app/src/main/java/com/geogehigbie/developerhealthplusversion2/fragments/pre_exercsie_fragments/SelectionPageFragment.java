package com.geogehigbie.developerhealthplusversion2.fragments.pre_exercsie_fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.geogehigbie.developerhealthplusversion2.R;


public class SelectionPageFragment extends Fragment {

    private View view;
    private int notificationTime;
    private boolean isFirstTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_selection_page, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            notificationTime = bundle.getInt("notificationTime", notificationTime);
        }

        populateValues();

        setOnClickListeners();


        return view;
    }

    public void populateValues(){
        TextView minutesSetting = (TextView) view.findViewById(R.id.int_time);
        String minuteSettingString = Integer.toString(notificationTime);
        minutesSetting.setText(minuteSettingString);

    }

    public void setOnClickListeners(){
        Button button = (Button) view.findViewById(R.id.set_up_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //going to set the background service
                setAndGetSharedPreferences();
                setBackgroundService();

                //close the app
                getActivity().finish();
            }
        });
    }

    public void setAndGetSharedPreferences() {
        isFirstTime = false;



        SharedPreferences notificationTimeSetter = getActivity().getApplicationContext().getSharedPreferences("timeNotificationFile", 0);


        SharedPreferences.Editor editor = notificationTimeSetter.edit();
        editor.putInt("notificationTime", notificationTime);
        editor.putBoolean("isFirstTime", isFirstTime);
        editor.commit();


    }

    public void setBackgroundService(){

    }




}
