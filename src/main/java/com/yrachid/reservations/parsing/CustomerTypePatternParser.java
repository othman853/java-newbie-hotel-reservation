package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;

public class CustomerTypePatternParser implements PatternParser<CustomerType> {

    @Override
    public CustomerType parse(String pattern) {

        if (pattern.contains("Regular")){
            return CustomerType.REGULAR;
        }

        return CustomerType.REWARDS;
    }
}
