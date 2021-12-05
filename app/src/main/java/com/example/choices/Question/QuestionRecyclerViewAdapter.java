package com.example.choices.Question;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.choices.Main.MainModel;
import com.example.choices.R;

import java.util.List;


public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<QuestionRecyclerViewAdapter.EventViewHolder> {

    private List<MainModel> eventList;
    Context context;

    public QuestionRecyclerViewAdapter(List<MainModel> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public QuestionRecyclerViewAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View EventModelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_question, parent, false);
        QuestionRecyclerViewAdapter.EventViewHolder gvh = new QuestionRecyclerViewAdapter.EventViewHolder(EventModelView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(QuestionRecyclerViewAdapter.EventViewHolder holder, final int position) {

        holder.questionRecyclerView.setText("Question :"+(eventList.get(position).getMain()));
    }
    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView questionRecyclerView;

        public EventViewHolder(View view) {
            super(view);
            questionRecyclerView = view.findViewById(R.id.question);

        }
    }


}

