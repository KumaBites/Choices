package com.example.choices;

public class EnemyEncounter {

    private static int enemyId;
    private static String enemy_name;
    private static int enemy_health;
    private static int enemy_attack;
    private static int enemy_defense;
    private static double nextEventId;
    public static String uri;


    public static String getUri() {
        return uri;
    }

    public static void setUri(String uri) {
        EnemyEncounter.uri = uri;
    }

    public static int getEnemyId() {
        return enemyId;
    }

    public static void setEnemyId(int enemyId) {
        EnemyEncounter.enemyId = enemyId;
    }

    public static String getEnemy_name() {
        return enemy_name;
    }

    public static void setEnemy_name(String enemy_name) {
        EnemyEncounter.enemy_name = enemy_name;
    }

    public static int getEnemy_health() {
        return enemy_health;
    }

    public static void setEnemy_health(int enemy_health) {
        EnemyEncounter.enemy_health = enemy_health;
    }

    public static int getEnemy_attack() {
        return enemy_attack;
    }

    public static void setEnemy_attack(int enemy_attack) {
        EnemyEncounter.enemy_attack = enemy_attack;
    }

    public static int getEnemy_defense() {
        return enemy_defense;
    }

    public static void setEnemy_defense(int enemy_defense) {
        EnemyEncounter.enemy_defense = enemy_defense;
    }

    public static double getNextEventId() {
        return nextEventId;
    }

    public static void setNextEventId(double nextEventId) {
        EnemyEncounter.nextEventId = nextEventId;
    }


}

