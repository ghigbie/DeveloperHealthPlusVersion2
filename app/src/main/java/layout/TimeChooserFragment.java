package layout;

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

import com.geogehigbie.developerhealthplusversion2.R;

import java.util.ArrayList;

public class TimeChooserFragment extends Fragment {

    private View view;
    private ArrayList<String> timeArrayListString = new ArrayList<String>();
    private ArrayList<Integer> timeArrayListInt = new ArrayList<Integer>();

    private String pleaseChoose = "Please Select a Time";
    private String time30String = "30 minutes";
    private String time45String = "45 minutes";
    private String time60String = "60 minutes";
    private String time75String = "1 hour & 15 minutes";
    private String time90String = "1 hour & 30 minutes";
    private String time105String = "1 hour & 45 minutes";
    private String time120String = "2 hours";

    private int time0Int = 0;
    private int time30Int = 30;
    private int time45Int = 45;
    private int time60Int = 60;
    private int time75Int = 75;
    private int time105Int = 105;
    private int time120Int = 120;

    private int NotificationTime;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time_chooser, container, false);

        //if we have a value selected;
        addOnClickListener();


        return view;
    }

    public void setSpinnerContent(){

        String pleaseChoose = "Please Select a Time";
        String time30String = "30 minutes";
        String time45String = "45 minutes";
        String time60String = "60 minutes";
        String time75String = "1 hour & 15 minutes";
        String time90String = "1 hour & 30 minutes";
        String time105String = "1 hour & 45 minutes";
        String time120String = "2 hours";
        String [] timeArrayString = {pleaseChoose, time30String, time45String, time60String, time75String,
                time90String, time105String, time120String};

        int time0Int = 0;
        int time30Int = 30;
        int time45Int = 45;
        int time60Int = 60;
        int time75Int = 75;
        int time105Int = 105;
        int time120Int = 120;
        int [] timeArrayInt = {time0Int, time30Int, time45Int, time60Int, time75Int, time105Int, time105Int, time120Int};

        //creates two array lists
        ArrayList<String> timeArrayListString = new ArrayList<String>();
        ArrayList<Integer> timeArrayListInt = new ArrayList<Integer>();

        //adds values to the array lists
        for(int i = 0; i < timeArrayString.length; i++){
            timeArrayListString.add(timeArrayString[i]);
            timeArrayListInt.add(timeArrayInt[i]);
        }

        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner_time);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, timeArrayListString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

    }


    public void addOnClickListener(){
        Button button = (Button) view.findViewById(R.id.time_selected_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ExerciseChooserFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }



}
