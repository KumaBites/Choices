package com.example.choices.JMenu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.choices.Events.Event;
import com.example.choices.Character.Player;
import com.example.choices.R;

import java.util.List;


public class JRecyclerViewAdapter extends RecyclerView.Adapter<JRecyclerViewAdapter.StoryViewHolder> {
        //Local variables to store list data and context.
        private List<JModel> storyList;
        Context context;



        //Take the List and the context and stores them in local variables.
        public JRecyclerViewAdapter(List<JModel> storyList, Context context) {
            this.storyList = storyList;
            this.context = context;
        }

        //Gets teh layout for the activity.
        @Override
        public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflate the layout file
            View storyModelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_story, parent, false);
            StoryViewHolder gvh = new StoryViewHolder(storyModelView);
            return gvh;
        }

        // When the story name is selected a pop up message comes up to confirm selction.
        @Override
        public void onBindViewHolder(StoryViewHolder holder, final int position) {

            holder.txtStory_Name.setText("Lets Begin The Tale Of: "+(storyList.get(position).getMenu()));
            holder.txtStory_Name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String storyName = storyList.get(position).getMenu();
                    double newEventId = storyList.get(position).getMenuId();
                    startStory(storyName,newEventId);
                }
            });
        }
        @Override
        public int getItemCount() {
            return storyList.size();
        }

        public class StoryViewHolder extends RecyclerView.ViewHolder {
            TextView txtStory_Name;

            public StoryViewHolder(View view) {
                super(view);
                txtStory_Name= view.findViewById(R.id.story_name);

            }
        }
        public void startStory(String storyName, final double eventId)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Do you want to start : " +storyName+"?");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent newStory = new Intent(context, Event.class);
                    context.startActivity(newStory);
                    Player.setCurrentEventID(eventId);
                    //Removes from the back stack and destroys it
                    JMenu.getInstance().finish();

                }
            });
            builder.show();
        }

    }

