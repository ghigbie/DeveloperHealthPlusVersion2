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

public class TimeChooserFragment extends Fragment {

    private View view;
    private int notificationTime = 0; //this is the time that will be used to set the notification time


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time_chooser, container, false);

        setSpinnerContent();
        addOnClickListener();


        return view;
    }

    public void setSpinnerContent(){

        final String pleaseChoose = "Please Select a Time";
        final String time30String = "30 minutes";
        final String time45String = "45 minutes";
        final String time60String = "60 minutes";
        final String time75String = "1 hour & 15 minutes";
        final String time90String = "1 hour & 30 minutes";
        final String time105String = "1 hour & 45 minutes";
        final String time120String = "2 hours";
        String [] timeArrayString = {pleaseChoose, time30String, time45String, time60String, time75String,
                time90String, time105String, time120String};

        int time0Int = 0;
        int time30Int = 30;
        int time45Int = 45;
        int time60Int = 60;
        int time75Int = 75;
        int time90Int = 90;
        int time105Int = 105;
        int time120Int = 120;
        int [] timeArrayInt = {time0Int, time30Int, time45Int, time60Int, time75Int, time90Int, time105Int, time120Int};

        //creates two array lists
        ArrayList<String> timeArrayListString = new ArrayList<String>();
        ArrayList<Integer> timeArrayListInt = new ArrayList<Integer>();

        //adds values to the array lists
        for(int i = 0; i < timeArrayString.length; i++){
            timeArrayListString.add(timeArrayString[i]);
            timeArrayListInt.add(timeArrayInt[i]);
        }
        //declares the spinner and uses the adapter to add items
        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner_time);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, timeArrayListString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        //gets te time from the spinner
        String timeChoice = spinner1.getSelectedItem().toString();

        //converts the string time to an int
        switch(timeChoice){
            case pleaseChoose:
                notificationTime = 0;
                break;
            case time30String:
                notificationTime = time30Int;
                break;
            case time45String:
                notificationTime = time45Int;
                break;
            case time60String:
                notificationTime = time60Int;
                break;
            case time75String:
                notificationTime = time75Int;
                break;
            case time90String:
                notificationTime = time90Int;
                break;
            case time105String:
                notificationTime = time105Int;
                break;
            case time120String:
                notificationTime = time120Int;
                break;
            default:
                notificationTime = 0;
                break;
        }
        int notificationTimeSetterInt;

        SharedPreferences notificationTimeSetter = getActivity().getApplicationContext().getSharedPreferences("timeNotificationFile", 0);
        notificationTimeSetterInt = notificationTimeSetter.getInt("notificationTime", notificationTime); //I may not need this

        SharedPreferences.Editor editor = notificationTimeSetter.edit();
        editor.putInt("notificationTime", notificationTime);
        editor.commit();
    }
    //
    public void addOnClickListener(){
        Button button = (Button) view.findViewById(R.id.time_selected_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (notificationTime != 0) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new ExerciseChooserFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Please select a time " +
                            "frequency to be notified.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
