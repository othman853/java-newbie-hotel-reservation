package com.yrachid.reservations.parsing;

import com.yrachid.reservations.exceptions.AbsentPatternException;
import com.yrachid.reservations.exceptions.InvalidDatePatternException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ReservationCalendarParserTest {

    ReservationCalendarParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new ReservationCalendarParser();
    }

    @Test
    public void parseShouldReturnACollectionWith29Mar2009DateOnly() throws Exception {

        LocalDate expectedDate = LocalDate.of(2009, 3, 29);

        Collection<LocalDate> parsedDates = parser.parse("29Mar2009");

        assertEquals(1, parsedDates.size());
        assertEquals(expectedDate, parsedDates.iterator().next());
    }


    @Test
    public void parseShouldReturnACollectionWith28Mar200929Mar2009Dates() throws Exception {

        Collection<LocalDate> expectedDates = Arrays.asList(LocalDate.of(2009,3,28), LocalDate.of(2009,3,29));

        Collection<LocalDate> parsedDates = parser.parse("28Mar2009(sat), 29Mar2009(sun)");

        assertEquals(2, parsedDates.size());
        assertEquals(expectedDates, parsedDates);
    }


    @Test
    public void parseShouldReturnACollectionWith28Mar200929Mar200930Mar2009Dates() throws Exception {

        Collection<LocalDate> expectedDates = Arrays.asList(LocalDate.of(2009,3,28), LocalDate.of(2009,3,29), LocalDate.of(2009, 3, 30));

        Collection<LocalDate> parsedDates = parser.parse("28Mar2009(sat), 29Mar2009(sun), 30Mar2009(mon)");

        assertEquals(3, parsedDates.size());
        assertEquals(expectedDates, parsedDates);
    }


    @Test(expected = InvalidDatePatternException.class)
    public void parseShouldThrowInvalidDatePatternExceptionWith32Mar2009InvalidDates() throws Exception {
        parser.parse("32Mar2009(sat)");
    }

    @Test(expected = AbsentPatternException.class)
    public void parseShouldThrowAbsentPatternExceptionWhenNoDateCanBeFound() throws Exception {
        parser.parse("A String that matches no date pattern");
    }

}
