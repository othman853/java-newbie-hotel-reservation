package com.yrachid.reservations.data;

import java.util.Collection;

public class Hotel {

    public final int id;
    public final String name;
    public final int rating;
    public final Collection<HotelPrice> prices;

    public Hotel(int id, String name, int rating, Collection<HotelPrice> prices) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.prices = prices;
    }
}
