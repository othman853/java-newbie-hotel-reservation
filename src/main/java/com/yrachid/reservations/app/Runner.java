package com.yrachid.reservations.app;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.exceptions.InvalidFileException;
import com.yrachid.reservations.io.FileReader;
import com.yrachid.reservations.io.StreamBasedFileReader;
import com.yrachid.reservations.parsing.*;
import com.yrachid.reservations.repositories.HotelPriceRepository;
import com.yrachid.reservations.repositories.HotelRepository;
import com.yrachid.reservations.repositories.InMemoryHotelPriceRepository;
import com.yrachid.reservations.repositories.InMemoryHotelRepository;

import java.util.Collection;
import java.util.GregorianCalendar;

public class Runner {

    private static final String DEFAULT_FILE_PATH = "src/main/java/resources/entries";

    private static boolean hasArgumentsFromCommandLine(String[] args) {
        return args.length > 0;
    }

    public static void main(String[] args) {

        try {

            String filePath = hasArgumentsFromCommandLine(args) ? args[0] : DEFAULT_FILE_PATH;

            HotelRepository hotelRepository = new InMemoryHotelRepository();
            HotelPriceRepository hotelPriceRepository = new InMemoryHotelPriceRepository();

            FileReader reader = new StreamBasedFileReader(filePath);
            PatternParser<CustomerType> customerTypePatternParser = new CustomerTypePatternParser();
            PatternParser<Collection<GregorianCalendar>> dateChainPatternParser = new DateChainPatternParser();

            PatternParserExecutor<Reservation> executer = new ReservationPatternParserExecutor(customerTypePatternParser, dateChainPatternParser);

            HotelReservation app = new HotelReservation(hotelRepository, hotelPriceRepository, reader, executer);

            app.start();

        } catch (InvalidFileException e) {
            System.out.println(e.getMessage());
        }

    }

}
