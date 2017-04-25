package org.fossasia.fossasiaorgaandroidapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.fossasia.fossasiaorgaandroidapp.Api.ApiCall;
import org.fossasia.fossasiaorgaandroidapp.R;
import org.fossasia.fossasiaorgaandroidapp.Utils.Constants;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ApiCall.callApi(this , Constants.userEvents);
    }
}