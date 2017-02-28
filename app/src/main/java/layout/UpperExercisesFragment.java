package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.geogehigbie.developerhealthplusversion2.R;


public class UpperExercisesFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_upper_exercises, container, false);
        // Inflate the layout for this fragment

        return view;
    }

    public void layoutCreation(){
        RelativeLayout

    }

}
