package com.pluralsight.bddfundamentals.airport.junit;

import com.pluralsight.bddfundamentals.airport.BusinessFlight;
import com.pluralsight.bddfundamentals.airport.EconomyFlight;
import com.pluralsight.bddfundamentals.airport.Flight;
import com.pluralsight.bddfundamentals.airport.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AirportTestPhase3 {
    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike  = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {

            @Test
            @DisplayName("Then you can add and remove him from an economy flight")
            public void testAddAndRemove() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertEquals("Mike", economyFlight.getPassengers().contains(mike)),
                        () -> assertEquals(true, economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengers().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy flight")
            public void testAddAndRemove() {
                assertAll("Verify all conditions for a VIP passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(john)),
                        () -> assertEquals(false, economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengers().size())
                );

            }
        }
    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {

            @Test
            @DisplayName("Then you cannot add or remove him from a business flight")
            public void testAddAndRemove() {
                assertAll("Verify all conditions for a usual passenger and a business flight",
                        () -> assertEquals(false, businessFlight.addPassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengers().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengers().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then you can add him but cannot remove him from a business flight")
            public void testAddAndRemove() {
                assertAll("Verify all conditions for a VIP passenger and a business flight",
                        () -> assertEquals(true, businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengers().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengers().size())
                );
            }
        }
    }
}
