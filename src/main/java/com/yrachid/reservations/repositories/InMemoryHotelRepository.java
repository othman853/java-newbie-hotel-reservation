package com.yrachid.reservations.repositories;


import com.yrachid.reservations.data.Hotel;

import java.util.Collection;

import static com.yrachid.reservations.data.CustomerType.REGULAR;
import static com.yrachid.reservations.data.CustomerType.REWARDS;
import static com.yrachid.reservations.data.DayType.WEEKDAY;
import static com.yrachid.reservations.data.DayType.WEEKEND;
import static com.yrachid.reservations.data.Hotel.hotel;
import static com.yrachid.reservations.data.HotelPrice.hotelPrice;
import static java.util.Arrays.asList;

public class InMemoryHotelRepository implements HotelRepository {

    private static final Hotel LAKEWOOD = hotel(hotel ->
            hotel
                .id(1)
                .name("Lakewood")
                .rating(3)
                .prices(asList(
                            hotelPrice(price -> price.value(110).customerType(REGULAR).dayType(WEEKDAY)),
                            hotelPrice(price -> price.value(80).customerType(REWARDS).dayType(WEEKDAY)),
                            hotelPrice(price -> price.value(90).customerType(REGULAR).dayType(WEEKEND)),
                            hotelPrice(price -> price.value(80).customerType(REWARDS).dayType(WEEKEND))
                        )
                )
    );

    private static final Hotel BRIDGEWOOD = hotel(hotel ->
            hotel
                .id(2)
                .name("Bridgewood")
                .rating(4)
                .prices(asList(
                            hotelPrice(price -> price.value(160).customerType(REGULAR).dayType(WEEKDAY)),
                            hotelPrice(price -> price.value(110).customerType(REWARDS).dayType(WEEKDAY)),
                            hotelPrice(price -> price.value(60).customerType(REGULAR).dayType(WEEKEND)),
                            hotelPrice(price -> price.value(50).customerType(REWARDS).dayType(WEEKEND))
                        )
                )
    );

    private static final Hotel RIDGEWOOD = hotel(hotel ->
            hotel
                .id(3)
                .name("Ridgewood")
                .rating(5)
                .prices(asList(
                            hotelPrice(price -> price.value(220).customerType(REGULAR).dayType(WEEKDAY)),
                            hotelPrice(price -> price.value(100).customerType(REWARDS).dayType(WEEKDAY)),
                            hotelPrice(price -> price.value(150).customerType(REGULAR).dayType(WEEKEND)),
                            hotelPrice(price -> price.value(40).customerType(REWARDS).dayType(WEEKEND))
                        )
                )
    );


    @Override
    public Collection<Hotel> all() {
        return asList(LAKEWOOD, BRIDGEWOOD, RIDGEWOOD);
    }
}
