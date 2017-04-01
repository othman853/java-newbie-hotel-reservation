package com.yrachid.reservations.domain.reservation;


import com.yrachid.reservations.domain.CustomerType;
import com.yrachid.reservations.domain.DayType;
import com.yrachid.reservations.domain.ReservationDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class Reservation {

    public final CustomerType customerType;
    public final Collection<LocalDate> dates;
    public final Collection<ReservationDate> reservationDates;

    public Reservation(CustomerType customerType, Collection<LocalDate> dates) {
        this.customerType = customerType;
        this.dates = dates;
        this.reservationDates = dates.stream().map(ReservationDate::new).collect(toList());
    }

    @Override
    public String toString() {

        StringBuilder reservationAsString = new StringBuilder(customerType.asString());

        reservationAsString.append(": ");

        dates.stream().map(this::stringifyDate).forEach(reservationAsString::append);

        return reservationAsString.toString();
    }

    private String stringifyDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("ddMMMyyy"));

    }
}
