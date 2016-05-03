package com.yrachid.reservations.app;


import com.yrachid.reservations.business.ReservationPriceCalculator;
import com.yrachid.reservations.data.ReservationPrice;
import com.yrachid.reservations.exceptions.InvalidFileException;
import com.yrachid.reservations.io.FileReader;
import com.yrachid.reservations.parsing.ReservationCompoundParser;

import java.io.IOException;
import java.util.Optional;

public class HotelReservation {


    private ReservationPriceCalculator<ReservationPrice> calculator;
    private final FileReader<String> reader;
    private final ReservationCompoundParser parser;


    public HotelReservation(ReservationPriceCalculator<ReservationPrice> calculator, FileReader<String> reader, ReservationCompoundParser parser) {

        this.calculator = calculator;
        this.reader = reader;
        this.parser = parser;
    }

    public void start() throws InvalidFileException {

        try {

            reader
                    .readLines()
                    .stream()
                    .map(parser::parse)
                    .filter(Optional::isPresent)
                    .map(reservation -> calculator.calculate(reservation.get()))
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new InvalidFileException(e.getMessage());
        }
    }

}
