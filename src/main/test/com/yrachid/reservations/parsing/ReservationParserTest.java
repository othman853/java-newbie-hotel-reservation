package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.exceptions.AbsentPatternException;
import com.yrachid.reservations.exceptions.InvalidDatePatternException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReservationParserTest {
    
//    ReservationParserExecuter parser;
//
//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();
//
//    @Before
//    public void setUp() throws Exception {
//        parser = new ReservationParserExecuter(new CustomerTypePatternParser(), new DateChainPatternParser());
//    }
//
//    @Test
//    public void parseShouldParseReservationOfRegularCustomerFor29Mar2009And30Mar2009And31Mar2009() throws Exception {
//
//        List<GregorianCalendar> expectedDates = Arrays.asList(new GregorianCalendar(2009,2,29), new GregorianCalendar(2009,2,30), new GregorianCalendar(2009,2,31));
//
//        Reservation reservation = parser.parse("Regular: 29Mar2009(sun), 30Mar2009(mon), 31Mar2009(tues)");
//
//        assertEquals(reservation.customerType, CustomerType.REGULAR);
//        assertEquals(expectedDates, reservation.dates);
//
//    }
//    @Test
//    public void parseShouldParseProblemsFirstInput() throws Exception {
//
//        List<GregorianCalendar> expectedDates = Arrays.asList(new GregorianCalendar(2009,2,16), new GregorianCalendar(2009,2,17), new GregorianCalendar(2009,2,18));
//
//        Reservation reservation = parser.parse("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
//
//        assertEquals(reservation.customerType, CustomerType.REGULAR);
//        assertEquals(expectedDates, reservation.dates);
//
//    }
//
//    @Test
//    public void parseShouldParseProblemsSecondInput() throws Exception {
//
//        List<GregorianCalendar> expectedDates = Arrays.asList(new GregorianCalendar(2009,2,20), new GregorianCalendar(2009,2,21), new GregorianCalendar(2009,2,22));
//
//        Reservation reservation = parser.parse("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)");
//
//        assertEquals(reservation.customerType, CustomerType.REGULAR);
//        assertEquals(expectedDates, reservation.dates);
//    }
//
//
//    @Test
//    public void parseShouldParseProblemsThirdInput() throws Exception {
//
//        List<GregorianCalendar> expectedDates = Arrays.asList(new GregorianCalendar(2009,2,26), new GregorianCalendar(2009,2,27), new GregorianCalendar(2009,2,28));
//
//        Reservation reservation = parser.parse("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
//
//        assertEquals(reservation.customerType, CustomerType.REWARDS);
//        assertEquals(expectedDates, reservation.dates);
//    }
//
//    @Test
//    public void parseShouldThrowExceptionForInvalidCustomerType() throws Exception {
//
//        expectedException.expect(AbsentPatternException.class);
//        expectedException.expectMessage("Could not find any Customer Type patterns on this string");
//
//        parser.parse("Invalid");
//    }
//
//    @Test
//    public void parseShouldThrowExceptionForAbsentDates() throws Exception {
//        expectedException.expect(AbsentPatternException.class);
//        expectedException.expectMessage("Could not find date patterns on the String");
//
//        parser.parse("Regular: ");
//    }
//
//    @Test
//    public void parseShouldThrowExceptionForInvalidDate() throws Exception {
//        expectedException.expect(InvalidDatePatternException.class);
//        expectedException.expectMessage("The provided date cannot be parsed into a valid date");
//
//        parser.parse("Regular: 29Mar2009(tues), 31Mar2009(thu), 32Mar2009(bla)");
//    }
}
