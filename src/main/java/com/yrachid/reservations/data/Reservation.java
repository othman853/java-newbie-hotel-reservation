package com.yrachid.reservations.data;


import java.util.Collection;
import java.util.GregorianCalendar;

public class Reservation {

    public final CustomerType customerType;
    public final Collection<GregorianCalendar> dates;

    public Reservation(CustomerType customerType, Collection<GregorianCalendar> dates) {
        this.customerType = customerType;
        this.dates = dates;
    }
}
