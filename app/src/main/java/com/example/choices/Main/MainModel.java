package com.example.choices.Main;

public class MainModel {

    private String main;
    static String name;



    public MainModel(String main){

        this.main = main;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        MainModel.name = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String storyName) {
        this.main = main;
    }
}
