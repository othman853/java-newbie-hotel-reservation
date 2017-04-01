package com.yrachid.reservations.repositories;

import com.yrachid.reservations.domain.Hotel;
import org.junit.Test;

import java.util.Collection;

public class InMemoryHotelRepositoryTest {

    private final InMemoryHotelRepository repository = new InMemoryHotelRepository();

    @Test
    public void shouldReturnHotelsDescribedInTheExercise() throws Exception {

        Collection<Hotel> hotelList = repository.all();

    }

}