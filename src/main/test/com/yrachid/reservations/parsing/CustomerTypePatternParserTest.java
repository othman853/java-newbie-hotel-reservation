package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import org.junit.Before;
import org.junit.Test;

import static com.yrachid.reservations.data.CustomerType.REGULAR;
import static com.yrachid.reservations.data.CustomerType.REWARDS;
import static org.junit.Assert.assertEquals;

public class CustomerTypePatternParserTest {

    CustomerTypePatternParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new CustomerTypePatternParser();
    }

    @Test
    public void parseShouldReturnRegularCustomerType() throws Exception {

        CustomerType parsedType = parser.parse("Regular");

        assertEquals(REGULAR, parsedType);
    }

    @Test
    public void parseShouldReturnRewardsCustomerType() throws Exception {

        CustomerType parsedType = parser.parse("Rewards");

        assertEquals(REWARDS, parsedType);
    }

    @Test
    public void parseShouldReturnRewardsCustomerTypeBeingCaseInsensitive() throws Exception {

        CustomerType parsedType = parser.parse("rewards");

        assertEquals(REWARDS, parsedType);
    }

    @Test
    public void parseShouldReturnRewardsCustomerTypeReceivingAStringFullOfGarbage() throws Exception {

        CustomerType parsedType = parser.parse("rewards askdkajsdkasdjk ajsdjasdkjas");

        assertEquals(REWARDS, parsedType);
    }

    @Test
    public void parseShouldReturnRewardsCustomerTypeReceivingAStringFullOfGarbage2() throws Exception {

        CustomerType parsedType = parser.parse("asdasdasdrewards askdkajsdkasdjk ajsdjasdkjas");

        assertEquals(REWARDS, parsedType);
    }

    @Test(expected = AbsentPatternException.class)
    public void parseShouldThrowAbsentPatternExceptionWhenNoPatternIsFound() throws Exception {

        parser.parse("A String with no CustomerType Patterns");

    }

}
