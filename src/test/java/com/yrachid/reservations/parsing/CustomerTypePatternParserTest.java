package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.exceptions.AbsentPatternException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.yrachid.reservations.data.CustomerType.REGULAR;
import static com.yrachid.reservations.data.CustomerType.REWARDS;
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
        CustomerType parsedType = parser.parse(" Regular");

        assertEquals(REGULAR, parsedType);
    }

    @Test
    public void shouldNotFindWhenTypeIsNotExactlyRegular() throws Exception {
        expectedException.expect(AbsentPatternException.class);
        expectedException.expectMessage("FRegular does not match any customer type");

        parser.parse("FRegular");
    }

    @Test
    public void shouldNotFindWhenTypeIsNotExactlyRewards() throws Exception {

        expectedException.expect(AbsentPatternException.class);
        expectedException.expectMessage("FRewards does not match any customer type");

        parser.parse("FRewards");

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

    @Test(expected = AbsentPatternException.class)
    public void parseShouldThrowAbsentPatternExceptionWhenNoPatternIsFound() throws Exception {

        parser.parse("A String with no CustomerType Patterns");

    }

}
