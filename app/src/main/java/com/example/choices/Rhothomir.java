package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.choices.ENTITY.Rhothomir_Player_Database;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Rhothomir extends AppCompatActivity {
    EventsDatabase eDatabase;
    private TextView character,name,race,back,will,end,health;
    private List<Rhothomir_Player_Database> allPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhothomir);
        eDatabase = EventsDatabase.getDatabase(this);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Rhothomir.getEventCallable newEvent = new getEventCallable();
        Future<List<Rhothomir_Player_Database>> future = executorService.submit(newEvent);
        List<Rhothomir_Player_Database> result = null;
        try {
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allPlayers = result;
        for (Rhothomir_Player_Database RPD : allPlayers) {
            Rhothomir_Player.setCharacter_id(RPD.getCharacter_id());
            Rhothomir_Player.setName((RPD.getName()));
            Rhothomir_Player.setRace(RPD.getRace());
            Rhothomir_Player.setBackground(RPD.getBackground());
            Rhothomir_Player.setEndurance(RPD.getEndurance());
            Rhothomir_Player.setStrength(RPD.getStrength());
            Rhothomir_Player.setWillpower(RPD.getWillpower());

            character = findViewById(R.id.chark);
            character.setText(String.valueOf(Rhothomir_Player.getCharacter_id()));

            name = findViewById(R.id.name);
            name.setText(Rhothomir_Player.getName());

            race = findViewById(R.id.race);
            race.setText(Rhothomir_Player.getRace());

            back = findViewById(R.id.back);
            back.setText(Rhothomir_Player.getBackground());

            will = findViewById(R.id.wil);
            will.setText(String.valueOf(Rhothomir_Player.getWillpower()));

            end = findViewById(R.id.endu);
            end.setText(String.valueOf(Rhothomir_Player.getEndurance()));

            health = findViewById(R.id.heath);
            health.setText(String.valueOf(Rhothomir_Player.getStrength()));
        }
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