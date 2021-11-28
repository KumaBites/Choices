package com.example.choices.ENTITY;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlayerDatabase {
    @PrimaryKey
    private int character_id;
    private String name;
    private String race;
    private String background;
    private int strength;
    private int health;
    private int defense;
    private String drawableName;
    public String getDrawableName() {
        return drawableName;
    }

    public void setDrawableName(String drawableName) {
        this.drawableName = drawableName;
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



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }


}
