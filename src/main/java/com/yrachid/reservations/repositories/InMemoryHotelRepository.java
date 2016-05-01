package com.yrachid.reservations.repositories;


import com.yrachid.reservations.data.Hotel;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class InMemoryHotelRepository implements HotelRepository{

    private final List<Hotel> hotelList = Arrays.asList(
            new Hotel(1, "Lakewood", 3),
            new Hotel(2, "Bridgewood", 4),
            new Hotel(3, "Ridgewood", 5)
    );


    @Override
    public Collection<Hotel> all() {
        return hotelList;
    }
}
