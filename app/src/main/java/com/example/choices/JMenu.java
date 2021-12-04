package com.example.choices;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class JMenu extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private JRecyclerViewAdapter mAdapter;
    private List<JModel> debtListArray;
    private static JMenu activityHandle = null;

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
        String name = MainModel.getName();
        switch (name) {
            case "Japanese to English":
                debtListArray.add(new JModel("Who is this person?"));
                debtListArray.add(new JModel("Mr A and Mr O."));
                debtListArray.add(new JModel("Good Morning."));
                //set adapter to recyclerview
                mAdapter = new JRecyclerViewAdapter(debtListArray, this);
                //set adapter to recyclerview
                mRecyclerView.setAdapter(mAdapter);
                break;
            case "Japanese Only":

                debtListArray.add(new JModel("あの　かたは　どなた　ですか。"));
                debtListArray.add(new JModel("アさん　と　オさん。"));
                debtListArray.add(new JModel("おはようございます。"));
                mAdapter = new JRecyclerViewAdapter(debtListArray, this);
                //set adapter to recyclerview
                mRecyclerView.setAdapter(mAdapter);
                break;
        }

        //set adapter to recyclerview


    }
    //Exits app
    public void quitToMain(View view)
    {

        Intent quit = new Intent(this, Main.class);
        startActivity(quit);
        activityHandle.finish();

    }

    //Returns the instance of the current activity which will be used in the recyclerview to destroy the current activity
    public static JMenu getInstance(){
        return activityHandle;
    }


    //Stops back button being pressed
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }
}