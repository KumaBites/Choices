package com.example.choices.JMenu;

public class JModel {

    private String menu;
    private double menuId;
    static String jName;



    public JModel(String menu, double eventId){

        this.menu = menu;
        this.menuId = eventId;
    }

    public static String getjName() {
        return jName;
    }

    public double getMenuId() {
        return menuId;
    }

    public void setMenuId(double menuId) {
        this.menuId = menuId;
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
