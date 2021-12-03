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

            holder.mainRecyclerView.setText("Menu Option : "+(menuList.get(position).getMain()));
            holder.mainRecyclerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String storyName = menuList.get(position).getMain();
                    //checks the story name and the sets the event ID
                    switch (storyName)
                    {
                        case "Japanese to English":
                            Intent newMenu1 = new Intent(context, JMenu.class);
                            context.startActivity(newMenu1);
                            MainModel.setName("Japanese to English");

                         //   JToE.getInstance().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                            //Removes from the back stack and destroys it
                           // JToE.getInstance().finish();
                            break;
                        case "Japanese Only":
                            Intent newMenu2 = new Intent(context, JMenu.class);
                            context.startActivity(newMenu2);
                            MainModel.setName("Japanese Only");
                          //  JToE.getInstance().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                            //Removes from the back stack and destroys it
                           // JToE.getInstance().finish();
                            break;
                        case "Information about app":
                            Intent newMenu3 = new Intent(context, CreditsAndInfo.class);
                            context.startActivity(newMenu3);
                            MainModel.setName("Information about app");
                         //   JToE.getInstance().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                            //Removes from the back stack and destroys it
                           // JToE.getInstance().finish();
                            break;
                        case "Credits and thank yous":
                            Intent newMenu4 = new Intent(context, CreditsAndInfo.class);
                            context.startActivity(newMenu4);
                            MainModel.setName("Credits and thank yous");
                        //    JToE.getInstance().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                            //Removes from the back stack and destroys it
                          //  JToE.getInstance().finish();
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

    public void startMain(String main)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Starting: " +main+"?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent newMenu1 = new Intent(context, JToE.class);
                context.startActivity(newMenu1);
                JToE.getInstance().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                //Removes from the back stack and destroys it
                JToE.getInstance().finish();

            }
        });
        builder.show();
    }
    }



