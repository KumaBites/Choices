package com.example.choices.DAO;

import com.example.choices.ENTITY.Fantasy_Events;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface Fantasy_Events_Dao {
    @Query("select * from Fantasy_Events")
    List<Fantasy_Events> getAllEvents();

    @Query("select * from Fantasy_Events where fantasyEventId like :eventId")
    List<Fantasy_Events> getSelectEvent(double eventId);
}

