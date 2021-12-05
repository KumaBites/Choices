package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.choices.Character.Player;
import com.example.choices.ENTITY.PlayerDatabase;
import com.example.choices.Events.EventsDatabase;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Rhothomir extends AppCompatActivity {
    EventsDatabase eDatabase;
    private TextView character,name,race,back,will,end,health;
    private List<PlayerDatabase> allPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhothomir);
        eDatabase = EventsDatabase.getDatabase(this);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Rhothomir.getEventCallable newEvent = new getEventCallable();
        Future<List<PlayerDatabase>> future = executorService.submit(newEvent);
        List<PlayerDatabase> result = null;
        try {
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allPlayers = result;
        for (PlayerDatabase RPD : allPlayers) {
            Player.setCharacter_id(RPD.getCharacter_id());
            Player.setName((RPD.getName()));
            Player.setRace(RPD.getRace());
            Player.setBackground(RPD.getBackground());
            Player.setEndurance(RPD.getHealth());
            Player.setStrength(RPD.getStrength());
            Player.setWillpower(RPD.getDefense());

            character = findViewById(R.id.chark);
            character.setText(String.valueOf(Player.getCharacter_id()));

            name = findViewById(R.id.name);
            name.setText(Player.getName());

            race = findViewById(R.id.race);
            race.setText(Player.getRace());

            back = findViewById(R.id.back);
            back.setText(Player.getBackground());

            will = findViewById(R.id.wil);
            will.setText(String.valueOf(Player.getWillpower()));

            end = findViewById(R.id.endu);
            end.setText(String.valueOf(Player.getEndurance()));

            health = findViewById(R.id.heath);
            health.setText(String.valueOf(Player.getStrength()));
        }
    }



    private class getEventCallable implements Callable<List<PlayerDatabase>>
    {
        List<PlayerDatabase> rList;
        @Override
        public List<PlayerDatabase> call(){
            rList = eDatabase.rhothomir_dao().getAllPlayers();
            return rList;

        }
    }
}