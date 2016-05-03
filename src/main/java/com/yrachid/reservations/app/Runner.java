package com.yrachid.reservations.app;


import com.yrachid.reservations.business.ReservationMultiPriceCalculator;
import com.yrachid.reservations.business.ReservationPriceCalculator;
import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.data.ReservationPrice;
import com.yrachid.reservations.exceptions.InvalidFileException;
import com.yrachid.reservations.io.FileReader;
import com.yrachid.reservations.io.StreamBasedFileReader;
import com.yrachid.reservations.parsing.*;
import com.yrachid.reservations.repositories.HotelRepository;
import com.yrachid.reservations.repositories.InMemoryHotelRepository;

import java.util.Collection;
import java.util.GregorianCalendar;

public class Runner {

    private static final String DEFAULT_FILE_PATH = "src/main/java/resources/entries";

    private static boolean hasArgumentsFromCommandLine(String[] args) {
        return args.length > 0;
    }

    private static HotelReservation resolveDependencies(String[] args) throws InvalidFileException {

        String filePath = hasArgumentsFromCommandLine(args) ? args[0] : DEFAULT_FILE_PATH;

        HotelRepository hotelRepository = new InMemoryHotelRepository();

        ReservationPriceCalculator<Collection<ReservationPrice>> calculator = new ReservationMultiPriceCalculator(hotelRepository);

        FileReader reader = new StreamBasedFileReader(filePath);

        PatternParser<CustomerType> customerTypePatternParser = new CustomerTypePatternParser();
        PatternParser<Collection<GregorianCalendar>> dateChainPatternParser = new DateChainPatternParser();
        PatternParserExecutor<Reservation> executor = new ReservationPatternParserExecutor(customerTypePatternParser, dateChainPatternParser);

        return new HotelReservation(calculator, reader, executor);
    }

    public static void main(String[] args) {

        try {

            HotelReservation app = resolveDependencies(args);

            app.start();

        } catch (InvalidFileException e) {
            System.out.println(e.getMessage());
        }

    }

}
