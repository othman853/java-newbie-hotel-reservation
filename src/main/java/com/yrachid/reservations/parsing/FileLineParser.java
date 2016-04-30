package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.FileLine;

public interface FileLineParser<T> {

    T parse(FileLine line);

}
