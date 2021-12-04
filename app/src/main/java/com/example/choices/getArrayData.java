package com.example.choices;

import java.util.List;

public class getArrayData {
    List<EventModel> eventList;
    List<MainModel> questionList;
    List<DescriptionModel> dList;
    public  getArrayData(List<EventModel> eventList, List<MainModel> questionList, List<DescriptionModel> dList)
    {
        this.eventList = eventList;
        this.questionList = questionList;
        this.dList = dList;

    }

    public List<EventModel> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventModel> eventList) {
        this.eventList = eventList;
    }

    public List<MainModel> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<MainModel> questionList) {
        this.questionList = questionList;
    }

    public List<DescriptionModel> getdList() {
        return dList;
    }

    public void setdList(List<DescriptionModel> dList) {
        this.dList = dList;
    }
}
