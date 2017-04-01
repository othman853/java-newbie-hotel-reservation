package com.yrachid.reservations.business;


import com.yrachid.reservations.domain.Reservation;

public interface PriceCalculator<T> {

    T calculate(Reservation reservation);

}
