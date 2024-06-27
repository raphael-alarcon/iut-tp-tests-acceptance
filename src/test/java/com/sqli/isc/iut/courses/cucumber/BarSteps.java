package com.sqli.isc.iut.courses.cucumber;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BarSteps {

    private Bar bar;
    private boolean entryAllowed;
    List<Guest> guestsList;
    private float totalBillValue;

    //#region Utility methods
    public List<Guest> stringToGuests(String guests) {
        return Arrays.stream(guests.split(","))
                .map(String::trim)
                .map(Guest::new)
                .toList();
    }

    public List<Guest> findGuests(String guests) {
        return Arrays.stream(guests.split(","))
                .map(String::trim)
                .map(guest -> this.guestsList.stream()
                        .filter(g -> g.getName().equals(guest))
                        .findFirst()
                        .orElse(null))
                .toList();
    }

    public Guest findGuest(String guest) {
        return this.guestsList.stream()
                .filter(g -> g.getName().equals(guest))
                .findFirst()
                .orElse(null);
    }
    //#endregion

    @Given("A new bar {string}")
    public void aNewBar(String barName) {
        this.bar = new Bar(barName);
    }

    @Given("{string} go to the bar")
    public void guestsGoToTheBar(String guests) {
        this.guestsList = stringToGuests(guests);
    }

    @And("there are only {int} seats in the bar")
    public void thereAreOnlySeatsInTheBar(Integer seats) {
        this.bar.setMaxSeats(seats);
    }

    @And("there are already {int} people in the bar")
    public void thereAreAlreadyPeoplePeopleInTheBar(int people) {
        this.bar.setPeople(people);
    }

    @And("the bar is full")
    public void theBarIsFull() {
        assertTrue(this.bar.isFull());
    }

    @But("Another guest tries to enter")
    public void anotherGuestTriesToEnter() {
        this.entryAllowed = this.bar.addPeople(1);
    }

    @When("{string} order {int} {string} at {int}e")
    public void guestsOrderCocktail(String guests, int numberOfCocktailsToOrder, String cocktailName, int price) {
        List<Cocktail> cocktails = Collections.nCopies(numberOfCocktailsToOrder, new Cocktail(cocktailName, price));
        findGuests(guests).forEach(guest -> {
            guest.order(cocktails, numberOfCocktailsToOrder);
            totalBillValue += cocktails.stream().map(Cocktail::getPrice).reduce(0f, Float::sum);
        });
    }

    @And("there is enough room for guests")
    public void thereIsEnoughRoomForGuests() {
        this.entryAllowed = this.bar.addPeople(this.guestsList.size());
    }

    @And("{string} pays for {string}")
    public void guestPaysForOtherGuest(String guest, String otherGuest) {
        Guest payer = findGuest(guest);
        List<Guest> payees = findGuests(otherGuest);
        payees.forEach(payee -> {
            this.totalBillValue -= payee.getBill().value();
            payer.pay(payee.getBill());
        });
    }

    @And("the entry is {word}")
    public void theEntryIsStatus(String status) {
        assertEquals(status, this.entryAllowed ? "allowed" : "refused");
    }

    @Then("at the end of their drinks, {string} check the bill")
    public void atTheEndOfTheirDrinksTheBillIsChecked(String persons) {
        List<Guest> guests = findGuests(persons);
        float guestsBill = guests.stream().map(guest -> guest.getBill().value()).reduce(0f, Float::sum);
        assertEquals(guestsBill, totalBillValue);
    }

    @And("{string} is {word} because {string}")
    public void isEmotionBecauseReason(String guest, String emotion, String reason) {
        Guest emotionalGuest = findGuest(guest);
        emotionalGuest.setLiverIssues(true);
        assertEquals(emotionalGuest.getEmotion(), emotion);
    }

    @But("{string} insists to pay another {string} to {string}")
    public void insistsToPayAnother(String person, String cocktail, String cocktailReceiver) {
        Guest receiver = findGuest(cocktailReceiver);
        receiver.addGiftedCocktail();
    }
}
