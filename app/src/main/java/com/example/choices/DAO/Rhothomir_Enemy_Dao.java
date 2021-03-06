package com.example.choices.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.choices.ENTITY.Rhothomir_Enemy_Database;
import com.example.choices.ENTITY.Rhothomir_Player_Database;

import java.util.List;

@Dao
public interface Rhothomir_Enemy_Dao {

    @Query("select * from Rhothomir_Enemy_Database")
    List<Rhothomir_Enemy_Database> getAllPlayers();
}
