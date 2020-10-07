package com.example.choices.ENTITY;

import android.net.Uri;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Rhothomir_Player_Database {
    @PrimaryKey
    private int character_id;
    private String name;
    private String race;
    private String background;
    private int strength;
    private int endurance;
    private int willpower;
    private String uri;
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }



    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(int character_id) {
        this.character_id = character_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }



    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }


}
