package com.yrachid.reservations.domain;


import java.time.LocalDate;

import static com.yrachid.reservations.domain.DayType.WEEKDAY;
import static com.yrachid.reservations.domain.DayType.WEEKEND;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class ReservationDate {

    private final LocalDate date;

    public ReservationDate(LocalDate date) {
        this.date = date;
    }

    public DayType getDayType() {
        return (date.getDayOfWeek().equals(SATURDAY) || date.getDayOfWeek().equals(SUNDAY))
                ? WEEKEND
                : WEEKDAY;
    }
}
