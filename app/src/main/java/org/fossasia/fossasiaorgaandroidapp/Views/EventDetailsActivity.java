package org.fossasia.fossasiaorgaandroidapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.fossasia.fossasiaorgaandroidapp.R;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        Intent i = getIntent();
        int position = i.getIntExtra("position",0);
        int id = i.getIntExtra("id",0);





    }
}
