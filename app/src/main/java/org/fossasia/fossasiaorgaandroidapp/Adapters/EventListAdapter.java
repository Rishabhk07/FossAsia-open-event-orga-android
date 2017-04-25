package org.fossasia.fossasiaorgaandroidapp.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.fossasia.fossasiaorgaandroidapp.R;
import org.fossasia.fossasiaorgaandroidapp.model.UserEvents;

import java.util.ArrayList;

/**
 * Created by rishabhkhanna on 26/04/17.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventRecyclerViewHolder>{

    ArrayList<UserEvents> eventsArrayList = new ArrayList<>();
    Activity activity;

    public EventListAdapter(ArrayList<UserEvents> eventsArrayList ,Activity context) {
        this.eventsArrayList = eventsArrayList;
        this.activity = context;
    }

    @Override
    public EventRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = activity.getLayoutInflater();
        View itemView = li.inflate(R.layout.event_layout,null);

        EventRecyclerViewHolder eventRecyclerViewHolder  = new EventRecyclerViewHolder(itemView);
        return eventRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(EventRecyclerViewHolder holder, int position) {

        UserEvents thisEvent = eventsArrayList.get(position);
        holder.eventTitle.setText(thisEvent.getName());
        Picasso.with(activity).load(thisEvent.getThumbnail()).into(holder.eventImage);

    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }


    //view holder class
    public  class EventRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView eventTitle;
        ImageView eventImage;

        public EventRecyclerViewHolder(View itemView) {
            super(itemView);
            eventTitle = (TextView) itemView.findViewById(R.id.tvEventTitle);
            eventImage = (ImageView) itemView.findViewById(R.id.ivEventProfile);
        }

    }

}
