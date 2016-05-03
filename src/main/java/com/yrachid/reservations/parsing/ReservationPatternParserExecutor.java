package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.FileLine;
import com.yrachid.reservations.data.Reservation;
import com.yrachid.reservations.exceptions.PatternException;

import java.util.*;

public class ReservationPatternParserExecutor implements PatternParserExecutor<Reservation> {

    private PatternParser<CustomerType> customerTypePatternParser;
    private PatternParser<Collection<GregorianCalendar>> datesPatternParser;

    private Map<FileLine, Exception> errors;
    private Collection<Reservation> parsedLines;

    public ReservationPatternParserExecutor(PatternParser<CustomerType> customerTypePatternParser, PatternParser<Collection<GregorianCalendar>> datesPatternParser) {
        this.customerTypePatternParser = customerTypePatternParser;
        this.datesPatternParser = datesPatternParser;

        errors = new HashMap<>();
        parsedLines = new ArrayList<>();
    }

    @Override
    public void execute(Collection<FileLine> lines) {
        lines.forEach(this::runParsers);
    }

    private void runParsers (FileLine line) {

        try {

            parsedLines.add(new Reservation(
                            customerTypePatternParser
                                    .parse(line.value),
                            datesPatternParser
                                    .parse(line.value)));

        } catch (PatternException error) {
            errors.put(line, error);
        }
    }

    @Override
    public Map<FileLine, Exception> getErrors() {
        return errors;
    }

    @Override
    public Collection<Reservation> getValidParses() {
        return parsedLines;
    }

}
