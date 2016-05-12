package com.yrachid.reservations.data;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ReservationPriceTest {


    @Test
    public void smallestShouldReturnPriceOfBridgeWood() throws Exception {

        Hotel bridgewood = new Hotel(1, "Bridgewood", 4, Arrays.asList(new HotelPrice(100, CustomerType.REGULAR, DayType.WEEKDAY)));
        Hotel ridgewood = new Hotel(2, "Ridgewood", 4, Arrays.asList(new HotelPrice(200, CustomerType.REGULAR, DayType.WEEKDAY)));

        ReservationPrice expectedToBeTheCheapest = new ReservationPrice(100, bridgewood);
        ReservationPrice expensive = new ReservationPrice(200, ridgewood);

        ReservationPrice classifiedAsCheapest = expectedToBeTheCheapest.smallest(expensive);

        assertEquals(expectedToBeTheCheapest, classifiedAsCheapest);

    }
}
