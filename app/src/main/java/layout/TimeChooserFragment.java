package layout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.geogehigbie.developerhealthplusversion2.R;

import java.util.ArrayList;

import static android.R.attr.button;
import static android.R.string.no;

public class TimeChooserFragment extends Fragment {

    private View view;
    //private int notificationTime; //this is the time that will be used to set the notification time


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time_chooser, container, false);

        setSpinnerContent();
        // addOnClickListener();

        return view;
    }

    public void setSpinnerContent() {

        int notificationTime;

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
        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner_time);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, timeArrayListString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        //gets te time from the spinner
        String timeChoiceString = spinner1.getSelectedItem().toString();
        String TAG = "NOTIFICATION TIME SET TO: ";
        System.out.println(TAG + " " + timeChoiceString);

        //converts the string time to an int
//        switch(timeChoiceString){
//            case "Please select a time":
//                notificationTime = 0;
//                Log.d(TAG, timeChoiceString);
//                break;
//            case time30String:
//                notificationTime = time30Int;
//                Log.d(TAG, timeChoiceString);
//                break;
//            case time45String:
//                notificationTime = time45Int;
//                Log.d(TAG, timeChoiceString);
//                break;
//            case time60String:
//                notificationTime = time60Int;
//                Log.d(TAG, timeChoiceString);
//                break;
//            case time75String:
//                notificationTime = time75Int;
//                Log.d(TAG, timeChoiceString);
//                break;
//            case time90String:
//                notificationTime = time90Int;
//                Log.d(TAG, timeChoiceString);
//                break;
//            case time105String:
//                notificationTime = time105Int;
//                Log.d(TAG, timeChoiceString);
//                break;
//            case time120String:
//                notificationTime = time120Int;
//                Log.d(TAG, timeChoiceString);
//                break;
//            default:
//                notificationTime = 0;
//                Log.d(TAG, timeChoiceString);
//                break;
//        }

        if (timeChoiceString == timeArrayString[0]) {
            notificationTime = timeArrayInt[0];
        } else if (timeChoiceString == timeArrayString[1]) {
            notificationTime = timeArrayInt[1];
        } else if (timeChoiceString == timeArrayString[2]) {
            notificationTime = timeArrayInt[2];
        } else if (timeChoiceString == timeArrayString[3]) {
            notificationTime = timeArrayInt[3];
        } else if (timeChoiceString == timeArrayString[4]) {
            notificationTime = timeArrayInt[4];
        } else if (timeChoiceString == timeArrayString[5]) {
            notificationTime = timeArrayInt[5];
        } else if (timeChoiceString == timeArrayString[6]) {
            notificationTime = timeArrayInt[6];
        } else {
            notificationTime = timeArrayInt[7];
        }

        int notificationTimeSetterInt;

        SharedPreferences notificationTimeSetter = getActivity().getApplicationContext().getSharedPreferences("timeNotificationFile", 0);
        notificationTimeSetterInt = notificationTimeSetter.getInt("notificationTime", notificationTime); //I may not need this

        SharedPreferences.Editor editor = notificationTimeSetter.edit();
        editor.putInt("notificationTime", notificationTime);
        editor.commit();

        Button button = (Button) view.findViewById(R.id.time_selected_button);
        if (notificationTime != 0) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    if (notificationTime != 0) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new ExerciseChooserFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        } else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please select a time " +
                                    "frequency to be notified. Your current notification time is: " + notificationTime,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
    //
//    public void addOnClickListener(){
//        Button button = (Button) view.findViewById(R.id.time_selected_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (notificationTime != 0) {
//                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragment_container, new ExerciseChooserFragment());
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
//                }else{
//                    Toast.makeText(getActivity().getApplicationContext(), "Please select a time " +
//                            "frequency to be notified. Your current notification time is:" + notificationTime,
//                            Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }



