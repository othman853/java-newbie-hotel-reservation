package com.yrachid.reservations.repositories;


import com.yrachid.reservations.data.Hotel;

import java.util.Collection;

public interface HotelRepository {

    Collection<Hotel> all();

}
