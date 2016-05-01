package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.exceptions.PatternException;

import java.util.Collection;
import java.util.GregorianCalendar;

public class ReservationParser implements PatternParser<Reservation>{

    private PatternParser<CustomerType> customerTypePatternParser;
    private PatternParser<Collection<GregorianCalendar>> datesPatternParser;

    public ReservationParser(PatternParser<CustomerType> customerTypePatternParser, PatternParser<Collection<GregorianCalendar>> datesPatternParser) {
        this.customerTypePatternParser = customerTypePatternParser;
        this.datesPatternParser = datesPatternParser;
    }

    @Override
    public Reservation parse(String pattern) throws PatternException {

        CustomerType customerType = customerTypePatternParser.parse(pattern);
        Collection<GregorianCalendar> dates = datesPatternParser.parse(pattern);

        return  new Reservation(customerType, dates);
    }

}
