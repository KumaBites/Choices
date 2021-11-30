package com.example.choices;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.EventViewHolder> {

    private List<EventModel> eventList;
    Context context;

    public EventRecyclerViewAdapter(List<EventModel> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public EventRecyclerViewAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View EventModelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_event, parent, false);
        EventRecyclerViewAdapter.EventViewHolder gvh = new EventRecyclerViewAdapter.EventViewHolder(EventModelView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(EventRecyclerViewAdapter.EventViewHolder holder, final int position) {

        holder.eventChoice1.setText("Choice 1:"+(eventList.get(position).getEventChoice1()));
        holder.eventChoice2.setText("Choice 2 :"+(eventList.get(position).getEventChoice2()));
        holder.eventChoice3.setText("Choice 3 :"+(eventList.get(position).getEventChoice3()));
        holder.eventChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName1 = eventList.get(position).getEventChoice1();
                if(Player.getNextEventID1() == 0.1)
                {
                incorrect(eventName1);
                }
                else
                    {
                    Player.setCurrentEventID(Player.getNextEventID1());
                    displayResult(eventName1);
                }
            }
        });
        holder.eventChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName2 = eventList.get(position).getEventChoice2();
                if(Player.getNextEventID2() == 0.1)
                {
                    incorrect(eventName2);
                }
                else {
                    Player.setCurrentEventID(Player.getNextEventID2());
                    displayResult(eventName2);
                }
            }
        });
        holder.eventChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName3 = eventList.get(position).getEventChoice3();
                if(Player.getNextEventID3() == 0.1)
                {
                    incorrect(eventName3);
                }
                else {
                    Player.setCurrentEventID(Player.getNextEventID3());
                    displayResult(eventName3);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventChoice1;
        TextView eventChoice2;
        TextView eventChoice3;



        public EventViewHolder(View view) {
            super(view);
            eventChoice1= view.findViewById(R.id.choice_name1);
            eventChoice2 = view.findViewById(R.id.choice_name2);
            eventChoice3 = view.findViewById(R.id.choice_name3);
        }
    }
    //Takes in the Toast message as String and displays it, it then starts the new activity
    private void displayResult(String Toast) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Thats the correct answer!: "+Toast);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Event.getInstance().finish();
                Intent intent = new Intent(context, Event.class);
                context.startActivity(intent);
                Event.getInstance().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                //Destroys the event after it is used
                Event.getInstance().finish();
            }
        });
        builder.show();
    }
    private void incorrect(String Toast)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("That's not correct: "+Toast);
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }



}

