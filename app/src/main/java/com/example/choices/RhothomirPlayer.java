package com.example.choices;

public class RhothomirPlayer {
    private static int character_id;
    private static String name;
    private static String race;
    private static String background;
    private static int strength;
    private static int endurance;
    private static int willpower;
    private static double nextEventID2;
    private static double nextEventID3;
    private static String eventToast1;
    private static String eventToast2;
    private static String eventToast3;
    private static int enemyId;
    private static int enemyCheck;
    private static double currentEventID;
    private static double nextEventID1;
    private static int heath;
    private static int attack;
    private static int defense;

    public static int getPicturUrl() {
        return picturUrl;
    }

    public static void setPicturUrl(int picturUrl) {
        RhothomirPlayer.picturUrl = picturUrl;
    }

    private static int picturUrl;


    public static double getCurrentEventID() {
        return currentEventID;
    }

    public static void setCurrentEventID(double currentEventID) {
        RhothomirPlayer.currentEventID = currentEventID;
    }

    public static double getNextEventID1() {
        return nextEventID1;
    }

    public static void setNextEventID1(double nextEventID1) {
        RhothomirPlayer.nextEventID1 = nextEventID1;
    }

    public static double getNextEventID2() {
        return nextEventID2;
    }

    public static void setNextEventID2(double nextEventID2) {
        RhothomirPlayer.nextEventID2 = nextEventID2;
    }

    public static double getNextEventID3() {
        return nextEventID3;
    }

    public static void setNextEventID3(double nextEventID3) {
        RhothomirPlayer.nextEventID3 = nextEventID3;
    }

    public static String getEventToast1() {
        return eventToast1;
    }

    public static void setEventToast1(String eventToast1) {
        RhothomirPlayer.eventToast1 = eventToast1;
    }

    public static String getEventToast2() {
        return eventToast2;
    }

    public static void setEventToast2(String eventToast2) {
        RhothomirPlayer.eventToast2 = eventToast2;
    }

    public static String getEventToast3() {
        return eventToast3;
    }

    public static void setEventToast3(String eventToast3) {
        RhothomirPlayer.eventToast3 = eventToast3;
    }

    public static int getEnemyId() {
        return enemyId;
    }

    public static void setEnemyId(int enemyId) {
        RhothomirPlayer.enemyId = enemyId;
    }

    public static int getEnemyCheck() {
        return enemyCheck;
    }

    public static void setEnemyCheck(int enemyCheck) {
        RhothomirPlayer.enemyCheck = enemyCheck;
    }

    public static int getCharacter_id() {
        return character_id;
    }

    public static void setCharacter_id(int character_id) {
        RhothomirPlayer.character_id = character_id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        RhothomirPlayer.name = name;
    }

    public static String getRace() {
        return race;
    }

    public static void setRace(String race) {
        RhothomirPlayer.race = race;
    }

    public static String getBackground() {
        return background;
    }

    public static void setBackground(String background) {
        RhothomirPlayer.background = background;
    }

    public static int getStrength() {
        return strength;
    }

    public static void setStrength(int strength) {
        RhothomirPlayer.strength = strength;
    }

    public static int getEndurance() {
        return endurance;
    }

    public static void setEndurance(int endurance) {
        RhothomirPlayer.endurance = endurance;
    }

    public static int getWillpower() {
        return willpower;
    }

    public static void setWillpower(int willpower) {
        RhothomirPlayer.willpower = willpower;
    }



}
