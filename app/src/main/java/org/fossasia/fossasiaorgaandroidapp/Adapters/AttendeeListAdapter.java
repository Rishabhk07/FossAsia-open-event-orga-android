package org.fossasia.fossasiaorgaandroidapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.fossasia.fossasiaorgaandroidapp.R;
import org.fossasia.fossasiaorgaandroidapp.model.AttendeeDetails;

import java.util.ArrayList;

/**
 * Created by rishabhkhanna on 27/04/17.
 */

public class AttendeeListAdapter extends RecyclerView.Adapter<AttendeeListAdapter.AttendeeListAdapterHolder> {
    ArrayList<AttendeeDetails> attendeeDetailses;
    Activity activity;

    public AttendeeListAdapter(ArrayList<AttendeeDetails> attendeeDetailses, Activity activity) {
        this.attendeeDetailses = attendeeDetailses;
        this.activity = activity;
    }

    @Override
    public AttendeeListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = activity.getLayoutInflater();
        View itemView = li.inflate(R.layout.attendee_layout,null);

        AttendeeListAdapterHolder attendeeListAdapterHolder = new AttendeeListAdapterHolder(itemView);
        return attendeeListAdapterHolder;
    }

    @Override
    public void onBindViewHolder(AttendeeListAdapterHolder holder, int position) {
        AttendeeDetails thisAttendee = attendeeDetailses.get(position);
        holder.tvLastName.setText(thisAttendee.getLastname());
        holder.tvFirstName.setText(thisAttendee.getFirstname());
        holder.tvEmail.setText(thisAttendee.getEmail());
        if(thisAttendee.getCheckedIn()) {
            holder.btnCheckedIn.setText("Checked In");
            holder.btnCheckedIn.setBackgroundColor(Color.parseColor("@android:Color"));
            holder.btnCheckedIn.setBackgroundColor(ContextCompat.getColor(activity,android.R.color.holo_green_dark));
        }else{
            holder.btnCheckedIn.setText("Check In");
            holder.btnCheckedIn.setBackgroundColor(ContextCompat.getColor(activity,android.R.color.holo_red_light));
        }
        holder.btnCheckedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return attendeeDetailses.size();
    }

    public class AttendeeListAdapterHolder extends RecyclerView.ViewHolder{

        TextView tvLastName;
        TextView tvFirstName;
        TextView tvEmail;
        Button btnCheckedIn;

        public AttendeeListAdapterHolder(View itemView) {
            super(itemView);
            tvLastName = (TextView) itemView.findViewById(R.id.tvLastName);
            tvFirstName = (TextView) itemView.findViewById(R.id.tvFirstName);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            btnCheckedIn = (Button) itemView.findViewById(R.id.btnCheckedin);
        }
    }
}
