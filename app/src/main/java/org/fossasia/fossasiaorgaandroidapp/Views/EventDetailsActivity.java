package org.fossasia.fossasiaorgaandroidapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.fossasia.fossasiaorgaandroidapp.Api.ApiCall;
import org.fossasia.fossasiaorgaandroidapp.Api.LoginCall;
import org.fossasia.fossasiaorgaandroidapp.R;
import org.fossasia.fossasiaorgaandroidapp.Utils.Constants;
import org.fossasia.fossasiaorgaandroidapp.model.AttendeeDetails;
import org.fossasia.fossasiaorgaandroidapp.model.EventDetails;
import org.fossasia.fossasiaorgaandroidapp.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class EventDetailsActivity extends AppCompatActivity {
    TextView tvEventTitle;
    TextView tvStartDate;
    TextView tvEndDate;
    TextView tvTime;
    TextView tvTicketSold;
    TextView tvAttendees;
    TextView tvTicketTotal;
    ProgressBar pbTickets;
    ProgressBar pbAttendees;
    public static final String TAG = "EventDetailActivity";
    long quantity = 0;
    int attendeeTrue = 0;
    int attendeeTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        Intent i = getIntent();

        tvEventTitle = (TextView) findViewById(R.id.tvEventTitle);
        tvStartDate = (TextView) findViewById(R.id.tvStartDate);
        tvEndDate = (TextView) findViewById(R.id.tvEndDate);
        tvTime = (TextView) findViewById(R.id.tvHour);
        tvTicketSold = (TextView) findViewById(R.id.tvTicketSold);
        tvAttendees = (TextView) findViewById(R.id.tvAttendance);
        tvTicketTotal = (TextView) findViewById(R.id.tvTicketTotal);
        pbTickets = (ProgressBar) findViewById(R.id.progressTicketSold);
        pbAttendees = (ProgressBar) findViewById(R.id.progressAttendance);

        int position = i.getIntExtra("position",0);
        long id = i.getLongExtra("id",0);
        final Gson gson = new Gson();
        String urlTickets = Constants.eventDetails + id + Constants.tickets;
        String urlAttendees = Constants.eventDetails + EventsActivity.userEventsArrayList.get(position).getId() + Constants.attendees;
        ApiCall.callApi(this, urlTickets, new LoginCall.VolleyCallBack() {
            @Override
            public void onSuccess(String result) {
                EventDetails eventDetails = gson.fromJson(result , EventDetails.class);
                List<Ticket> tickets = (ArrayList<Ticket>) eventDetails.getTickets();

                String[] startDate = eventDetails.getStartTime().split("T");
                String[] endDate = eventDetails.getEndTime().split("T");

                for(Ticket thisTicket : tickets){
                    quantity += thisTicket.getQuantity();
                }
                tvEventTitle.setText(eventDetails.getName());
                tvStartDate.setText(startDate[0]);
                tvEndDate.setText(endDate[0]);
                tvTime.setText(endDate[1]);
                tvTicketTotal.setText(String.valueOf(quantity));



            }
            @Override
            public void onError(VolleyError error) {

            }
        });

        ApiCall.callApi(this, urlAttendees, new LoginCall.VolleyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                attendeeTotal = 0;
                attendeeTrue = 0;
                AttendeeDetails[] attendeeDetailses = gson.fromJson(result , AttendeeDetails[].class);
                for(AttendeeDetails thisAttendee : attendeeDetailses){
                    if(thisAttendee.getCheckedIn()){
                        attendeeTrue++;
                    }
                    attendeeTotal++;

                }


                tvAttendees.setText(String.valueOf(attendeeTrue) + "/" + String.valueOf(attendeeTotal));
                tvTicketSold.setText(String.valueOf(attendeeTotal));

                pbAttendees.setProgress((int)attendeeTrue/attendeeTotal);
                if(quantity != 0)
                pbTickets.setProgress((int) (attendeeTotal/quantity));

            }

            @Override
            public void onError(VolleyError error) {

            }
        });





    }
}
