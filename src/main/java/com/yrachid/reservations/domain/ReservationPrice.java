package com.yrachid.reservations.domain;


public class ReservationPrice implements SmallestDistinguisher<ReservationPrice> {

    public final double value;
    public final Hotel hotel;

    public ReservationPrice(double value, Hotel hotel) {
        this.value = value;
        this.hotel = hotel;
    }


    @Override
    public ReservationPrice smallest(ReservationPrice other) {

        if (this.value == other.value) {
            return (this.hotel.rating > other.hotel.rating)
                    ? this
                    : other;
        }

        return (this.value < other.value)
                ? this
                : other;
    }

    @Override
    public String toString() {
        return hotel.name;
    }
}
