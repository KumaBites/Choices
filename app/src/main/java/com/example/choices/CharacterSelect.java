package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.choices.ENTITY.PlayerDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CharacterSelect extends AppCompatActivity {
    private RecyclerView character_view;
    private List<CharacterSelectModel> currentCharacterList;
    private List<PlayerDatabase> databaseList;
    private CharacterRecyclerViewAdapter eAdapter;
    private String select_name,select_race,select_background,select_strength, select_health, select_defense;
    public int oldSelect_strength, oldSelect_health, oldSelect_defense;
    public String drawableName;
    public static CharacterSelect activityHandle = null;
    EventsDatabase eDatabase;


    private static Activity character_select_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHandle = this;
        setContentView(R.layout.activity_character__select);
        character_view =findViewById(R.id.character_select_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        character_view.setLayoutManager(linearLayoutManager);


        //Gets database connection
        eDatabase = EventsDatabase.getDatabase(this);



        //Creates new thread and new callable to get characters from the database, and a future to get the data
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        getEventCallable newEvent = new getEventCallable();
        Future<List<PlayerDatabase>> future = executorService.submit(newEvent);
        List<PlayerDatabase> result = null;
        try {
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        databaseList = result;

        // Takes in the result and uses a for loop to get the data to populate the cardview
        currentCharacterList = new ArrayList<>();
        for (PlayerDatabase RPD : databaseList) {
            select_name = RPD.getName();
            select_background = RPD.getBackground();
            select_race =RPD.getRace();

            oldSelect_strength = RPD.getStrength();
            select_strength = String.valueOf(oldSelect_strength);

            oldSelect_health = RPD.getHealth();
            select_health = String.valueOf(oldSelect_health);

            oldSelect_defense = RPD.getDefense();
            select_defense = String.valueOf(oldSelect_defense);

            drawableName =  RPD.getDrawableName();

            currentCharacterList.add(new CharacterSelectModel(select_name,select_race,select_background,select_strength, select_health, select_defense, drawableName));
        }
        eAdapter = new CharacterRecyclerViewAdapter(currentCharacterList, this);
        character_view.setAdapter(eAdapter);

    }

    //A method creates a callable to get all the characters to populate the card view

    /**
     *
     */
    private class getEventCallable implements Callable<List<PlayerDatabase>>
    {
        List<PlayerDatabase> rList;
        @Override
        public List<PlayerDatabase> call(){
            rList = eDatabase.rhothomir_dao().getAllPlayers();

            return rList;

        }
    }
    //Returns the instance of the current activity which will be used in the recyclerview to destroy the current activity

    /**
     *
     * @return
     */
    public static CharacterSelect getInstance(){
        return activityHandle;
    }
    //Quits to main menu

    /**
     *
     * @param view
     */
    public void quitToMainMenu(View view){
        Intent quit = new Intent(this, StorySelect.class);
        startActivity(quit);
        finish();
        //overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}