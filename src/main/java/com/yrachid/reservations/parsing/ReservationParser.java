package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.CustomerType;
import com.yrachid.reservations.data.FileLine;
import com.yrachid.reservations.data.Reservation;

import java.util.ArrayList;

public class ReservationParser implements FileLineParser<Reservation>{

    @Override
    public Reservation parse(FileLine line) {
        return new Reservation(CustomerType.REGULAR, new ArrayList<>());
    }

}
