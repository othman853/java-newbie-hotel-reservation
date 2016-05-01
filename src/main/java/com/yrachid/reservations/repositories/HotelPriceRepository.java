package com.yrachid.reservations.repositories;


import com.yrachid.reservations.data.HotelPrice;

import java.util.Collection;
import java.util.List;

public interface HotelPriceRepository {

    Collection<HotelPrice> byHotelId(int hotelId);

}
