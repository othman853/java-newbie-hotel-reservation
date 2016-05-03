package com.yrachid.reservations.data;


public class ReservationPrice {

    public final double value;
    public final Hotel hotel;

    public ReservationPrice(double value, Hotel hotel) {
        this.value = value;
        this.hotel = hotel;
    }
}
