package com.example.choices;

public class CharacterSelectModel {
    public String select_name;
    public String select_race;
    public String select_background;
    public String select_strength;
    public String select_health;
    public String select_defense;
    public String select_drawable_name;

    public CharacterSelectModel(String select_name, String select_race, String select_background, String select_strength, String select_health, String select_defense, String select_drawable_name)

    {
        this.select_name = select_name;
        this.select_race = select_race;
        this.select_background = select_background;
        this.select_strength = select_strength;
        this.select_health = select_health;
        this.select_defense = select_defense;
        this.select_drawable_name = select_drawable_name;
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

    public String getSelect_health() {
        return select_health;
    }

    public void setSelect_health(String select_health) {
        this.select_health = select_health;
    }

    public String getSelect_defense() {
        return select_defense;
    }

    public void setSelect_defense(String select_defense) {
        this.select_defense = select_defense;
    }

    public String getSelect_drawable_name() {
        return select_drawable_name;
    }

    public void setSelect_drawable_name(String select_drawable_name) {
        this.select_drawable_name = select_drawable_name;
    }


}
