package com.yrachid.reservations.business;


import com.yrachid.reservations.data.*;
import com.yrachid.reservations.repositories.HotelRepository;

public class CheapestPriceCalculator implements PriceCalculator<ReservationPrice> {

    private HotelRepository repository;

    private Reservation reservation;

    public CheapestPriceCalculator(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReservationPrice calculate(Reservation reservation) {

        this.reservation = reservation;

        return repository
                    .all()
                    .stream()
                    .map(this::calculateHotelPrice)
                    .reduce(ReservationPrice::smallest)
                    .get();
    }

    private ReservationPrice calculateHotelPrice(Hotel hotel) {

        double value = 0;

        for (DayType type : reservation.dayTypeList()) {

            HotelPrice priceByDayType = hotel.pricesByCustomerType(reservation.customerType)
                    .stream()
                    .filter(price1 -> price1.dayType.equals(type))
                    .findFirst()
                    .get();

            value += priceByDayType.value;
        }

        return new ReservationPrice(value, hotel);
    }

}
