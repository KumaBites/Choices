package com.example.choices.ENTITY;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Events {


    @PrimaryKey
    private double eventId;

    private String eventName;
    private String eventDescription;
    private double nextEventID1;
    private String eventChoice1;
    private double nextEventID2;
    private String eventChoice2;

    private double nextEventID3;
    private String eventChoice3;
    private String eventToast1;
    private String eventToast2;
    private String eventToast3;
    public String getEventToast1() {
        return eventToast1;
    }

    public void setEventToast1(String eventToast1) {
        this.eventToast1 = eventToast1;
    }

    public String getEventToast2() {
        return eventToast2;
    }

    public void setEventToast2(String eventToast2) {
        this.eventToast2 = eventToast2;
    }

    public String getEventToast3() {
        return eventToast3;
    }

    public void setEventToast3(String eventToast3) {
        this.eventToast3 = eventToast3;
    }



    public double getNextEventID1() {
        return nextEventID1;
    }

    public void setNextEventID1(double nextEventID1) {
        this.nextEventID1 = nextEventID1;
    }

    public double getNextEventID2() {
        return nextEventID2;
    }

    public void setNextEventID2(double nextEventID2) {
        this.nextEventID2 = nextEventID2;
    }

    public double getNextEventID3() {
        return nextEventID3;
    }

    public void setNextEventID3(double nextEventID3) {
        this.nextEventID3 = nextEventID3;
    }




    public double getEventId() {
        return eventId;
    }

    public void setEventId( double eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventChoice1() {
        return eventChoice1;
    }

    public void setEventChoice1(String eventChoice1) {
        this.eventChoice1 = eventChoice1;
    }

    public String getEventChoice2() {
        return eventChoice2;
    }

    public void setEventChoice2(String eventChoice2) {
        this.eventChoice2 = eventChoice2;
    }

    public String getEventChoice3() {
        return eventChoice3;
    }

    public void setEventChoice3(String eventChoice3) {
        this.eventChoice3 = eventChoice3;
    }
}
