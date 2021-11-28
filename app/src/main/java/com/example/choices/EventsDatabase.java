package com.example.choices;

import android.content.Context;

import com.example.choices.DAO.EventsDao;
import com.example.choices.DAO.EnemyDao;
import com.example.choices.DAO.RhothomirDao;
import com.example.choices.ENTITY.Enemy;
import com.example.choices.ENTITY.Events;
import com.example.choices.ENTITY.PlayerDatabase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Enemy.class, Events.class, PlayerDatabase.class}, version = 1, exportSchema =  false)
public abstract class EventsDatabase extends RoomDatabase {



    public abstract EventsDao fantasyDao();
    public abstract EnemyDao fantasyEnemyDao();
    public abstract RhothomirDao rhothomir_dao();
    private static volatile EventsDatabase INSTANCE;

    public static EventsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EventsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EventsDatabase.class, "eventsdb")
                            .createFromAsset("Events.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
                }
        }
        return INSTANCE;
    }
}
