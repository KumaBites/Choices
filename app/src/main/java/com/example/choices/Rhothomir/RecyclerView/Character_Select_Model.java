package com.example.choices.Rhothomir.RecyclerView;

import android.net.Uri;

public class Character_Select_Model {
    public String select_name;
    public String select_race;
    public String select_background;
    public int select_strength;
    public int select_endurance;
    public int select_willpower;
    public Uri select_uri;

    public Character_Select_Model(String select_name,String select_race,String select_background, int select_strength, int select_endurance, int select_willpower,Uri select_uri)

    {
        this.select_name = select_name;
        this.select_race = select_race;
        this.select_background = select_background;
        this.select_strength = select_strength;
        this.select_endurance = select_endurance;
        this.select_willpower = select_endurance;
        this.select_uri = select_uri;
    }
    public String getSelect_name() {
        return select_name;
    }

    public void setSelect_name(String select_name) {
        this.select_name = select_name;
    }

    public String getSelect_race() {
        return select_race;
    }

    public void setSelect_race(String select_race) {
        this.select_race = select_race;
    }

    public String getSelect_background() {
        return select_background;
    }

    public void setSelect_background(String select_background) {
        this.select_background = select_background;
    }

    public int getSelect_strength() {
        return select_strength;
    }

    public void setSelect_strength(int select_strength) {
        this.select_strength = select_strength;
    }

    public int getSelect_endurance() {
        return select_endurance;
    }

    public void setSelect_endurance(int select_endurance) {
        this.select_endurance = select_endurance;
    }

    public int getSelect_willpower() {
        return select_willpower;
    }

    public void setSelect_willpower(int select_willpower) {
        this.select_willpower = select_willpower;
    }

    public Uri getSelect_uri() {
        return select_uri;
    }

    public void setSelect_uri(Uri select_uri) {
        this.select_uri = select_uri;
    }


}
