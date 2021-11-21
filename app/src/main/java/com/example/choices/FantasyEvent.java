package com.example.choices;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.choices.ENTITY.Fantasy_Enemy;
import com.example.choices.ENTITY.Fantasy_Events;


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


public class FantasyEvent extends AppCompatActivity {
    private RecyclerView event;
    private List<FantasyEventModel> currentEventList;
    private List<String> currentEventdescription;
    private List<Fantasy_Events> allStoryEventList;
    private List<Fantasy_Enemy> enemyEventList;
    private FantasyEventRecyclerViewAdapter eAdapter;
    private TextView eventTitle, eventDescription ;
    private int enemyId, enemyCheck;
    private double currentEventID ,nextID, nextID2,nextID3;
    EventsDatabase eDatabase;
    private static FantasyEvent activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        event = findViewById(R.id.EventRecyclerView);
        eventDescription = findViewById(R.id.EventDescription);
        eventTitle = findViewById(R.id.EventTitle);
        currentEventID = RhothomirPlayer.getCurrentEventID();
        eDatabase = EventsDatabase.getDatabase(this);
        currentEventID = RhothomirPlayer.getCurrentEventID();
        enemyCheck = RhothomirPlayer.getEnemyCheck();
        activity = this;

        if(currentEventID == 0.0)
        {

        storyEndAlert();

        }
        else if(enemyCheck==1){
            Intent battle = new Intent(this, FantasyBattle.class);
            startActivity(battle);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();

            }

        else {
            event.setLayoutManager(new LinearLayoutManager(this));
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            getFantasyEventCallable newEvent = new getFantasyEventCallable();
            Future<List<Fantasy_Events>> future = executorService.submit(newEvent);
            List<Fantasy_Events> result = null;
            try {
                result = future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            allStoryEventList =result;
            currentEventList = new ArrayList<>();

            for (Fantasy_Events EM : allStoryEventList) {
              RhothomirPlayer.setNextEventID1(EM.getFantasyNextEventID1());
              RhothomirPlayer.setNextEventID2(EM.getFantasyNextEventID2());
              RhothomirPlayer.setNextEventID3(EM.getFantasyNextEventID3());
              RhothomirPlayer.setEventToast1(EM.getFantasyEventToast1());
              RhothomirPlayer.setEventToast2(EM.getFantasyEventToast2());
              RhothomirPlayer.setEventToast3(EM.getFantasyEventToast3());

                enemyCheck = EM.getEnemyCheck();
                RhothomirPlayer.setEnemyCheck(enemyCheck);

                enemyId = EM.getEnemyId();
                FantasyEnemyEncounter.setEnemyId(enemyId);

               eventTitle.setText(EM.getFantasyEventName());
               eventDescription.setText(EM.getFantasyEventDescription());



                String eventChoice1 = EM.getFantasyEventChoice1();
                String eventChoice2 = EM.getFantasyEventChoice2();
                String eventChoice3 = EM.getFantasyEventChoice3();

                currentEventList.add(new FantasyEventModel( eventChoice1, eventChoice2, eventChoice3));
            }

            eAdapter = new FantasyEventRecyclerViewAdapter(currentEventList, this);
            event.setAdapter(eAdapter);


        }
    }
    private void storyEndAlert() {
        final Intent finish = new Intent(this, StorySelect.class);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You have completed Alan's dilemma! Why not try one of the other stories?");
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
    private class getFantasyEventCallable implements Callable<List<Fantasy_Events>>

    {
        List<Fantasy_Events> rList;
        @Override
        public List<Fantasy_Events> call(){
           rList = eDatabase.fantasyDao().getSelectEvent(currentEventID);

            return rList;

        }
    }


    public void quit (View view){

        Intent quit = new Intent(this, StorySelect.class);
        startActivity(quit);
        finish();

    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }
    //Gets a handle on the current activity to be destroyed in the adapter view
    public static Activity getInstance(){
        return  activity;
    }
}

