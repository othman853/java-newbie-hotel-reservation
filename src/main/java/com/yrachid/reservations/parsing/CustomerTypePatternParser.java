package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.exceptions.AbsentPatternException;

public class CustomerTypePatternParser implements PatternParser<CustomerType> {

    @Override
    public CustomerType parse(String pattern) throws AbsentPatternException {

        pattern = pattern.toLowerCase();

        if (pattern.contains(CustomerType.REGULAR.asString().toLowerCase())){
            return CustomerType.REGULAR;
        }

        if (pattern.contains(CustomerType.REWARDS.asString().toLowerCase())) {
            return CustomerType.REWARDS;
        }

        throw new AbsentPatternException("Could not find any Customer Type patterns on this string");
    }
}
