package com.pluralsight.bddfundamentals.airport.junit;


import com.pluralsight.bddfundamentals.airport.BusinessFlight;
import com.pluralsight.bddfundamentals.airport.EconomyFlight;
import com.pluralsight.bddfundamentals.airport.Flight;
import com.pluralsight.bddfundamentals.airport.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

    @Test
    public void testEconomyFlightUsualPassenger(){
        Flight economyFlight = new EconomyFlight("1");
        Passenger mike = new Passenger("Mike",false);

        assertEquals("1", economyFlight.getId());
        assertEquals(true,economyFlight.addPassenger(mike));
        assertEquals(1, economyFlight.getPassengers().size());
        assertEquals("mike",economyFlight.getPassengers().contains(mike));

        assertEquals(true,economyFlight.removePassenger(mike));
        assertEquals(0, economyFlight.getPassengers().size());
    }

    @Test
    public void testEconomyFlightVipPassenger() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger john = new Passenger("John", true);

        assertEquals("1", economyFlight.getId());
        assertEquals(true, economyFlight.addPassenger(john));
        assertEquals(1, economyFlight.getPassengers().size());
        assertEquals("John", economyFlight.getPassengers().contains(john));

        assertEquals(false, economyFlight.removePassenger(john));
        assertEquals(1, economyFlight.getPassengers().size());
    }

    @Test
    public void testBusinessFlightUsualPassenger() {
        Flight businessFlight = new BusinessFlight("2");

        Passenger mike = new Passenger("Mike", false);

        assertEquals(false, businessFlight.addPassenger(mike));
        assertEquals(0, businessFlight.getPassengers().size());
        assertEquals(false, businessFlight.removePassenger(mike));
        assertEquals(0, businessFlight.getPassengers().size());
    }

    @Test
    public void testBusinessFlightVipPassenger() {
        Flight businessFlight = new BusinessFlight("2");

        Passenger john = new Passenger("John", true);

        assertEquals(true, businessFlight.addPassenger(john));
        assertEquals(1, businessFlight.getPassengers().size());
        assertEquals(false, businessFlight.removePassenger(john));
        assertEquals(1, businessFlight.getPassengers().size());
    }
}
