package com.yrachid.reservations.data;


public class ReservationPrice implements SmallestDistinguisher<ReservationPrice> {

    public final double value;
    public final Hotel hotel;

    public ReservationPrice(double value, Hotel hotel) {
        this.value = value;
        this.hotel = hotel;
    }


    @Override
    public ReservationPrice smallest(ReservationPrice other) {

        if (value == other.value) {
            return hotel.rating > other.hotel.rating ? this : other;
        }

        return this.value > other.value ? other : this;
    }

    @Override
    public String toString() {
        return hotel.name;
    }
}
