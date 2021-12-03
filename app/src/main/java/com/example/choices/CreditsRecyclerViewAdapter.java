package com.example.choices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CreditsRecyclerViewAdapter extends RecyclerView.Adapter<CreditsRecyclerViewAdapter.EventViewHolder> {

        private List<CreditModel> menuList;
        Context context;

        public CreditsRecyclerViewAdapter(List<CreditModel> eventList, Context context) {
            this.menuList = eventList;
            this.context = context;
        }

        @Override
        public CreditsRecyclerViewAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflate the layout file
            View EventModelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_credits, parent, false);
            CreditsRecyclerViewAdapter.EventViewHolder gvh = new CreditsRecyclerViewAdapter.EventViewHolder(EventModelView);
            return gvh;
        }

        @Override
        public void onBindViewHolder(CreditsRecyclerViewAdapter.EventViewHolder holder, final int position) {

            holder.mainTextView.setText("Menu Option : "+(menuList.get(position).getCredit()));

        }
        @Override
        public int getItemCount() {
            return menuList.size();
        }

        public class EventViewHolder extends RecyclerView.ViewHolder {
            private TextView mainTextView;

            public EventViewHolder(View view) {
                super(view);
                mainTextView = view.findViewById(R.id.main_credits);

            }
        }


    }



