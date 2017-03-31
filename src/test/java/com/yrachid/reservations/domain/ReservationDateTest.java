package com.yrachid.reservations.domain;

import org.junit.Test;

import java.time.LocalDate;

import static com.yrachid.reservations.domain.DayType.WEEKDAY;
import static com.yrachid.reservations.domain.DayType.WEEKEND;
import static org.junit.Assert.*;

public class ReservationDateTest {

    @Test
    public void shouldBeWeekend() throws Exception {
        LocalDate aSaturday = LocalDate.of(2017, 3, 25);
        ReservationDate date = new ReservationDate(aSaturday);

        assertEquals(WEEKEND, date.dayType());
    }

    @Test
    public void shouldBeWeekday() throws Exception {
        LocalDate aFriday = LocalDate.of(2017, 3, 24);
        ReservationDate date = new ReservationDate(aFriday);

        assertEquals(WEEKDAY, date.dayType());

    }
}