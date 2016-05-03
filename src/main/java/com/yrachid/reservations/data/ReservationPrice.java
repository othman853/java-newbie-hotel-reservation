package com.yrachid.reservations.data;


public class ReservationPrice implements SmallestComparator<ReservationPrice> {

    public final double value;
    public final Hotel hotel;

    public ReservationPrice(double value, Hotel hotel) {
        this.value = value;
        this.hotel = hotel;
    }


    @Override
    public ReservationPrice smallest(ReservationPrice other) {
        return this.value > other.value ? other : this;
    }
}
