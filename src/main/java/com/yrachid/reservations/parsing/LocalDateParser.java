package com.yrachid.reservations.parsing;

import com.yrachid.reservations.exceptions.AbsentPatternException;
import com.yrachid.reservations.exceptions.InvalidDatePatternException;
import com.yrachid.reservations.exceptions.PatternException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalDateParser implements PatternParser<Collection<LocalDate>> {

    private static final String DATE_REGEX = "\\d{2}\\w{3}\\d{4}";
    private static final String DATE_FORMAT = "ddMMMyyyy";

    @Override
    public Collection<LocalDate> parse(String pattern) throws PatternException {
        Pattern regex = Pattern.compile(DATE_REGEX);
        Matcher regexMatcher = regex.matcher(pattern);

        if (!regexMatcher.find()) {
            throw new AbsentPatternException("Could not find date patterns on the String");
        }

        regexMatcher.reset();

        List<LocalDate> dates = new ArrayList<>();


        while(regexMatcher.find()) {
            dates.add(LocalDate.parse(regexMatcher.group(), DateTimeFormatter.ofPattern(DATE_FORMAT)));
        }

        return dates;
    }


}
