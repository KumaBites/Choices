package com.example.choices.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.choices.ENTITY.PlayerDatabase;

import java.util.List;

@Dao
public interface RhothomirDao {

    @Query("select * from PlayerDatabase")
    List<PlayerDatabase> getAllPlayers();
}
