package com.yrachid.reservations.domain;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import static java.util.Collections.emptyList;

public class Reservation {

    public final CustomerType customerType;
    //    public final Collection<LocalDate> dates;
    public final Collection<ReservationDate> dates;

    public Reservation(CustomerType customerType, Collection<ReservationDate> dates) {
        this.customerType = customerType;
//        this.dates = dates;
        this.dates = dates;
    }

    public Collection<DayType> dayTypeList() {

        return emptyList();

//        return dates
//                .stream()
//                .map(this::dayTypeOf)
//                .collect(toList());
    }

    private DayType dayTypeOf(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return (day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)) ? DayType.WEEKEND : DayType.WEEKDAY;
    }

    @Override
    public String toString() {

        StringBuilder reservationAsString = new StringBuilder(customerType.asString());

        reservationAsString.append(": ");

//        dates.stream().map(this::stringifyDate).forEach(reservationAsString::append);

        return reservationAsString.toString();
    }

    private String stringifyDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("ddMMMyyy"));

    }
}
