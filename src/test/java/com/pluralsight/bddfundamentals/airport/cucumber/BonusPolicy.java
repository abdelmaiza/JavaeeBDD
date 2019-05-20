package com.pluralsight.bddfundamentals.airport.cucumber;

import com.pluralsight.bddfundamentals.airport.Passenger;
import com.pluralsight.bddfundamentals.airport.milage.Mileage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BonusPolicy {
    private Passenger mike;
    private Passenger john;
    private Mileage mileage;

    @Given("^we have a usual passenger with a mileage$")
    public void weHaveAUsualPassengerWithAMileage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mike = new Passenger("Mike",false);
        mileage = new Mileage();
    }

    @When("^the usual passenger travels (\\d+) and (\\d+) and (\\d+)$")
    public void theUsualPassengerTravelsMileageAndMileageAndMileage(int arg0, int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mileage.addMileage(mike,arg0);
        mileage.addMileage(mike,arg1);
        mileage.addMileage(mike,arg2);
    }

    @Then("^the bonus points of the usual passenger should be (\\d+)$")
    public void theBonusPointsOfTheUsualPassengerShouldBePoints(int points) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mileage.calculateGivenPoints();
        Assertions.assertEquals(points,mileage.getPassengersPointsMap().get(mike).intValue());
    }

    @Given("^we have a VIP passenger with a mileage$")
    public void weHaveAVIPPassengerWithAMileage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        john = new Passenger("John",true);
        mileage = new Mileage();
    }

    @When("^the VIP passenger travels (\\d+) and (\\d+) and (\\d+)$")
    public void theVIPPassengerTravelsMileageAndMileageAndMileage(int arg0, int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mileage.addMileage(john,arg0);
        mileage.addMileage(john,arg1);
        mileage.addMileage(john,arg2);
    }

    @Then("^the bonus points of the VIP passenger should be (\\d+)$")
    public void theBonusPointsOfTheVIPPassengerShouldBePoints(int points) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mileage.calculateGivenPoints();
        Assertions.assertEquals(points,mileage.getPassengersPointsMap().get(john).intValue());
    }
}
