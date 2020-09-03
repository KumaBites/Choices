package com.example.choices.DAO;

import com.example.choices.ENTITY.Events;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;


@Dao
public interface EventsDao {
    @Query("select * from Events")
    List<Events> getAllEvents();

    @Query("select * from Events where eventId like :eventId")
    List<Events> getSelectEvent(double eventId);
}
