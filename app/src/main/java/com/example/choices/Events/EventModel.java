package com.example.choices.Events;

public class EventModel {


    private String eventChoice1;
    private String eventChoice2;
    private String eventChoice3;


    public EventModel(String eventChoice1, String eventChoice2, String eventChoice3){

        this.eventChoice1 = eventChoice1;
        this.eventChoice2 = eventChoice2;
        this.eventChoice3 = eventChoice3;


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
