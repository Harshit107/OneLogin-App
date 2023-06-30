package com.harshit.onelogin.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.harshit.onelogin.R;
import com.harshit.onelogin.helper.ApplicationHelper;

public class AppLauncherScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_launcher_screen);
// Delay the transition to the next screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity
                ApplicationHelper.startActivityAndClearTask(getApplicationContext(), Homepage.class);
                finish();
            }
        }, 1000);

    }
}