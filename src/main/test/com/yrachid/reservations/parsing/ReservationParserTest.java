package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.FileLine;
import com.yrachid.reservations.data.Reservation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservationParserTest {
    
    ReservationParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new ReservationParser();
    }

    @Test
    public void parseShouldReturnAReservationWithRegularCustomer() throws Exception {
        FileLine line = new FileLine(1, "Regular: 29Mar2009");

        Reservation parsedInfo = parser.parse(line);

        assertEquals(CustomerType.REGULAR, parsedInfo.customerType);
    }
}
