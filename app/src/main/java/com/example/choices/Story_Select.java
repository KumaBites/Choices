package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Story_Select extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private StoryRecyclerViewAdapter mAdapter;
    private List<StoryModel> debtListArray;
    private static Story_Select activityHandle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story__select);



        //getting the recyclerview from xml
        mRecyclerView = findViewById(R.id.storyRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Populate the products

        debtListArray = new ArrayList<>();
        debtListArray.add(new StoryModel("Fantasy"));
        debtListArray.add(new StoryModel("Alan's Dilemma"));



        //set adapter to recyclerview
        mAdapter = new StoryRecyclerViewAdapter(debtListArray,this);
        mRecyclerView.setAdapter(mAdapter);

    }
    public void quitToMain(View view)
    {
        System.exit(0);
    }
    //Returns the instance of the current activity which will be used in the recyclerview
    public static Story_Select getInstance(){
        return activityHandle;
    }



    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }
}