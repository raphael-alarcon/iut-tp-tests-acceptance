package com.sqli.isc.iut.courses.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BarSteps {

    @Given("a group of people go to the bar Le Juste, which is a cocktail bar")
    public void aGroupOfPeopleGoToTheBarLeJusteWhichIsACocktailBar() {
    }

    @Given("there are only {int} seats in the bar")
    public void there_are_only_seats_in_the_bar(Integer seats) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the entry is refused because the bar is full")
    public void theEntryIsRefusedBecauseTheBarIsFull() {
    }

    @When("{int} people arrive and there are already {int} people in the bar")
    public void guestsPeopleArriveAndThereAreAlreadyPeoplePeopleInTheBar(int guests, int people) {
    }

    @Then("there is enough room for {int} guests the entry is (allowed|refused
    public void thereIsEnoughRoomForGuestsGuestsTheEntryIsAllowed(int guests, boolean allowed) {
    }

    @Given("{int} people go to the bar Le Juste")
    public void guestsPeopleGoToTheBarLeJuste(int guests) {
    }
}
