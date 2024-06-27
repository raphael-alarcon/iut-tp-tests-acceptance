package com.sqli.isc.iut.courses.cucumber;

import java.util.List;
import java.util.stream.IntStream;

public class Guest {

    private String name;
    private float moneySpent;
    private final Bill bill = new Bill();
    private int numberOfCocktails;
    private boolean liverIssues;

    //region Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoneySpent() {
        return moneySpent;
    }

    public Bill getBill() {
        return bill;
    }

    public boolean isLiverIssues() {
        return liverIssues;
    }

    public void setLiverIssues(boolean liverIssues) {
        this.liverIssues = liverIssues;
    }

    public void addGiftedCocktail() {
        numberOfCocktails++;
    }

    //endregion

    public Guest(String name) {
        this.name = name;
    }

    public void order(Cocktail cocktail) {
        order(List.of(cocktail), 1);
    }

    public void order(List<Cocktail> cocktails, int numberOfCocktailsToOrder) {
        this.bill.addAll(cocktails);
        numberOfCocktails+=numberOfCocktailsToOrder;
    }

    public void pay(Bill bill) {
        this.moneySpent += bill.pay();
    }

    public String getEmotion() {
        return liverIssues && numberOfCocktails > 1 ? "sad" : "happy";
    }
}
