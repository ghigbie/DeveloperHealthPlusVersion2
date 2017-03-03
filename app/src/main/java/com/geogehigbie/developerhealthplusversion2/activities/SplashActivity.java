package com.geogehigbie.developerhealthplusversion2.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by georgehigbie on 1/30/17.
 */

public class SplashActivity extends Activity {

    private boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firstTime = true;

        Intent intent;
        if(firstTime) {
            intent = new Intent(this, MainActivity.class);
        }else{
            intent = new Intent(this, ExerciseActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
