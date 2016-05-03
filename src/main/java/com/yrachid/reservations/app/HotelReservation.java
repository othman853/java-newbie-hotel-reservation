package com.yrachid.reservations.app;


import com.yrachid.reservations.business.PriceCalculator;
import com.yrachid.reservations.data.ReservationPrice;
import com.yrachid.reservations.io.FileReader;
import com.yrachid.reservations.parsing.ReservationCompoundParser;

import java.io.IOException;
import java.util.Optional;

public class HotelReservation {


    private PriceCalculator<ReservationPrice> calculator;
    private final FileReader<String> reader;
    private final ReservationCompoundParser parser;


    public HotelReservation(PriceCalculator<ReservationPrice> calculator, FileReader<String> reader, ReservationCompoundParser parser) {

        this.calculator = calculator;
        this.reader = reader;
        this.parser = parser;
    }

    public void start() throws IOException {
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
