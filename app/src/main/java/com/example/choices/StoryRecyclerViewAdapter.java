package com.example.choices;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.choices.Rhothomir.Character_Select;
import com.example.choices.Rhothomir.Fantasy_Event;
import com.example.choices.Rhothomir.Rhothomir_Player;

import java.util.List;


public class StoryRecyclerViewAdapter extends RecyclerView.Adapter<StoryRecyclerViewAdapter.StoryViewHolder> {
        private List<Story_Select_Model> storyList;
        Context context;



        public StoryRecyclerViewAdapter(List<Story_Select_Model> storyList, Context context) {
            this.storyList = storyList;
            this.context = context;
        }

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

            holder.txtStory_Name.setText("Lets Begin The Tale Of: :"+(storyList.get(position).getStoryName()));


            holder.txtStory_Name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String storyName = storyList.get(position).getStoryName();
                    String storyTimeClass = "Rhothomir's Crown";
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    if(storyName.equals(storyTimeClass)) {
                        builder.setMessage("Do you want to start the adventure " +storyName+"?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent newStory = new Intent(context, Character_Select.class);
                            context.startActivity(newStory);
                        }
                    });
                    builder.show();
                    }
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
    }

