package com.yrachid.reservations.parsing;


import com.yrachid.reservations.exceptions.AbsentPatternException;
import com.yrachid.reservations.exceptions.InvalidDatePatternException;
import com.yrachid.reservations.exceptions.PatternException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateChainPatternParser implements PatternParser<Collection<GregorianCalendar>> {

    private static final String DATE_REGEX = "\\d{2}\\w{3}\\d{4}";
    private static final String DATE_FORMAT = "ddMMMyyyy";

    @Override
    public Collection<GregorianCalendar> parse(String pattern) throws PatternException {

        Pattern regex = Pattern.compile(DATE_REGEX);
        Matcher regexMatcher = regex.matcher(pattern);

        if (!regexMatcher.find()) {
            throw new AbsentPatternException("Could not find date patterns on the String");
        }

        regexMatcher.reset();

        List<GregorianCalendar> dates = new ArrayList<>();

        while(regexMatcher.find()) {
            dates.add(toGregorianCalendar(regexMatcher.group()));
        }

        return dates;
    }

    private GregorianCalendar toGregorianCalendar(String date) throws InvalidDatePatternException {

        try {

            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            Date dateInMilliseconds;
            format.setLenient(false);

            dateInMilliseconds = format.parse(date);

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(dateInMilliseconds);

            return calendar;

        } catch (ParseException e) {
            throw new InvalidDatePatternException("The provided date cannot be parsed into a valid date");
        }

    }

}
