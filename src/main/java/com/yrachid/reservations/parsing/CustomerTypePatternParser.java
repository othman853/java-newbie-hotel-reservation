package com.yrachid.reservations.parsing;


import com.yrachid.reservations.domain.CustomerType;

import java.util.Optional;

import static com.yrachid.reservations.domain.CustomerType.REGULAR;
import static com.yrachid.reservations.domain.CustomerType.REWARDS;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class CustomerTypePatternParser implements PatternParser<Optional<CustomerType>> {

    @Override
    public Optional<CustomerType> parse(String pattern) {

        if (pattern.trim().toLowerCase().equals(REGULAR.asString().toLowerCase())) {
            return of(REGULAR);
        }

        if (pattern.trim().toLowerCase().equals(REWARDS.asString().toLowerCase())) {
            return of(REWARDS);
        }

        return empty();
    }
}
