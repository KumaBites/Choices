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

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.EventViewHolder> {

        private List<MainModel> menuList;
        Context context;
        private String jToE, jOnly, credits, information;

        public MainRecyclerViewAdapter(List<MainModel> eventList, Context context) {
            this.menuList = eventList;
            this.context = context;
        }

        @Override
        public MainRecyclerViewAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflate the layout file
            View EventModelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main, parent, false);
            MainRecyclerViewAdapter.EventViewHolder gvh = new MainRecyclerViewAdapter.EventViewHolder(EventModelView);
            return gvh;
        }

        @Override
        public void onBindViewHolder(MainRecyclerViewAdapter.EventViewHolder holder, final int position) {
            jToE = "Japanese to English";
            jOnly = "Japanese Only";
            information = "Information about app";
            credits = "Credits and thank yous";
            holder.mainRecyclerView.setText("Menu Option : "+(menuList.get(position).getMain()));
            holder.mainRecyclerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String storyName = menuList.get(position).getMain();
                    //checks the story name and the sets the event ID
                    switch (storyName)
                    {
                        case "Japanese to English":
                        startMain(storyName);
                            break;
                        case "Japanese Only":
                        startMain(storyName);
                            break;
                        case "Information about app":
                        startMain(storyName);
                            break;
                        case "Credits and thank yous":
                        startMain(storyName);
                            break;
                    }

                }
            });
        }
        @Override
        public int getItemCount() {
            return menuList.size();
        }

        public class EventViewHolder extends RecyclerView.ViewHolder {
            private TextView mainRecyclerView;

            public EventViewHolder(View view) {
                super(view);
                mainRecyclerView = view.findViewById(R.id.main_name);

            }
        }

    public void startMain(final String main)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Starting: " +main+"?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (main.equals(jToE)) {
                    Intent newMenu = new Intent(context, JMenu.class);
                    MainModel.setName("Japanese to English");
                    context.startActivity(newMenu);
                    Main.getInstance().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    //Removes from the back stack and destroys it
                    Main.getInstance().finish();
                } else if (main.equals(jOnly)) {
                    Intent newMenu = new Intent(context, JMenu.class);
                    MainModel.setName("Japanese Only");
                    context.startActivity(newMenu);
                    Main.getInstance().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    //Removes from the back stack and destroys it
                    Main.getInstance().finish();

                } else if (main.equals(information)) {
                    Intent newMenu = new Intent(context, CreditsAndInfo.class);
                    MainModel.setName("Information about app");
                    context.startActivity(newMenu);
                    Main.getInstance().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    //Removes from the back stack and destroys it
                    Main.getInstance().finish();
                } else if (main.equals(credits)) {
                    Intent newMenu = new Intent(context, CreditsAndInfo.class);
                    MainModel.setName("Credits and thank yous");
                    context.startActivity(newMenu);
                    Main.getInstance().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    //Removes from the back stack and destroys it
                    Main.getInstance().finish();
                }
            }
        });
        builder.show();

        }
    }




