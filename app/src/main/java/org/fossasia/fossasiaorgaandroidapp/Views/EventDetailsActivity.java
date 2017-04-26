package org.fossasia.fossasiaorgaandroidapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.fossasia.fossasiaorgaandroidapp.Api.ApiCall;
import org.fossasia.fossasiaorgaandroidapp.Api.LoginCall;
import org.fossasia.fossasiaorgaandroidapp.Interfaces.VolleyCallBack;
import org.fossasia.fossasiaorgaandroidapp.R;
import org.fossasia.fossasiaorgaandroidapp.Utils.Constants;

public class EventDetailsActivity extends AppCompatActivity {
    TextView tvEventTitle;
    TextView tvStartDate;
    TextView tvEndDate;
    TextView tvTime;
    TextView tvTickets;
    TextView tvAttendees;
    ProgressBar pbTickets;
    ProgressBar pbAttendees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        Intent i = getIntent();

        tvEventTitle = (TextView) findViewById(R.id.tvEventTitle);
        tvStartDate = (TextView) findViewById(R.id.tvStartDate);
        tvEndDate = (TextView) findViewById(R.id.tvEndDate);
        tvTime = (TextView) findViewById(R.id.tvHour);
        tvTickets = (TextView) findViewById(R.id.tvTicketSold);
        tvAttendees = (TextView) findViewById(R.id.tvAttendance);
        pbTickets = (ProgressBar) findViewById(R.id.progressTicketSold);
        pbAttendees = (ProgressBar) findViewById(R.id.progressAttendance);

        int position = i.getIntExtra("position",0);
        int id = i.getIntExtra("id",0);
        String urlTickets = Constants.eventDetails + EventsActivity.userEventsArrayList.get(id) + Constants.tickets;
        String urlAttendees = Constants.eventDetails + EventsActivity.userEventsArrayList.get(id) + Constants.attendees;
        ApiCall.callApi(this, urlTickets, new LoginCall.VolleyCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                gson.fromJson(result , );
            }
            @Override
            public void onError(VolleyError error) {

            }
        });





    }
}
