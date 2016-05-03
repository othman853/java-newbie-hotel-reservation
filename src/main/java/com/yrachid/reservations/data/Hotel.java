package com.yrachid.reservations.data;

import java.util.Collection;
import java.util.stream.Collectors;

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

    public Collection<HotelPrice> pricesByCustomerType(CustomerType customerType) {
        return prices
                .stream()
                .filter(price -> price.customerType.equals(customerType))
                .collect(Collectors.toList());
    }

}
