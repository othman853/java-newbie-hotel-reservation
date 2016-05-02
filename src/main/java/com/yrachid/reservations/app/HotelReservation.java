package com.yrachid.reservations.app;


import com.yrachid.reservations.data.FileLine;
import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.exceptions.InvalidFileException;
import com.yrachid.reservations.exceptions.PatternException;
import com.yrachid.reservations.io.FileReader;
import com.yrachid.reservations.parsing.PatternParserExecuter;
import com.yrachid.reservations.repositories.HotelPriceRepository;
import com.yrachid.reservations.repositories.HotelRepository;

import java.io.IOException;
import java.util.*;

public class HotelReservation {

    private final HotelRepository hotelRepository;
    private final HotelPriceRepository hotelPriceRepository;

    private final FileReader reader;
    private final PatternParserExecuter<Reservation> reservationParserExecuter;


    public HotelReservation(HotelRepository hotelRepository, HotelPriceRepository hotelPriceRepository, FileReader reader, PatternParserExecuter<Reservation> reservationParserExecuter) {
        this.hotelRepository = hotelRepository;
        this.hotelPriceRepository = hotelPriceRepository;
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
                .forEach(reservation -> System.out.println(reservation));

        errors
                .entrySet()
                .stream()
                .forEach(entry -> System.err.println(entry.getKey().toString()));

    }


}
