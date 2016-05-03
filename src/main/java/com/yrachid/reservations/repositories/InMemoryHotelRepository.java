package com.yrachid.reservations.repositories;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.DayType;
import com.yrachid.reservations.data.Hotel;
import com.yrachid.reservations.data.HotelPrice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class InMemoryHotelRepository implements HotelRepository{

    private final List<Hotel> hotelList = Arrays.asList(
            new Hotel(1, "Lakewood", 3, Arrays.asList(
                    new HotelPrice(110,CustomerType.REGULAR, DayType.WEEKDAY),
                    new HotelPrice(80, CustomerType.REWARDS, DayType.WEEKDAY),
                    new HotelPrice(90, CustomerType.REGULAR, DayType.WEEKEND),
                    new HotelPrice(80, CustomerType.REWARDS, DayType.WEEKEND)
            )),

            new Hotel(2, "Bridgewood", 4, Arrays.asList(
                    new HotelPrice(160, CustomerType.REGULAR, DayType.WEEKDAY),
                    new HotelPrice(110, CustomerType.REWARDS, DayType.WEEKDAY),
                    new HotelPrice(60, CustomerType.REGULAR, DayType.WEEKEND),
                    new HotelPrice(50, CustomerType.REWARDS, DayType.WEEKEND)
            )),
            new Hotel(3, "Ridgewood", 5, Arrays.asList(
                    new HotelPrice(220, CustomerType.REGULAR, DayType.WEEKDAY),
                    new HotelPrice(100, CustomerType.REWARDS, DayType.WEEKDAY),
                    new HotelPrice(150, CustomerType.REGULAR, DayType.WEEKEND),
                    new HotelPrice(40, CustomerType.REWARDS, DayType.WEEKEND)
            ))
    );


    @Override
    public Collection<Hotel> all() {
        return hotelList;
    }
}
