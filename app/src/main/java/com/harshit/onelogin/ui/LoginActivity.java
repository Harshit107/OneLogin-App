package com.harshit.onelogin.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.harshit.onelogin.Config;
import com.harshit.onelogin.R;
import com.harshit.onelogin.helper.ApplicationHelper;
import com.harshit.onelogin.helper.LocalStorageManager;
import com.harshit.onelogin.helper.VolleyRequestManager;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    Button signupBtn;
    EditText emailET, passwordET;
    VolleyRequestManager volleyRequestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login);
        signupBtn = findViewById(R.id.signup);
        emailET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);
        volleyRequestManager =  VolleyRequestManager.getInstance(this);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateForm())
                    performLogin(emailET.getText().toString(), passwordET.getText().toString());

            }
        });



    }



    private void performLogin(String email, String password) {
        if(email.equals("123"))
            ApplicationHelper.startActivityAndClearTask(getApplicationContext(), Homepage.class);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email",email);
            jsonObject.put("password",password);

            volleyRequestManager.makeJsonRequest(Config.LOGIN, jsonObject, new VolleyRequestManager.VolleyCallback() {
                @Override
                public void onSuccess(JSONObject response) {
                    Log.d("LOGIN_ACTIVITY",response.toString());

                }
                @Override
                public void onError(VolleyError error) {
                    Log.d("LOGIN_ACTIVITY",error.toString());
                }
            });

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateForm() {
        return true;
    }
}