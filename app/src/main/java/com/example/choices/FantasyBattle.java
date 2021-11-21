package com.example.choices;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.choices.ENTITY.Fantasy_Enemy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FantasyBattle extends AppCompatActivity {
    private Random player_number, enemy_number;
    private int player_health, player_attack, player_defense, player_added_attack, player_added_defense;
    private int enemy_health, enemy_attack, enemy_defense, enemy_added_attack, enemy_added_defense;
    private int player_total_attack, player_total_defense, enemy_total_defense, enemy_total_attack;
    private int pbattle_result, eBattle_result;

    Button battleButton;
    private  int enemyId;
    private double nextEventId;
    private ImageView player, enemy;
    private TextView pHealth, pAttack, pDefense, eHealth, eAttack,eDefense ,pName,eName,battleTitle;
    EventsDatabase eDatabase;
    MediaPlayer mediaPlayer;
    public static FantasyBattle activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fantasy_battle);
        eDatabase = EventsDatabase.getDatabase(this);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.battle);
        activity = this;
        mediaPlayer.start();
        battleTitle = findViewById(R.id.battleTitle);
        battleButton = (Button)findViewById(R.id.buttonBattle);
        pName =findViewById(R.id.playerNameView);
        pHealth = findViewById(R.id.pHealthView);
        pAttack =findViewById(R.id.pAttack);
        pDefense = findViewById(R.id.pDefense);
        player = findViewById(R.id.imageView);

        eName =findViewById(R.id.eNameView);
        eHealth =findViewById(R.id.eHealthView);
        eAttack =findViewById(R.id.eAttackView);
        eDefense =findViewById(R.id.eDefenseView);
        enemy = findViewById(R.id.imageView2);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        getEnemyCallable newEvent = new getEnemyCallable();
        Future<List<Fantasy_Enemy>> future = executorService.submit(newEvent);
        List<Fantasy_Enemy> result = null;
        try {
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Fantasy_Enemy> enemyEventList = result;
        for(Fantasy_Enemy newEnemy : enemyEventList){
            FantasyEnemyEncounter.setEnemyId(newEnemy.getEnemyId());
            FantasyEnemyEncounter.setEnemy_attack(newEnemy.getEnemy_attack());
            FantasyEnemyEncounter.setEnemy_health(newEnemy.getEnemy_health());
            FantasyEnemyEncounter.setEnemy_defense(newEnemy.getEnemy_defense());
            FantasyEnemyEncounter.setEnemy_name(newEnemy.getEnemy_name());
            FantasyEnemyEncounter.setNextEventId(newEnemy.getNextEventId());
            FantasyEnemyEncounter.setUri(newEnemy.getUri());
        }
        battleTitle.setText("Battle!!");
        pName.setText(String.valueOf(RhothomirPlayer.getName()));
        player_health = RhothomirPlayer.getEndurance();
        player_attack = RhothomirPlayer.getStrength();
        player_defense = RhothomirPlayer.getWillpower();
        player.setImageResource(RhothomirPlayer.getPicturUrl());
        nextEventId = FantasyEnemyEncounter.getNextEventId();

        eName.setText(FantasyEnemyEncounter.getEnemy_name());
        enemy_health = FantasyEnemyEncounter.getEnemy_health();
        enemy_attack = FantasyEnemyEncounter.getEnemy_attack();
        enemy_defense= FantasyEnemyEncounter.getEnemy_defense();
        String newEnemy = FantasyEnemyEncounter.getUri();
        int drawId = this.getResources().getIdentifier(newEnemy,"drawable", getApplicationContext().getPackageName());
        enemy.setImageResource(drawId);


        pHealth.setText("Player Health: "+ String.valueOf(player_health));
        pAttack.setText("Player Attack: "+ String.valueOf(player_attack));
        pDefense.setText("Player Defense: "+String.valueOf(player_defense));


        eHealth.setText("Enemy Health: "+String.valueOf(enemy_health));
        eAttack.setText("Enemy Attack: "+String.valueOf(enemy_attack));
        eDefense.setText("Enemy Defense: "+String.valueOf(enemy_defense));


        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation bounce = AnimationUtils.loadAnimation(FantasyBattle.this, R.anim.bounce);
                battleButton.startAnimation(bounce);
                battleCheck();

            }
        });
    }




    public void playerAttacks() {
        player_number = new Random();
        enemy_number = new Random();
        player_added_attack = player_number.nextInt(6);
        enemy_added_defense = enemy_number.nextInt(6);
        player_total_attack = RhothomirPlayer.getStrength() + player_added_attack;
        enemy_total_defense = FantasyEnemyEncounter.getEnemy_defense() + enemy_added_defense;
        pbattle_result = enemy_total_defense - player_total_attack;
        enemy_health = enemy_health - Math.abs(pbattle_result);
        FantasyEnemyEncounter.setEnemy_health(enemy_health);
        eHealth.setText("Enemy Health: "+String.valueOf(FantasyEnemyEncounter.getEnemy_health()));

    }

    public void enemyAttacks() {
        player_number = new Random();
        enemy_number = new Random();
        player_added_defense = player_number.nextInt(6);
        enemy_added_attack = enemy_number.nextInt(6);
        player_total_defense = player_defense + player_added_defense;
        enemy_total_attack = enemy_attack + enemy_added_attack;
        eBattle_result = player_total_defense - enemy_total_attack;
        player_health = player_health - Math.abs(eBattle_result);
        RhothomirPlayer.setEndurance(player_health);
        pHealth.setText("Player Health: "+String.valueOf(RhothomirPlayer.getEndurance()));
  }

    /**
     *
     */
  public void battleCheck(){
      final Intent died = new Intent(this, StorySelect.class);
      final Intent survive = new Intent(this, FantasyEvent.class);
      final int eHCheck = FantasyEnemyEncounter.getEnemy_health();
      final int pHCheck = RhothomirPlayer.getEndurance();

      if ((eHCheck > 0 && pHCheck > 0)){
          playerAttacks();
          enemyAttacks();
          AlertDialog.Builder builder = new AlertDialog.Builder(this);
          builder.setMessage("You did " + Math.abs(pbattle_result) + " damage but the " + FantasyEnemyEncounter.getEnemy_name() + " did " + Math.abs(eBattle_result) + " damage!");
          builder.setCancelable(false);
          builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
              }
          });
          builder.show();

      }
         else if (pHCheck <= 0) {

          AlertDialog.Builder diedBuilder = new AlertDialog.Builder(this);
          diedBuilder.setMessage("You have died!!! Oh well luck was one your side. Why not try again?");
          diedBuilder.setCancelable(false);
          diedBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  mediaPlayer.release();;
                  RhothomirPlayer.setCurrentEventID(nextEventId);
                  startActivity(died);
                  getInstance().finish();


              }
          });
          diedBuilder.show();
      }
      else if(eHCheck <= 0){

          AlertDialog.Builder wonBuilder = new AlertDialog.Builder(this);
          wonBuilder.setMessage("You have won!! Congratulations! On with the adventure");
          wonBuilder.setCancelable(false);
          wonBuilder.setPositiveButton("Lets continue with the adventure!", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  mediaPlayer.release();
                  RhothomirPlayer.setEnemyCheck(0);
                  startActivity(survive);
                  //overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                  getInstance().finish();

              }
          });
          wonBuilder.show();
      }



  }
    public static FantasyBattle getInstance(){
        return  activity;
    }

    private class getEnemyCallable implements Callable<List<Fantasy_Enemy>>
    {
        List<Fantasy_Enemy> rList;
        @Override
        public List<Fantasy_Enemy> call(){
            rList = eDatabase.fantasyEnemyDao().getSelectEvent(FantasyEnemyEncounter.getEnemyId());


            return rList;

        }
    }
}
