package com.yrachid.reservations.app;


import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.io.FileReader;
import com.yrachid.reservations.parsing.PatternParser;
import com.yrachid.reservations.repositories.HotelPriceRepository;
import com.yrachid.reservations.repositories.HotelRepository;

public class HotelReservation {

    private final HotelRepository hotelRepository;
    private final HotelPriceRepository hotelPriceRepository;

    private final FileReader reader;
    private final PatternParser<Reservation> reservationPatternParser;

    public HotelReservation(HotelRepository hotelRepository, HotelPriceRepository hotelPriceRepository, FileReader reader, PatternParser<Reservation> reservationPatternParser) {
        this.hotelRepository = hotelRepository;
        this.hotelPriceRepository = hotelPriceRepository;
        this.reader = reader;
        this.reservationPatternParser = reservationPatternParser;
    }

    public void start() {

    }


}
