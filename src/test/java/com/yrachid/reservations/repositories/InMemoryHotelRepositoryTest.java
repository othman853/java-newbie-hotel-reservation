package com.yrachid.reservations.repositories;

import com.yrachid.reservations.data.Hotel;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class InMemoryHotelRepositoryTest {

    private final InMemoryHotelRepository repository = new InMemoryHotelRepository();

    @Test
    public void shouldReturnHotelsDescribedInTheExercise() throws Exception {

        Collection<Hotel> hotelList = repository.all();

    }

}