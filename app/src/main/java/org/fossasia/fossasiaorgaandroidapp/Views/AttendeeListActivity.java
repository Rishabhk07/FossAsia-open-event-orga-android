package org.fossasia.fossasiaorgaandroidapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.fossasia.fossasiaorgaandroidapp.Adapters.AttendeeListAdapter;
import org.fossasia.fossasiaorgaandroidapp.Api.ApiCall;
import org.fossasia.fossasiaorgaandroidapp.Api.LoginCall;
import org.fossasia.fossasiaorgaandroidapp.R;
import org.fossasia.fossasiaorgaandroidapp.Utils.Constants;
import org.fossasia.fossasiaorgaandroidapp.model.AttendeeDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AttendeeListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AttendeeDetails[] attendeeDetails;
    ArrayList<AttendeeDetails> attendeeDetailsArrayList = new ArrayList<>();
    AttendeeListAdapter attendeeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_list);
        recyclerView = (RecyclerView) findViewById(R.id.rvAttendeeList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        attendeeListAdapter = new AttendeeListAdapter(attendeeDetailsArrayList, this);
        recyclerView.setAdapter(attendeeListAdapter);
        recyclerView.setLayoutManager(layoutManager);
        getAttendees();
    }

    public void getAttendees(){
        ApiCall.callApi(this, EventDetailsActivity.urlAttendees
                , new LoginCall.VolleyCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                attendeeDetails = gson.fromJson(result,AttendeeDetails[].class);
                List<AttendeeDetails> attendeeDetailsesList = Arrays.asList(attendeeDetails);
                attendeeDetailsArrayList.addAll(attendeeDetailsesList);
                attendeeListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}
