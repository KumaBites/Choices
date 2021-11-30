package com.example.choices;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class DescriptionRecyclerViewAdapter extends RecyclerView.Adapter<DescriptionRecyclerViewAdapter.EventViewHolder> {

    private List<DescriptionModel> eventList;
    int imageCheck;
    Context context;

    public DescriptionRecyclerViewAdapter(List<DescriptionModel> eventList, Context context, int imageCheck) {
        this.eventList = eventList;
        this.context = context;
        this.imageCheck = imageCheck;
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
        String id1 = eventList.get(position).select_drawable_name;
        final int id = context.getResources().getIdentifier(id1, "drawable", context.getPackageName());
        if(imageCheck == 1)
        {
            holder.eventImage.setImageResource(id);
        }
        else {
            holder.eventDescription.setText((eventList.get(position).getDescription()));
        }
    }
    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventDescription;
        ImageView eventImage;

        public EventViewHolder(View view) {
            super(view);
            eventDescription = view.findViewById(R.id.description);
            eventImage = view.findViewById(R.id.imageDescription);
        }
    }

    }


