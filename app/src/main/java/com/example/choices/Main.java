package com.example.choices;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MainRecyclerViewAdapter mAdapter;
    private List<MainModel> menuArrayList;
    private static Main activityHandle = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            activityHandle = this;


            //getting the recyclerview from xml
            mRecyclerView = findViewById(R.id.mainRecyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            mRecyclerView.setLayoutManager(layoutManager);

            //Populate the list with the game names
            menuArrayList = new ArrayList<>();
            menuArrayList.add(new MainModel("Japanese to English"));
            menuArrayList.add(new MainModel("Japanese Only"));
            menuArrayList.add(new MainModel("Information about app"));
            menuArrayList.add(new MainModel("Credits and thank yous"));

            //set adapter to recyclerview
            mAdapter = new MainRecyclerViewAdapter(menuArrayList,this);
            mRecyclerView.setAdapter(mAdapter);

        }
        //Exits app
        public void quitToMain(View view)
        {

            System.exit(0);

        }

        //Returns the instance of the current activity which will be used in the recyclerview to destroy the current activity
        public static Main getInstance(){
            return activityHandle;
        }


        //Stops back button being pressed
        @SuppressLint("MissingSuperCall")
        @Override
        public void onBackPressed() {

        }
    }

