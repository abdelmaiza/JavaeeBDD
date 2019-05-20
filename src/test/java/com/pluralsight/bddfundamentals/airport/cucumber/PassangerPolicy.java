package com.pluralsight.bddfundamentals.airport.cucumber;

import com.pluralsight.bddfundamentals.airport.BusinessFlight;
import com.pluralsight.bddfundamentals.airport.EconomyFlight;
import com.pluralsight.bddfundamentals.airport.Passenger;
import com.pluralsight.bddfundamentals.airport.PremiumFlight;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassangerPolicy {

    private EconomyFlight economyFlight;
    private BusinessFlight businessFlight;
    private PremiumFlight premiumFlight;
    private Passenger mike;
    private Passenger john;

    @Given("^there is an economy flight$")
    public void thereIsAnEconomyFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        economyFlight = new EconomyFlight("1");
    }

    @When("^we have a usual passenger$")
    public void weHaveAUsualPassenger() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mike = new Passenger("Mike",false);
    }

    @Then("^you can add and remove him from an economy flight$")
    public void youCanAddAndRemoveHimFromAnEconomyFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(mike)),
                () -> assertEquals(1, economyFlight.getPassengers().size()),
                () -> assertTrue(economyFlight.getPassengers().contains(mike)),
                () -> assertEquals(true, economyFlight.removePassenger(mike)),
                () -> assertEquals(0, economyFlight.getPassengers().size())
        );
    }

    @When("^we have a VIP passenger$")
    public void weHaveAVIPPassenger() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        john = new Passenger("John", true);
    }

    @Then("^you can add him but cannot remove him from an economy flight$")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertAll("Verify all conditions for a VIP passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(john)),
                () -> assertEquals(1, economyFlight.getPassengers().size()),
                () -> assertTrue(economyFlight.getPassengers().contains(john)),
                () -> assertEquals(false, economyFlight.removePassenger(john)),
                () -> assertEquals(1, economyFlight.getPassengers().size())
        );
    }

    @Given("^there is an business flight$")
    public void thereIsAnBusinessFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        businessFlight = new BusinessFlight("2");
    }

    @Then("^you cannot add or remove him from a business flight$")
    public void youCannotAddOrRemoveHimFromABusinessFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertAll("Verify all conditions for a usual passenger and a business flight",
                () -> assertEquals(false, businessFlight.addPassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengers().size()),
                () -> assertEquals(false, businessFlight.removePassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengers().size())
        );
    }

    @Then("^you can add him but cannot remove him from a business flight$")
    public void youCanAddHimButCannotRemoveHimFromABusinessFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertAll("Verify all conditions for a VIP passenger and a business flight",
                () -> assertEquals(true, businessFlight.addPassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengers().size()),
                () -> assertEquals(false, businessFlight.removePassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengers().size())
        );
    }

    @Given("^there is an premium flight$")
    public void thereIsAnPremiumFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        premiumFlight = new PremiumFlight("3");
    }

    @Then("^you cannot add or remove him from a premium flight$")
    public void youCannotAddOrRemoveHimFromAPremiumFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertAll("Verify all conditions for a VIP passenger and a business flight",
                () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                () -> assertEquals(0, premiumFlight.getPassengers().size()),
                () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                () -> assertEquals(0, premiumFlight.getPassengers().size())
        );
    }

    @Then("^you can add and remove him from a premium flight$")
    public void youCanAddAndRemoveHimFromAPremiumFlight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertAll("Verify all conditions for a VIP passenger and a business flight",
                () -> assertEquals(true, premiumFlight.addPassenger(john)),
                () -> assertEquals(1, premiumFlight.getPassengers().size()),
                () -> assertEquals(true, premiumFlight.removePassenger(john)),
                () -> assertEquals(0, premiumFlight.getPassengers().size())
        );
    }

    @And("^you cannot add a usual passenger to an economy flight more than once$")
    public void youCannotAddAUsualPassengerToAnEconomyFlightMoreThanOnce() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (int i = 0; i < 10; i++) {
            economyFlight.addPassenger(mike);
        }
        assertAll("Verify a usual passenger can be added to an economy flight only once",
                () -> assertEquals(1, economyFlight.getPassengers().size()),
                () -> assertTrue(economyFlight.getPassengers().contains(mike)),
                () -> assertTrue(new ArrayList<>(economyFlight.getPassengers()).get(0).getName().equals("Mike"))
        );
    }

    @And("^you cannot add a VIP passenger to an economy flight more than once$")
    public void youCannotAddAVIPPassengerToAnEconomyFlightMoreThanOnce() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (int i = 0; i < 10; i++) {
            economyFlight.addPassenger(john);
        }
        assertAll("Verify a VIP passenger can be added to an economy flight only once",
                () -> assertEquals(1, economyFlight.getPassengers().size()),
                () -> assertTrue(economyFlight.getPassengers().contains(john)),
                () -> assertTrue(new ArrayList<>(economyFlight.getPassengers()).get(0).getName().equals("John"))
        );
    }

    @And("^you cannot add a VIP passenger to a business flight more than once$")
    public void youCannotAddAVIPPassengerToABusinessFlightMoreThanOnce() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (int i = 0; i < 10; i++) {
            businessFlight.addPassenger(john);
        }
        assertAll("Verify a VIP passenger can be added to an business flight only once",
                () -> assertEquals(1, businessFlight.getPassengers().size()),
                () -> assertTrue(businessFlight.getPassengers().contains(john)),
                () -> assertTrue(new ArrayList<>(businessFlight.getPassengers()).get(0).getName().equals("John"))
        );
    }

    @And("^you cannot add a VIP passenger to a premium flight more than once$")
    public void youCannotAddAVIPPassengerToAPremiumFlightMoreThanOnce() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (int i = 0; i < 10; i++) {
            premiumFlight.addPassenger(john);
        }
        assertAll("Verify a VIP passenger can be added to an premium flight only once",
                () -> assertEquals(1, premiumFlight.getPassengers().size()),
                () -> assertTrue(premiumFlight.getPassengers().contains(john)),
                () -> assertTrue(new ArrayList<>(premiumFlight.getPassengers()).get(0).getName().equals("John"))
        );
    }
}
