package com.example.choices.ENTITY;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Events {

    @PrimaryKey
    private double EventId;
    private String EventName;
    private String EventDescription;
    private String EventQuestion;
    private double NextEventID1;
    private String EventChoice1;
    private double NextEventID2;
    private String EventChoice2;
    private double NextEventID3;
    private String EventChoice3;
    private int enemyCheck;
    private int enemyId;

    public int getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(int enemyId) {
        this.enemyId = enemyId;
    }

    public int getEnemyCheck() {
        return enemyCheck;
    }

    public void setEnemyCheck(int enemyCheck) {
        this.enemyCheck = enemyCheck;
    }

    public double getEventId() {
        return EventId;
    }

    public void setEventId(double eventId) {
        this.EventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        this.EventName = eventName;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.EventDescription = eventDescription;
    }

    public String getEventQuestion() {
        return EventQuestion;
    }

    public void setEventQuestion(String eventQuestion) {
        EventQuestion = eventQuestion;
    }

    public double getNextEventID1() {
        return NextEventID1;
    }

    public void setNextEventID1(double nextEventID1) {
        this.NextEventID1 = nextEventID1;
    }

    public String getEventChoice1() {
        return EventChoice1;
    }

    public void setEventChoice1(String eventChoice1) {
        this.EventChoice1 = eventChoice1;
    }

    public double getNextEventID2() {
        return NextEventID2;
    }

    public void setNextEventID2(double nextEventID2) {
        this.NextEventID2 = nextEventID2;
    }

    public String getEventChoice2() {
        return EventChoice2;
    }

    public void setEventChoice2(String eventChoice2) {
        this.EventChoice2 = eventChoice2;
    }

    public double getNextEventID3() {
        return NextEventID3;
    }

    public void setNextEventID3(double nextEventID3) {
        this.NextEventID3 = nextEventID3;
    }

    public String getEventChoice3() {
        return EventChoice3;
    }

    public void setEventChoice3(String eventChoice3) {
        this.EventChoice3 = eventChoice3;
    }





}
