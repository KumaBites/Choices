package com.example.choices.ENTITY;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Events {

    @PrimaryKey
    private double EventId;
    private String EventName;
    private String EventNameE;
    private int UnitNumber;
    private String EventDescription;
    private String EventQuestion;
    private double NextEventID1;
    private String EventChoice1;
    private String EventChoice1E;
    private double NextEventID2;
    private String EventChoice2;
    private String EventChoice2E;
    private double NextEventID3;
    private String EventChoice3;
    private String EventChoice3E;
    private int EnemyCheck;
    private int EnemyId;
    private int ImageCheck;
    private String ImageName;

    public String getEventNameE() {
        return EventNameE;
    }

    public void setEventNameE(String eventNameE) {
        EventNameE = eventNameE;
    }

    public int getUnitNumber() {
        return UnitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        UnitNumber = unitNumber;
    }

    public String getEventChoice1E() {
        return EventChoice1E;
    }

    public void setEventChoice1E(String eventChoice1E) {
        EventChoice1E = eventChoice1E;
    }

    public String getEventChoice2E() {
        return EventChoice2E;
    }

    public void setEventChoice2E(String eventChoice2E) {
        EventChoice2E = eventChoice2E;
    }

    public String getEventChoice3E() {
        return EventChoice3E;
    }

    public void setEventChoice3E(String eventChoice3E) {
        EventChoice3E = eventChoice3E;
    }

    public int getImageCheck() {
        return ImageCheck;
    }

    public void setImageCheck(int imageCheck) {
        this.ImageCheck = imageCheck;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        this.ImageName = imageName;
    }

    public int getEnemyId() {
        return EnemyId;
    }

    public void setEnemyId(int enemyId) {
        this.EnemyId = enemyId;
    }

    public int getEnemyCheck() {
        return EnemyCheck;
    }

    public void setEnemyCheck(int enemyCheck) {
        this.EnemyCheck = enemyCheck;
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
