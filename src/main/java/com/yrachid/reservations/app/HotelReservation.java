package com.yrachid.reservations.app;


import com.yrachid.reservations.business.PriceCalculator;
import com.yrachid.reservations.domain.ReservationPrice;
import com.yrachid.reservations.io.FileReader;
import com.yrachid.reservations.parsing.ReservationCompoundParser;

import java.io.IOException;
import java.util.Optional;

class HotelReservation {


    private final PriceCalculator<ReservationPrice> calculator;
    private final FileReader<String> reader;
    private final ReservationCompoundParser parser;


    HotelReservation(PriceCalculator<ReservationPrice> calculator, FileReader<String> reader, ReservationCompoundParser parser) {
        this.reader = reader;
        this.parser = parser;
        this.calculator = calculator;
    }

    void start() throws IOException {
        reader
                .readLines()
                .stream()
                .map(parser::parse)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(calculator::calculate)
                .forEach(System.out::println);
    }

}
