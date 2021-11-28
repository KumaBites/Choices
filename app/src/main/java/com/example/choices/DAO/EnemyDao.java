package com.example.choices.DAO;

import com.example.choices.ENTITY.Enemy;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface EnemyDao {

    @Query("select * from Enemy")
    List<Enemy> getAllEvents();

    @Query("select * from Enemy where enemyId like :fantasy_enemyId")
    List<Enemy> getSelectEvent(int fantasy_enemyId);


}
