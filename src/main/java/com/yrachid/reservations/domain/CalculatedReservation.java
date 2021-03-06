package com.yrachid.reservations.domain;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CalculatedReservation {

    public final Reservation reservation;
    public final List<Hotel> hotels;

    public CalculatedReservation(Reservation reservation, List<Hotel> hotels) {
        this.reservation = reservation;
        this.hotels = hotels;
    }

    public List<ReservationPrice> getPrices() {
        return hotels
                .stream()
                .map(this::calculateReservationPrice)
                .collect(toList());

    }

    public ReservationPrice getCheapestPrice() {
        return getPrices().stream().reduce(ReservationPrice::smallest).get();
    }

    private List<HotelPrice> pricesByCustomerType(Collection<HotelPrice> prices) {
        return prices.stream().filter(p -> p.customerType.equals(reservation.customerType)).collect(toList());
    }

    private HotelPrice priceByDayType(ReservationDate date, Collection<HotelPrice> prices) {
        return prices.stream().filter(price -> price.dayType.equals(date.dayType())).findFirst().get();
    }

    private ReservationPrice calculateReservationPrice(Hotel hotel) {

        Collection<HotelPrice> prices = hotel.pricesByCustomerType(reservation.customerType);

        List<Double> priceValuesByDate = reservation.dates.stream().map(date -> priceByDayType(date, prices).value).collect(toList());

        double totalPriceForReservation = priceValuesByDate.stream().reduce((accumulator, price) -> accumulator + price).get();

        return new ReservationPrice(totalPriceForReservation, hotel);

    }
}
