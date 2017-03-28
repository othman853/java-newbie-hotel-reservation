package com.yrachid.reservations.data;


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

    public Collection<DayType> dayTypeList() {

        return dates
                .stream()
                .map(this::dayTypeOf)
                .collect(toList());
    }

    private DayType dayTypeOf(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return (day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)) ? DayType.WEEKEND : DayType.WEEKDAY;
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
