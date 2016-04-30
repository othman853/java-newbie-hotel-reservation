package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.FileLine;
import org.junit.Before;
import org.junit.Test;

import static com.yrachid.reservations.data.CustomerType.*;

import static org.junit.Assert.assertEquals;

public class CustomerTypePatternParserTest {

    CustomerTypePatternParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new CustomerTypePatternParser();
    }

    @Test
    public void parseShouldReturnRegularCustomerType() throws Exception {
        FileLine line = new FileLine(1, "Regular");

        CustomerType parsedType = parser.parse(line.value);

        assertEquals(REGULAR, parsedType);
    }

    @Test
    public void parseShouldReturnRewardsCustomerType() throws Exception {
        FileLine line = new FileLine(1, "Rewards");

        CustomerType parsedType = parser.parse(line.value);

        assertEquals(REWARDS, parsedType);
    }


    @Test
    public void parseShouldReturnRewardsCustomerTypeBeingCaseInsensitive() throws Exception {
        FileLine line = new FileLine(1, "rewards");

        CustomerType parsedType = parser.parse(line.value);

        assertEquals(REWARDS, parsedType);
    }

}
