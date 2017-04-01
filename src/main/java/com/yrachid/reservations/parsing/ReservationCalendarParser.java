package com.yrachid.reservations.parsing;

import com.yrachid.reservations.domain.ReservationDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.regex.Pattern.compile;

public class ReservationCalendarParser implements PatternParser<Collection<ReservationDate>> {

    private static final String DATE_REGEX = "\\d{2}\\w{3}\\d{4}";
    private static final String DATE_FORMAT = "ddMMMyyyy";

    @Override
    public Collection<ReservationDate> parse(String pattern) {
        Matcher regexMatcher = compile(DATE_REGEX).matcher(pattern);

        List<ReservationDate> dates = new ArrayList<>();


        while (regexMatcher.find()) {
            dates.add(
                    new ReservationDate(LocalDate.parse(regexMatcher.group(), ofPattern(DATE_FORMAT)))
            );
        }

        return dates;
    }


}
