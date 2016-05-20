package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.exceptions.PatternException;

import java.time.LocalDate;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Optional;

public class ReservationCompoundParser implements PatternParser<Optional<Reservation>>{

    private PatternParser<CustomerType> customerTypeParser;
    private PatternParser<Collection<LocalDate>> dateChainParser;

    public ReservationCompoundParser(PatternParser<CustomerType> customerTypeParser, PatternParser<Collection<LocalDate>> dateChainParser) {
        this.customerTypeParser = customerTypeParser;
        this.dateChainParser = dateChainParser;
    }

    @Override
    public Optional<Reservation> parse(String pattern) {

        try {

            return Optional.of(new Reservation(customerTypeParser.parse(pattern), dateChainParser.parse(pattern)));

        } catch (PatternException e) {

            return Optional.empty();

        }
    }

}
