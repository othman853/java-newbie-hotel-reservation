package com.yrachid.reservations.parsing;

import com.yrachid.reservations.exceptions.PatternException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class LocalDateParser implements PatternParser<Collection<LocalDate>> {

    private static final String DATE_REGEX = "\\d{2}\\w{3}\\d{4}";
    private static final String DATE_FORMAT = "ddMMMyyyy";

    @Override
    public Collection<LocalDate> parse(String pattern) throws PatternException {
        Matcher regexMatcher = compile(DATE_REGEX).matcher(pattern);

        List<LocalDate> dates = new ArrayList<>();


        while (regexMatcher.find()) {
            dates.add(LocalDate.parse(regexMatcher.group(), DateTimeFormatter.ofPattern(DATE_FORMAT)));
        }

        return dates;
    }


}
