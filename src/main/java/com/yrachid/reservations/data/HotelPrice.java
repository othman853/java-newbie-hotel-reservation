package com.yrachid.reservations.data;


public class HotelPrice {

    public final int hotelId;
    public final double value;
    public final CustomerType customerType;
    public final DayType dayType;

    public HotelPrice(int hotelId, double value, CustomerType customerType, DayType dayType) {
        this.hotelId = hotelId;
        this.value = value;
        this.customerType = customerType;
        this.dayType = dayType;
    }
}
