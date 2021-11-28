package com.example.choices;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class DescriptionRecyclerViewAdapter extends RecyclerView.Adapter<DescriptionRecyclerViewAdapter.EventViewHolder> {

    private List<DescriptionModel> eventList;
    Context context;

    public DescriptionRecyclerViewAdapter(List<DescriptionModel> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public DescriptionRecyclerViewAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View EventModelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_description, parent, false);
        DescriptionRecyclerViewAdapter.EventViewHolder gvh = new DescriptionRecyclerViewAdapter.EventViewHolder(EventModelView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(DescriptionRecyclerViewAdapter.EventViewHolder holder, final int position) {

        holder.eventDescription.setText((eventList.get(position).getDescription()));
    }
    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventDescription;

        public EventViewHolder(View view) {
            super(view);
            eventDescription = view.findViewById(R.id.description);
        }
    }

    }



