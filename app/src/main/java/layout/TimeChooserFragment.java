package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.geogehigbie.developerhealthplusversion2.R;

import java.util.ArrayList;

public class TimeChooserFragment extends Fragment {

    private View view;
    private ArrayList<String> timeArrayListStirng = new ArrayList<String>();
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



        return view;
    }

    public addOnClickListener(){
        Button button = (Button) view.findViewById(R.id.time_selected_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, ExerciseChooserPage.activity)
            }
        });
    }



}
