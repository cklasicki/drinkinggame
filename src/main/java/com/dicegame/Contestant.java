package com.dicegame;

public class Contestant {

    private String name;
    private float weight;

    Contestant(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public float getWeight() {
        return this.weight;
    }
}