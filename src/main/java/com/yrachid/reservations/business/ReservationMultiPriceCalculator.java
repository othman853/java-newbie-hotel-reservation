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

        Collection<DayType> reservationDays = reservation
                .dates
                .stream()
                .map(this::dayTypeOf)
                .collect(Collectors.toList());

        for (Hotel hotel : hotelRepository.all()) {

            Collection<HotelPrice> hotelPricesByCustomerType = hotel
                    .prices
                    .stream()
                    .filter(price -> price.customerType.equals(reservation.customerType))
                    .collect(Collectors.toList());

            double value = calculateHotelPriceByCustomerType(reservationDays, hotelPricesByCustomerType);

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

    private DayType dayTypeOf(GregorianCalendar date) {
        return date.get(Calendar.DAY_OF_WEEK) > 1 && date.get(Calendar.DAY_OF_WEEK) < 7 ? DayType.WEEKDAY : DayType.WEEKEND;
    }
}
