package com.yrachid.reservations.business;


import com.yrachid.reservations.data.Reservation;

public interface ReservationPriceCalculator<T> {

    T calculate(Reservation reservation);

}
