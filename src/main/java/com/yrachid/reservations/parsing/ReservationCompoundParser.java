package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.Reservation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import static java.util.Optional.of;

public class ReservationCompoundParser implements PatternParser<Optional<Reservation>> {

    private CustomerTypePatternParser customerTypeParser;
    private PatternParser<Collection<LocalDate>> dateChainParser;

    public ReservationCompoundParser(CustomerTypePatternParser customerTypeParser, ReservationCalendarParser dateChainParser) {
        this.customerTypeParser = customerTypeParser;
        this.dateChainParser = dateChainParser;
    }

    @Override
    public Optional<Reservation> parse(String pattern) {

        return of(customerTypeParser
                .parse(pattern)
                .map(customerType -> new Reservation(customerType, dateChainParser.parse(pattern)))
                .orElse(null));
    }

}
