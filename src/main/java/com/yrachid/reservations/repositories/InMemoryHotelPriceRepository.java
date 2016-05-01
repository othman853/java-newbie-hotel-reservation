package com.yrachid.reservations.repositories;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.DayType;
import com.yrachid.reservations.data.HotelPrice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryHotelPriceRepository implements HotelPriceRepository{

    private final List<HotelPrice> priceList = Arrays.asList(
      new HotelPrice(1, 110, CustomerType.REGULAR, DayType.WEEKDAY),
      new HotelPrice(1, 80, CustomerType.REWARDS, DayType.WEEKDAY),
      new HotelPrice(1, 90, CustomerType.REGULAR, DayType.WEEKEND),
      new HotelPrice(1, 80, CustomerType.REWARDS, DayType.WEEKEND),

      new HotelPrice(2, 160, CustomerType.REGULAR, DayType.WEEKDAY),
      new HotelPrice(2, 110, CustomerType.REWARDS, DayType.WEEKDAY),
      new HotelPrice(2, 60, CustomerType.REGULAR, DayType.WEEKEND),
      new HotelPrice(2, 50, CustomerType.REWARDS, DayType.WEEKEND),

      new HotelPrice(3, 220, CustomerType.REGULAR, DayType.WEEKDAY),
      new HotelPrice(3, 100, CustomerType.REWARDS, DayType.WEEKDAY),
      new HotelPrice(3, 150, CustomerType.REGULAR, DayType.WEEKEND),
      new HotelPrice(3, 40, CustomerType.REWARDS, DayType.WEEKEND)
    );


    @Override
    public Collection<HotelPrice> byHotelId(int hotelId) {
        return priceList
                .stream()
                .filter(price -> price.hotelId == hotelId)
                .collect(Collectors.toList());
    }
}
