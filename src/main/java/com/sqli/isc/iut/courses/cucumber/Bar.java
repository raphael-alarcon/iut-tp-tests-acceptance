package com.sqli.isc.iut.courses.cucumber;

import java.util.*;

public class Bar {

    //#region Properties
    private int maxSeats;
    private int people;
    private final String name;
    //#endregion

    //#region Getters & Setters

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int max_seats) {
        this.maxSeats = max_seats;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
    //#endregion

    public Bar(String name) {
        this.name = name;
    }

    public boolean addPeople(int numberOfPeople) {
        if (this.people + numberOfPeople <= this.maxSeats) {
            this.people += numberOfPeople;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return this.people == this.maxSeats;
    }
}
