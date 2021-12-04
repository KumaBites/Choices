package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class CreditsAndInfo extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CreditsRecyclerViewAdapter mAdapter;
    private List<CreditModel> menuArrayList;
    private static CreditsAndInfo activityHandle = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        activityHandle = this;


        //getting the recyclerview from xml
        mRecyclerView = findViewById(R.id.creditsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        //Populate the list with the game names
        menuArrayList = new ArrayList<>();
        String name = MainModel.getName();
        switch (name) {
            case "Credits and thank yous":
                menuArrayList.add(new CreditModel("Credits and thank yous"));
                //set adapter to recyclerview
                mAdapter = new CreditsRecyclerViewAdapter(menuArrayList, this);
                mRecyclerView.setAdapter(mAdapter);
                break;
            case "Information about app":
                menuArrayList.add(new CreditModel("Information about app"));
                mAdapter = new CreditsRecyclerViewAdapter(menuArrayList, this);
                mRecyclerView.setAdapter(mAdapter);
                break;
        }
    }

    public void quitToMainMenu(View view){
        Intent quit = new Intent(this, Main.class);
        startActivity(quit);
        activityHandle.finish();
        //CreditsAndInfo.activityHandle.overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);

    }
}