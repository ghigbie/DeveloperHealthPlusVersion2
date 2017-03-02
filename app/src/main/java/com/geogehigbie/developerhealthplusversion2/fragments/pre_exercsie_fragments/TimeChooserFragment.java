package com.geogehigbie.developerhealthplusversion2.fragments.pre_exercsie_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.geogehigbie.developerhealthplusversion2.R;

import java.util.ArrayList;

public class TimeChooserFragment extends Fragment {

    private View view;
    private int notificationTime; //this is the time that will be used to set the notification time


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time_chooser, container, false);

        setSpinnerContent();
        // addOnClickListener();

        return view;
    }

    public void setSpinnerContent() {

        notificationTime = 0;

        final String pleaseChoose = "Please Select a Time";
        final String time30String = "30 minutes";
        final String time45String = "45 minutes";
        final String time60String = "60 minutes";
        final String time75String = "1 hour & 15 minutes";
        final String time90String = "1 hour & 30 minutes";
        final String time105String = "1 hour & 45 minutes";
        final String time120String = "2 hours";
        String[] timeArrayString = {pleaseChoose, time30String, time45String, time60String, time75String,
                time90String, time105String, time120String};

        final int time0Int = 0;
        final int time30Int = 30;
        final int time45Int = 45;
        final int time60Int = 60;
        final int time75Int = 75;
        final int time90Int = 90;
        final int time105Int = 105;
        final int time120Int = 120;
        int[] timeArrayInt = {time0Int, time30Int, time45Int, time60Int, time75Int, time90Int, time105Int, time120Int};

        //creates two array lists
        ArrayList<String> timeArrayListString = new ArrayList<String>();
        ArrayList<Integer> timeArrayListInt = new ArrayList<Integer>();

        //adds values to the array lists
        for (int i = 0; i < timeArrayString.length; i++) {
            timeArrayListString.add(timeArrayString[i]);
            timeArrayListInt.add(timeArrayInt[i]);
        }

        //declares the spinner and uses the adapter to add items
        final Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner_time);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, timeArrayListString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setSelection(0);

        //gets te time from the spinner
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String timeChoiceString = spinner1.getSelectedItem().toString();
                String TAG = "NOTIFICATION TIME SET TO: ";
                System.out.println(TAG + " " + timeChoiceString);

                //converts the string time to an int
                switch (timeChoiceString) {
                    case pleaseChoose:
                        notificationTime = time0Int;
                        Log.d(TAG, "0");
                        break;
                    case time30String:
                        notificationTime = time30Int;
                        Log.d(TAG, "30");
                        break;
                    case time45String:
                        notificationTime = time45Int;
                        Log.d(TAG, "45");
                        break;
                    case time60String:
                        notificationTime = time60Int;
                        Log.d(TAG, "60");
                        break;
                    case time75String:
                        notificationTime = time75Int;
                        Log.d(TAG, "75");
                        break;
                    case time90String:
                        notificationTime = time90Int;
                        Log.d(TAG, "90");
                        break;
                    case time105String:
                        notificationTime = time105Int;
                        Log.d(TAG, "105");
                        break;
                    case time120String:
                        notificationTime = time120Int;
                        Log.d(TAG, "120");
                        break;
                    default:
                        notificationTime = 0;
                        Log.d(TAG, timeChoiceString);
                        break;
                }

                if (notificationTime != 0) {
                    makeButtonVisibleAndStoreTime();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void makeButtonVisibleAndStoreTime() {
        Button button = (Button) view.findViewById(R.id.time_selected_button);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), ExerciseActivity.class);
//                startActivity(intent);
                SelectionPageFragment selectionPageFragment = new SelectionPageFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("notificationTime", notificationTime);
                selectionPageFragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, selectionPageFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

//        int notificationTimeSetterInt;
//
//
//        SharedPreferences notificationTimeSetter = getActivity().getApplicationContext().getSharedPreferences("timeNotificationFile", 0);
//        notificationTimeSetterInt = notificationTimeSetter.getInt("notificationTime", notificationTime); //I may not need this
//
//        SharedPreferences.Editor editor = notificationTimeSetter.edit();
//        editor.putInt("notificationTime", notificationTime);
//        editor.putBoolean("isFirstTime", isFirstTime);
//        editor.commit();

    }
}







