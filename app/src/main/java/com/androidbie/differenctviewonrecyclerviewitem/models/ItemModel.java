package com.androidbie.differenctviewonrecyclerviewitem.models;

/**
 * Created by putuguna on 05/01/17.
 */

public class ItemModel {
    private int index;
    private String description;
    private String name;
    private String city;

    public ItemModel(int index, String description, String name, String city) {
        this.index = index;
        this.description = description;
        this.name = name;
        this.city = city;
    }

    public ItemModel() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
