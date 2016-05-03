package com.yrachid.reservations.data;


import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.stream.Collectors;

public class Reservation {

    public final CustomerType customerType;
    public final Collection<GregorianCalendar> dates;

    public Reservation(CustomerType customerType, Collection<GregorianCalendar> dates) {
        this.customerType = customerType;
        this.dates = dates;
    }

    public Collection<DayType> dayTypeList() {

        return dates
                .stream()
                .map(this::dayTypeOf)
                .collect(Collectors.toList());
    }

    private DayType dayTypeOf(GregorianCalendar date) {
        return date.get(Calendar.DAY_OF_WEEK) > 1 && date.get(Calendar.DAY_OF_WEEK) < 7 ? DayType.WEEKDAY : DayType.WEEKEND;
    }

    @Override
    public String toString() {

        StringBuilder reservationAsString = new StringBuilder(customerType.asString());

        reservationAsString.append(": ");

        dates
                .forEach(date -> reservationAsString
                    .append(stringifyDate(date))
                    .append(" ")
                );

        return reservationAsString.toString();
    }

    private String stringifyDate(GregorianCalendar date) {

        return date
                .get(GregorianCalendar.DATE) +
                date.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US) +
                date.get(Calendar.YEAR);

    }
}
