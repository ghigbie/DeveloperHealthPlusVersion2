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

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        buttonUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.fragment_container, new UpperExercisesFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        buttonLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}
