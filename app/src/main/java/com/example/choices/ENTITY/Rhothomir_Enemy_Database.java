package com.example.choices.ENTITY;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Rhothomir_Enemy_Database {
    @PrimaryKey
    private int Echaracter_id;
    private String Ename;
    private String Erace;
    private String Ebackground;
    private int Estrength;
    private int Eendurance;
    private int Ewillpower;
    private String Euri;

    public int getEcharacter_id() {
        return Echaracter_id;
    }

    public void setEcharacter_id(int echaracter_id) {
        Echaracter_id = echaracter_id;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getErace() {
        return Erace;
    }

    public void setErace(String erace) {
        Erace = erace;
    }

    public String getEbackground() {
        return Ebackground;
    }

    public void setEbackground(String ebackground) {
        Ebackground = ebackground;
    }

    public int getEstrength() {
        return Estrength;
    }

    public void setEstrength(int estrength) {
        Estrength = estrength;
    }

    public int getEendurance() {
        return Eendurance;
    }

    public void setEendurance(int eendurance) {
        Eendurance = eendurance;
    }

    public int getEwillpower() {
        return Ewillpower;
    }

    public void setEwillpower(int ewillpower) {
        Ewillpower = ewillpower;
    }

    public String getEuri() {
        return Euri;
    }

    public void setEuri(String euri) {
        Euri = euri;
    }
}
