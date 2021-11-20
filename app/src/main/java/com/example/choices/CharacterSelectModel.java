package com.example.choices;

public class CharacterSelectModel {
    public String select_name;
    public String select_race;
    public String select_background;
    public String select_strength;
    public String select_endurance;
    public String select_willpower;
    public String select_uri;

    public CharacterSelectModel(String select_name, String select_race, String select_background, String select_strength, String select_endurance, String select_willpower, String select_uri)

    {
        this.select_name = select_name;
        this.select_race = select_race;
        this.select_background = select_background;
        this.select_strength = select_strength;
        this.select_endurance = select_endurance;
        this.select_willpower = select_willpower;
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

    public String getSelect_strength() {
        return select_strength;
    }

    public void setSelect_strength(String select_strength) {
        this.select_strength = select_strength;
    }

    public String getSelect_endurance() {
        return select_endurance;
    }

    public void setSelect_endurance(String select_endurance) {
        this.select_endurance = select_endurance;
    }

    public String getSelect_willpower() {
        return select_willpower;
    }

    public void setSelect_willpower(String select_willpower) {
        this.select_willpower = select_willpower;
    }

    public String getSelect_uri() {
        return select_uri;
    }

    public void setSelect_uri(String select_uri) {
        this.select_uri = select_uri;
    }


}
