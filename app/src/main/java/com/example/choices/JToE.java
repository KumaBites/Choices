package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class JToE extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private JRecyclerViewAdapter mAdapter;
    private List<JModel> debtListArray;
    private static JToE activityHandle = null;

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
        debtListArray.add(new JModel("Japanese to English"));
        debtListArray.add(new JModel("Japanese Only"));
        debtListArray.add(new JModel("Information about app"));
        debtListArray.add(new JModel("Credits and thank yous"));

        debtListArray.add(new JModel("Rhothomir's Crown"));
        debtListArray.add(new JModel("Good Morning!"));
        debtListArray.add(new JModel("Who is this?"));


        //set adapter to recyclerview
        mAdapter = new JRecyclerViewAdapter(debtListArray,this);
        mRecyclerView.setAdapter(mAdapter);

    }
    //Exits app
    public void quitToMain(View view)
    {

        System.exit(0);

    }

    //Returns the instance of the current activity which will be used in the recyclerview to destroy the current activity
    public static JToE getInstance(){
        return activityHandle;
    }


    //Stops back button being pressed
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }
}