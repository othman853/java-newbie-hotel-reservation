package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.exceptions.AbsentPatternException;

import static com.yrachid.reservations.data.CustomerType.REGULAR;
import static com.yrachid.reservations.data.CustomerType.REWARDS;
import static java.lang.String.format;

public class CustomerTypePatternParser implements PatternParser<CustomerType> {

    @Override
    public CustomerType parse(String pattern) throws AbsentPatternException {

        if (pattern.trim().toLowerCase().equals(REGULAR.asString().toLowerCase())) {
            return REGULAR;
        }

        if (pattern.trim().toLowerCase().equals(REWARDS.asString().toLowerCase())) {
            return REWARDS;
        }

        throw new AbsentPatternException(format("%s does not match any customer type", pattern));
    }
}
