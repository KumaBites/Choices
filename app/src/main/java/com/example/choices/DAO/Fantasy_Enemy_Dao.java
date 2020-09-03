package com.example.choices.DAO;

import com.example.choices.ENTITY.Fantasy_Enemy;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface Fantasy_Enemy_Dao {

    @Query("select * from Fantasy_Enemy")
    List<Fantasy_Enemy> getAllEvents();

    @Query("select * from Fantasy_Enemy where enemyId like :fantasy_enemyId")
    List<Fantasy_Enemy> getSelectEvent(int fantasy_enemyId);


}
