package com.example.choices;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


public class FantasyEventRecyclerViewAdapter extends RecyclerView.Adapter<FantasyEventRecyclerViewAdapter.EventViewHolder> {

    private List<FantasyEventModel> eventList;
    Context context;

    public FantasyEventRecyclerViewAdapter(List<FantasyEventModel> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public FantasyEventRecyclerViewAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View EventModelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_event, parent, false);
        FantasyEventRecyclerViewAdapter.EventViewHolder gvh = new FantasyEventRecyclerViewAdapter.EventViewHolder(EventModelView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(FantasyEventRecyclerViewAdapter.EventViewHolder holder, final int position) {

        holder.eventChoice1.setText("Choice 1:"+(eventList.get(position).getEventChoice1()));
        holder.eventChoice2.setText("Choice 2 :"+(eventList.get(position).getEventChoice2()));
        holder.eventChoice3.setText("Choice 3 :"+(eventList.get(position).getEventChoice3()));
        holder.eventChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName1 = eventList.get(position).getEventChoice1();
                Toast.makeText(context, eventName1 + " is selected", Toast.LENGTH_SHORT).show();
                RhothomirPlayer.setCurrentEventID(RhothomirPlayer.getNextEventID1());
                displayResult(RhothomirPlayer.getEventToast1());

            }
        });
        holder.eventChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName2 = eventList.get(position).getEventChoice2();
                Toast.makeText(context, eventName2 + " is selected", Toast.LENGTH_SHORT).show();
                RhothomirPlayer.setCurrentEventID(RhothomirPlayer.getNextEventID2());
                displayResult(RhothomirPlayer.getEventToast2());
            }
        });
        holder.eventChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName3 = eventList.get(position).getEventChoice3();
                Toast.makeText(context, eventName3 + " is selected", Toast.LENGTH_SHORT).show();
               RhothomirPlayer.setCurrentEventID(RhothomirPlayer.getNextEventID3());
                displayResult(RhothomirPlayer.getEventToast3());
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
        builder.setMessage(Toast);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FantasyEvent.getInstance().finish();
                Intent intent = new Intent(context, FantasyEvent.class);
                context.startActivity(intent);
                FantasyEvent.getInstance().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                //Destroys the event after it is used
                FantasyEvent.getInstance().finish();
            }
        });
        builder.show();
    }



}
