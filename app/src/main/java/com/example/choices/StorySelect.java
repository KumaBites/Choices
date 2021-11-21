package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StorySelect extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private StoryRecyclerViewAdapter mAdapter;
    private List<StorySelectModel> debtListArray;
    private static StorySelect activityHandle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story__select);
        activityHandle = this;


        //getting the recyclerview from xml
        mRecyclerView = findViewById(R.id.storyRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        //Populate the list with the game names
        debtListArray = new ArrayList<>();
        debtListArray.add(new StorySelectModel("Rhothomir's Crown"));


        //set adapter to recyclerview
        mAdapter = new StoryRecyclerViewAdapter(debtListArray,this);
        mRecyclerView.setAdapter(mAdapter);

    }
    //Exits app
    public void quitToMain(View view)
    {

        System.exit(0);

    }

    //Returns the instance of the current activity which will be used in the recyclerview to destroy the current activity
    public static StorySelect getInstance(){
        return activityHandle;
    }


    //Stops back button being pressed
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }
}