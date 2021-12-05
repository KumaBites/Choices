package com.example.choices.Events;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.choices.Battle.Battle;
import com.example.choices.Description.DescriptionModel;
import com.example.choices.Description.DescriptionRecyclerViewAdapter;
import com.example.choices.ENTITY.Events;
import com.example.choices.Battle.EnemyEncounter;
import com.example.choices.JMenu.JMenu;
import com.example.choices.Main.MainModel;
import com.example.choices.Character.Player;
import com.example.choices.Question.QuestionRecyclerViewAdapter;
import com.example.choices.R;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Event extends AppCompatActivity {
    private RecyclerView event, eventDescription, eventQuestion;
    private List<EventModel> currentEventListChoices;
    private List<MainModel> questionEventList;
    private List<DescriptionModel> descriptionEventList;
    private List<Events> allStoryEventList;
    private EventRecyclerViewAdapter eAdapter;
    private QuestionRecyclerViewAdapter qAdapter;
    private DescriptionRecyclerViewAdapter dAdapter;
    private TextView eventTitle;
    private int enemyId, enemyCheck, imageCheck;
    private double currentEventID;
    EventsDatabase eDatabase;
    private static Event activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        event = findViewById(R.id.EventRecyclerView);
        eventDescription = findViewById(R.id.descriptionRecyclerView);
        eventQuestion = findViewById(R.id.questionRecyclerView);

        eventTitle = findViewById(R.id.EventTitle);
        currentEventID = Player.getCurrentEventID();
        eDatabase = EventsDatabase.getDatabase(this);
        currentEventID = Player.getCurrentEventID();
        enemyCheck = Player.getEnemyCheck();
        activity = this;
        imageCheck = 0;

        if (currentEventID == 0.0) {

            storyEndAlert();

        } else if (enemyCheck == 1) {
            Intent battle = new Intent(this, Battle.class);
            startActivity(battle);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();

        } else {
            event.setLayoutManager(new LinearLayoutManager(this));
            eventQuestion.setLayoutManager(new LinearLayoutManager((this)));
            eventDescription.setLayoutManager(new LinearLayoutManager((this)));

//Checks static variable to check which data to get from the database, English or Japanese translation.

            if (MainModel.getName().equals("Japanese Only")) {
                eAdapter = new EventRecyclerViewAdapter(getAllEventsJ().getEventList(), this);
                event.setAdapter(eAdapter);

                qAdapter = new QuestionRecyclerViewAdapter(getAllEventsJ().getQuestionList(),this);
                eventQuestion.setAdapter(qAdapter);

                dAdapter = new DescriptionRecyclerViewAdapter(getAllEventsJ().getdList(),this, imageCheck);
                eventDescription.setAdapter(dAdapter);
            } else if ((MainModel.getName().equals("Japanese to English"))) {


                eAdapter = new EventRecyclerViewAdapter(getAllEventsE().getEventList(), this);
                event.setAdapter(eAdapter);

                qAdapter = new QuestionRecyclerViewAdapter(getAllEventsE().getQuestionList(),this);
                eventQuestion.setAdapter(qAdapter);

                dAdapter = new DescriptionRecyclerViewAdapter(getAllEventsE().getdList(),this, imageCheck);
                eventDescription.setAdapter(dAdapter);
            }

        }



    }
//Checks event id, if its 0.0 then this message will appear and send the user to the main activity.
    private void storyEndAlert() {
        final Intent finish = new Intent(this, JMenu.class);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You have completed your reading! Why not try one of the other stories?");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(finish);
                finish();

            }
        });
        builder.show();
    }

    private class getEventCallable implements Callable<List<Events>> {
        List<Events> rList;

        @Override
        public List<Events> call() {
            rList = eDatabase.fantasyDao().getSelectEvent(currentEventID);

            return rList;

        }
    }
    //Gets the English data from the database

    public getArrayData getAllEventsE() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        getEventCallable newEvent = new getEventCallable();
        Future<List<Events>> future = executorService.submit(newEvent);
        List<Events> result = null;
        try {
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        allStoryEventList = result;
        currentEventListChoices = new ArrayList<>();
        questionEventList = new ArrayList<>();
        descriptionEventList = new ArrayList<>();
        for (Events EM : allStoryEventList) {
            imageCheck = EM.getImageCheck();

            Player.setNextEventID1(EM.getNextEventID1());
            Player.setNextEventID2(EM.getNextEventID2());
            Player.setNextEventID3(EM.getNextEventID3());

            enemyCheck = EM.getEnemyCheck();
            Player.setEnemyCheck(enemyCheck);

            enemyId = EM.getEnemyId();
            EnemyEncounter.setEnemyId(enemyId);

            eventTitle.setText(EM.getEventName());

            String eventChoice1 = EM.getEventChoice1E();
            String eventChoice2 = EM.getEventChoice2E();
            String eventChoice3 = EM.getEventChoice3E();
            String question = EM.getEventQuestion();
            String description = EM.getEventDescription();
            String image = EM.getImageName();

            currentEventListChoices.add(new EventModel(eventChoice1, eventChoice2, eventChoice3));
            questionEventList.add(new MainModel(question));
            descriptionEventList.add((new DescriptionModel(description, image)));
        }
        getArrayData arrayData = new getArrayData(currentEventListChoices,questionEventList,descriptionEventList);
        return arrayData;
    }
    //Gets the Japanese data from the database
        public getArrayData getAllEventsJ ()
        {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            getEventCallable newEvent = new getEventCallable();
            Future<List<Events>> future = executorService.submit(newEvent);
            List<Events> result = null;
            try {
                result = future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            allStoryEventList = result;
            currentEventListChoices = new ArrayList<>();
            questionEventList = new ArrayList<>();
            descriptionEventList = new ArrayList<>();
            for (Events EM : allStoryEventList) {

                imageCheck = EM.getImageCheck();
                Player.setNextEventID1(EM.getNextEventID1());
                Player.setNextEventID2(EM.getNextEventID2());
                Player.setNextEventID3(EM.getNextEventID3());

                enemyCheck = EM.getEnemyCheck();
                Player.setEnemyCheck(enemyCheck);

                enemyId = EM.getEnemyId();
                EnemyEncounter.setEnemyId(enemyId);

                eventTitle.setText(EM.getEventName());

                String eventChoice1 = EM.getEventChoice1();
                String eventChoice2 = EM.getEventChoice2();
                String eventChoice3 = EM.getEventChoice3();
                String question = EM.getEventQuestion();
                String description = EM.getEventDescription();
                String image = EM.getImageName();

                currentEventListChoices.add(new EventModel(eventChoice1, eventChoice2, eventChoice3));
                questionEventList.add(new MainModel(question));
                descriptionEventList.add((new DescriptionModel(description, image)));
            }
            getArrayData arrayData = new getArrayData(currentEventListChoices,questionEventList,descriptionEventList);
            return arrayData;
        }

        public void quit (View view){

            Intent quit = new Intent(this, JMenu.class);
            startActivity(quit);
            finish();

        }
        @SuppressLint("MissingSuperCall")
        @Override
        public void onBackPressed () {

        }
        //Gets a handle on the current activity to be destroyed in the adapter view
        public static Activity getInstance () {
            return activity;
        }
    }


