package com.yrachid.reservations.app;


import com.yrachid.reservations.business.ReservationPriceCalculator;
import com.yrachid.reservations.data.FileLine;
import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.data.ReservationPrice;
import com.yrachid.reservations.exceptions.InvalidFileException;
import com.yrachid.reservations.io.FileReader;
import com.yrachid.reservations.parsing.PatternParserExecutor;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class HotelReservation {


    private ReservationPriceCalculator<Collection<ReservationPrice>> calculator;
    private final FileReader reader;
    private final PatternParserExecutor<Reservation> reservationParserExecuter;


    public HotelReservation(ReservationPriceCalculator<Collection<ReservationPrice>> calculator, FileReader reader, PatternParserExecutor<Reservation> reservationParserExecuter) {

        this.calculator = calculator;
        this.reader = reader;
        this.reservationParserExecuter = reservationParserExecuter;
    }

    private Collection<FileLine> readFile() throws InvalidFileException {

        try {

            Collection<FileLine> lines = reader.readLines();
            return  lines;

        } catch (IOException e) {
            throw new InvalidFileException(e.getMessage());
        }
    }

    public void start() throws InvalidFileException {

        Collection<FileLine> lines = readFile();

        reservationParserExecuter.execute(lines);

        Collection<Reservation> reservations = reservationParserExecuter.getValidParses();
        Map<FileLine, Exception> errors = reservationParserExecuter.getErrors();

        reservations
                .stream()
                .forEach(reservation -> {

                    System.out.println("Calculating: " + reservation);

                    ReservationPrice smallestPrice = calculator
                            .calculate(reservation)
                            .stream()
                            .reduce(ReservationPrice::smallest)
                            .get();

                    System.out.println(smallestPrice.hotel.name);

                });



        errors
                .entrySet()
                .forEach(entry -> System.err.println(entry.getKey()));


    }


}