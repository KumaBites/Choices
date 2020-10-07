package com.example.choices.Rhothomir.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.choices.ENTITY.Events;
import com.example.choices.ENTITY.Rhothomir_Player_Database;
import com.example.choices.EventsDatabase;
import com.example.choices.GettingReady.Alan_Event;
import com.example.choices.GettingReady.Alan_EventModel;
import com.example.choices.GettingReady.Alan_EventRecyclerViewAdapter;
import com.example.choices.GettingReady.Alan_Player;
import com.example.choices.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Character_Select extends AppCompatActivity {
    private RecyclerView character_view;
    private List<Character_Select_Model> currentCharacterList;
    private List<Rhothomir_Player_Database> databaseList;
    private CharacterRecyclerViewAdapter eAdapter;
    private String select_name,select_race,select_background,oldUriString, select_strength,select_endurance,select_willpower;
    public int oldSelect_strength,oldSelect_endurance,oldSelect_willpower;
    public String select_uri;
    EventsDatabase eDatabase;
    private static Activity character_select_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character__select);
        character_view =findViewById(R.id.character_select_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        character_view.setLayoutManager(linearLayoutManager);
        eDatabase = EventsDatabase.getDatabase(this);
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

            currentCharacterList.add(new Character_Select_Model(select_name,select_race,select_background,select_strength,select_endurance, select_willpower,select_uri));

        }

        eAdapter = new CharacterRecyclerViewAdapter(currentCharacterList, this);
        character_view.setAdapter(eAdapter);




    }

    private class getEventCallable implements Callable<List<Rhothomir_Player_Database>>

    {
        List<Rhothomir_Player_Database> rList;
        @Override
        public List<Rhothomir_Player_Database> call(){
            rList = eDatabase.rhothomir_dao().getAllPlayers();

            return rList;

        }
    }


}