package com.example.choices;

public class JModel {

    private String menu;
    static String jName;



    public JModel(String menu){

        this.menu = menu;
    }

    public static String getjName() {
        return jName;
    }

    public static void setjName(String jName) {
        JModel.jName = jName;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
