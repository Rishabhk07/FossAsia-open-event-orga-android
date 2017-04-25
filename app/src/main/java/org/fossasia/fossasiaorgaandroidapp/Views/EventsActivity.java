package org.fossasia.fossasiaorgaandroidapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.fossasia.fossasiaorgaandroidapp.Api.ApiCall;
import org.fossasia.fossasiaorgaandroidapp.Api.LoginCall;
import org.fossasia.fossasiaorgaandroidapp.R;
import org.fossasia.fossasiaorgaandroidapp.Utils.Constants;
import org.fossasia.fossasiaorgaandroidapp.model.UserEvents;

public class EventsActivity extends AppCompatActivity {

    public static final String TAG = "EventsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        LoginCall.VolleyCallBack volleyCallBack = new LoginCall.VolleyCallBack() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                UserEvents[] userEvents = gson.fromJson(response , UserEvents[].class);
                for (UserEvents event : userEvents){
                    Log.d(TAG, "onSuccess: " + event.getName());
                }

            }

            @Override
            public void onError(VolleyError error) {

            }
        };
        ApiCall.callApi(this , Constants.userEvents, volleyCallBack);
    }
}
