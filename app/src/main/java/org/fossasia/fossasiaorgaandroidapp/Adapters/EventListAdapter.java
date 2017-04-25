package org.fossasia.fossasiaorgaandroidapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rishabhkhanna on 26/04/17.
 */

public class EventListAdapter {

    public void newInstance(){

    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.EventRecyclerViewHolder>{


        @Override
        public EventRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(EventRecyclerViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public  class EventRecyclerViewHolder extends RecyclerView.ViewHolder{

            public EventRecyclerViewHolder(View itemView) {
                super(itemView);
            }
        }

    }


}
