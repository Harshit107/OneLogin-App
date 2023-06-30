package com.harshit.onelogin.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.harshit.onelogin.R;
import com.harshit.onelogin.helper.ApplicationHelper;
import com.harshit.onelogin.helper.LocalStorageManager;

public class Homepage extends AppCompatActivity {

    Button logout, logoutAll;
    ImageView scanQRImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        logout = findViewById(R.id.logout);
        logoutAll = findViewById(R.id.logout_all);
        scanQRImage = findViewById(R.id.scan_image);

//        checkUserIsLogin();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationHelper.startActivityAndClearTask(getApplicationContext(),LoginActivity.class);
            }
        });
    }
    private void checkUserIsLogin() {
        String token = LocalStorageManager.getStringValue(this,"token");
        if(token == null){
            ApplicationHelper.startActivityAndClearTask(getApplicationContext(), AppLauncherScreen.class);
            finish();
        }

    }
}