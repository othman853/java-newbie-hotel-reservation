package com.yrachid.reservations.business;


import com.yrachid.reservations.data.Reservation;

public interface PriceCalculator<T> {

    T calculate(Reservation reservation);

}
