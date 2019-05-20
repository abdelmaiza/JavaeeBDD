package com.pluralsight.bddfundamentals.airport;

public class PremiumFlight extends Flight {

    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if(passenger.isVip()){
            return this.getPassengers().add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if(passenger.isVip()){
            return this.getPassengers().remove(passenger);
        }
        return false;
    }
}
