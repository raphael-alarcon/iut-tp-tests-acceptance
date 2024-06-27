package com.sqli.isc.iut.courses.cucumber;

public class Cocktail {

    private String name;
    private final float price;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    Cocktail(String name, float price) {
        this.name = name;
        this.price = price;
    }

}
