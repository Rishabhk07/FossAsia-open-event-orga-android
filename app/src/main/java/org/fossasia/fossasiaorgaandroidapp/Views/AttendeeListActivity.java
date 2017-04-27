package org.fossasia.fossasiaorgaandroidapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    static ArrayList<AttendeeDetails> attendeeDetailsArrayList = new ArrayList<>();
    AttendeeListAdapter attendeeListAdapter;
    Button btnBarCodeScanner;
    long id;
    public static final int REQ_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_list);
        Intent i = getIntent();
        id = i.getLongExtra("id",0);
        recyclerView = (RecyclerView) findViewById(R.id.rvAttendeeList);
        btnBarCodeScanner = (Button) findViewById(R.id.btnScanQr);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        attendeeListAdapter = new AttendeeListAdapter(attendeeDetailsArrayList, this , id);
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
                btnBarCodeScanner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(VolleyError error) {

            }
        });

        btnBarCodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AttendeeListActivity.this , ScanQRActivity.class);
                startActivityForResult(i,123);
            }
        });
    }
}
