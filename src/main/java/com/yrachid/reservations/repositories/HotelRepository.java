package com.yrachid.reservations.repositories;


import com.yrachid.reservations.domain.Hotel;

import java.util.Collection;

public interface HotelRepository {

    Collection<Hotel> all();

}
