package com.yrachid.reservations.business;


import com.yrachid.reservations.data.*;
import com.yrachid.reservations.repositories.HotelRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ReservationMultiPriceCalculator implements ReservationPriceCalculator<Collection<ReservationPrice>> {

    private final HotelRepository hotelRepository;

    public ReservationMultiPriceCalculator(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public Collection<ReservationPrice> calculate(Reservation reservation) {

        Collection<ReservationPrice> prices = new ArrayList<>();

        for (Hotel hotel : hotelRepository.all()) {

            double value = calculateHotelPriceByCustomerType(reservation.dayTypeList(), hotel.pricesByCustomerType(reservation.customerType));

            prices.add(new ReservationPrice(value, hotel));

        }

        return prices;
    }

    private double calculateHotelPriceByCustomerType(Collection<DayType> reservationDays, Collection<HotelPrice> hotelPricesByCustomerType) {

        double value = 0;

        for (DayType type : reservationDays) {

            HotelPrice priceByDayType = hotelPricesByCustomerType
                    .stream()
                    .filter(price1 -> price1
                            .dayType
                            .equals(type))
                    .collect(Collectors
                            .toList())
                    .get(0);

            value += priceByDayType.value;
        }
        return value;
    }
}
