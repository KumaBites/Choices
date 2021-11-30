package com.example.choices;

public class DescriptionModel {

    private String description;
    public String select_drawable_name;



    public DescriptionModel(String description, String drawable){

        this.description = description;
        this.select_drawable_name = drawable;
    }

    public String getSelect_drawable_name() {
        return select_drawable_name;
    }

    public void setSelect_drawable_name(String select_drawable_name) {
        this.select_drawable_name = select_drawable_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
