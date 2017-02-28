package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.geogehigbie.developerhealthplusversion2.R;


public class ExerciseChooserFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_exercise_chooser, container, false);



        return view;
    }

    public void setOnClickListener(){
        Button buttonUpper = (Button) view.findViewById(R.id.upper);
        Button buttonLower = (Button) view.findViewById(R.id.lower);
        Button buttonBoth = (Button) view.findViewById(R.id.both);

        buttonUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            }
        });


    }

}
