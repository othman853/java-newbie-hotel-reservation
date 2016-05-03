package com.yrachid.reservations.data;


public class HotelPrice {

    public final double value;
    public final CustomerType customerType;
    public final DayType dayType;

    public HotelPrice(double value, CustomerType customerType, DayType dayType) {
        this.value = value;
        this.customerType = customerType;
        this.dayType = dayType;
    }
}
