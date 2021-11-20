package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.choices.ENTITY.Rhothomir_Player_Database;

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
    private List<Rhothomir_Player_Database> databaseList;
    private CharacterRecyclerViewAdapter eAdapter;
    private String select_name,select_race,select_background,oldUriString, select_strength,select_endurance,select_willpower;
    public int oldSelect_strength,oldSelect_endurance,oldSelect_willpower;
    public String select_uri;
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
        Future<List<Rhothomir_Player_Database>> future = executorService.submit(newEvent);
        List<Rhothomir_Player_Database> result = null;
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
        for (Rhothomir_Player_Database RPD : databaseList) {
            select_name = RPD.getName();
            select_background = RPD.getBackground();
            select_race =RPD.getRace();

            oldSelect_strength = RPD.getStrength();
            select_strength = String.valueOf(oldSelect_strength);

            oldSelect_endurance = RPD.getEndurance();
            select_endurance = String.valueOf(oldSelect_endurance);

            oldSelect_willpower = RPD.getWillpower();
            select_willpower = String.valueOf(oldSelect_willpower);

            select_uri =  RPD.getUri();

            currentCharacterList.add(new CharacterSelectModel(select_name,select_race,select_background,select_strength,select_endurance, select_willpower,select_uri));
        }
        eAdapter = new CharacterRecyclerViewAdapter(currentCharacterList, this);
        character_view.setAdapter(eAdapter);

    }

    //A method creates a callable to get all the characters to populate the card view

    /**
     *
     */
    private class getEventCallable implements Callable<List<Rhothomir_Player_Database>>
    {
        List<Rhothomir_Player_Database> rList;
        @Override
        public List<Rhothomir_Player_Database> call(){
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
    }
}