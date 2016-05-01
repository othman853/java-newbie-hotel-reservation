package com.yrachid.reservations.parsing;

import com.yrachid.reservations.exceptions.PatternException;

public interface PatternParser<T> {

    T parse(String pattern) throws PatternException;
}
