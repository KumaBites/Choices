package com.example.choices;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.choices.ENTITY.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JMenu extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private JRecyclerViewAdapter mAdapter;
    private List<JModel> debtListArray;
    private static JMenu activityHandle = null;
    List<JModel> allEvents = new ArrayList<>();
    EventsDatabase eDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story__select);
        activityHandle = this;
        eDatabase = EventsDatabase.getDatabase(this);


        //getting the recyclerview from xml
        mRecyclerView = findViewById(R.id.storyRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        //Populate the list with the game names
        debtListArray = new ArrayList<>();
                //set adapter to recyclerview
                mAdapter = new JRecyclerViewAdapter(getJMenuList(), this);
                //set adapter to recyclerview
                mRecyclerView.setAdapter(mAdapter);



        //set adapter to recyclerview


    }

    /* Gets all the data from the database and checks to see if the event id is an integer and then stores the event name and number in an array. The array is then passed to the
    * recyclerview to display to the user*/
    public List<JModel> getJMenuList() {


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        getFantasyEventCallableAll newEvent = new getFantasyEventCallableAll();
        Future<List<Events>> future = executorService.submit(newEvent);
        List<Events> result = null;
        try {
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<Events> allStoryEventList = result;
        String eventName;
        double eventId;
        String name = MainModel.getName();

        for (Events EM : allStoryEventList) {
            if(name.equals("Japanese Only")) {
                if (EM.getEventId() == (int) EM.getEventId()) {
                    eventName = EM.getEventName();
                    eventId = EM.getEventId();
                    allEvents.add(new JModel(eventName, eventId));
                }
            }
            if(name.equals("Japanese to English"))
                if (EM.getEventId() == (int) EM.getEventId()) {
                    eventName = EM.getEventNameE();
                    eventId = EM.getEventId();
                    allEvents.add(new JModel(eventName, eventId));
                }

        }
        return allEvents;
    }
    private class getFantasyEventCallableAll implements Callable<List<Events>>

    {
        List<Events> rList;
        @Override
        public List<Events> call(){
            rList = eDatabase.fantasyDao().getAllEvents();

            return rList;

        }
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