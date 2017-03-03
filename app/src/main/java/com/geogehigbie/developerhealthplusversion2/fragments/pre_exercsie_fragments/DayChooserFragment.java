package com.geogehigbie.developerhealthplusversion2.fragments.pre_exercsie_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.geogehigbie.developerhealthplusversion2.R;

import java.util.ArrayList;


public class DayChooserFragment extends Fragment {

    private View view;
    private int notificationTime;
    boolean [] daysActive;
    ArrayList<String> daysActiveStringArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day_chooser, container, false);

        Bundle bundle = this.getArguments();
        if( bundle != null){
            notificationTime = bundle.getInt("notificationTime", notificationTime);
        }


        return view;
    }


    public void setOnClickListener(){

        boolean isMonday = false;
        boolean isTuesday = false;
        boolean isWednesday = false;
        boolean isThursday = false;
        boolean isFriday = false;
        boolean isSaturday = false;
        boolean isSunday = false;

        daysActive = new boolean[]{isMonday, isTuesday, isWednesday, isThursday, isFriday, isSaturday, isSunday};
        int numberTrue = 0;

        CheckBox checkBoxMonday = (CheckBox) view.findViewById(R.id.monday);
        CheckBox checkBoxTuesday = (CheckBox) view.findViewById(R.id.tuesday);
        CheckBox checkBoxWednesday = (CheckBox) view.findViewById(R.id.wednesday);
        CheckBox checkBoxThursday = (CheckBox) view.findViewById(R.id.thursday);
        CheckBox checkBoxFriday = (CheckBox) view.findViewById(R.id.friday);
        CheckBox checkBoxSaturday = (CheckBox) view.findViewById(R.id.saturday);
        CheckBox checkBoxSunday = (CheckBox) view.findViewById(R.id.sunday);

        ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();
        checkBoxes.add(checkBoxMonday);
        checkBoxes.add(checkBoxTuesday);
        checkBoxes.add(checkBoxWednesday);
        checkBoxes.add(checkBoxThursday);
        checkBoxes.add(checkBoxFriday);
        checkBoxes.add(checkBoxSaturday);
        checkBoxes.add(checkBoxSunday);



        for(int i = 0; i < checkBoxes.size(); i++){
            if (checkBoxes.get(i).isChecked()) {
                numberTrue++;
                daysActive[i] = true; //adds values to boolean array if they are checked
                daysActiveStringArrayList.add(checkBoxes.get(i).getText().toString()); //adds strings to array list if checked
            }
        }
        //The idea of the above for loop is that the if the boxes are checked, their respective boolean values
        //will be added to an array and their respective String objects will be added to a string arrray list.
        //All of the values will then be passed to the next fragment, and then be stored in shared preferences file



        Button button = (Button) view.findViewById(R.id.next_button_day_Chooser);

        if(numberTrue > 0) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }else{
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Are you sure that you do not want to make a selection?", Toast.LENGTH_SHORT).show();

                    Button buttonInner = (Button) view.findViewById(R.id.next_button_day_Chooser);
                    buttonInner.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SelectionPageFragment selectionPageFragment = new SelectionPageFragment();
                            Bundle bundle = new Bundle();
                            bundle.putInt("notificationTime", notificationTime);
                            bundle.putBooleanArray("daysActive", daysActive);
                            bundle.putStringArray("daysActiveString", daysActiveString);

                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragment_container, selectionPageFragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });
                }
            });
        }




    }


}
