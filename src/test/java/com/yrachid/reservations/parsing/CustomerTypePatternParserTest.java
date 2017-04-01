package com.yrachid.reservations.parsing;


import com.yrachid.reservations.domain.CustomerType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static com.yrachid.reservations.domain.CustomerType.REGULAR;
import static com.yrachid.reservations.domain.CustomerType.REWARDS;
import static org.junit.Assert.assertEquals;

public class CustomerTypePatternParserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CustomerTypePatternParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new CustomerTypePatternParser();
    }

    @Test
    public void shouldFindRegularIgnoringWhiteSpaces() throws Exception {
        CustomerType parsedType = parser.parse(" Regular").get();

        assertEquals(REGULAR, parsedType);
    }

    @Test
    public void shouldNotFindWhenTypeIsNotExactlyRegular() throws Exception {
        Optional<CustomerType> parsedType = parser.parse("FRegular");

        assertEquals(false, parsedType.isPresent());
    }

    @Test
    public void shouldNotFindWhenTypeIsNotExactlyRewards() throws Exception {

        Optional<CustomerType> parsedType = parser.parse("FRewards");

        assertEquals(false, parsedType.isPresent());

    }

    @Test
    public void parseShouldReturnRegularCustomerType() throws Exception {

        CustomerType parsedType = parser.parse("Regular").get();

        assertEquals(REGULAR, parsedType);
    }

    @Test
    public void parseShouldReturnRewardsCustomerType() throws Exception {

        CustomerType parsedType = parser.parse("Rewards").get();

        assertEquals(REWARDS, parsedType);
    }

    @Test
    public void parseShouldReturnRewardsCustomerTypeBeingCaseInsensitive() throws Exception {

        CustomerType parsedType = parser.parse("rewards").get();

        assertEquals(REWARDS, parsedType);
    }

}
