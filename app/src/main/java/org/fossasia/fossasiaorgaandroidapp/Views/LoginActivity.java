package org.fossasia.fossasiaorgaandroidapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.fossasia.fossasiaorgaandroidapp.Api.LoginCall;
import org.fossasia.fossasiaorgaandroidapp.R;
import org.fossasia.fossasiaorgaandroidapp.model.LoginDetails;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    Button btnLogin;
    EditText etEmail;
    EditText etPassword;
    String email = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Login Button Clicked");
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();
                LoginDetails loginDetails = new LoginDetails(email, password);
                LoginCall.login(LoginActivity.this , loginDetails);
            }
        });

    }
}
