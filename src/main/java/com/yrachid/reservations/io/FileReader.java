package com.yrachid.reservations.io;


import java.io.IOException;

public interface FileReader<T> {
    Iterable<T> readLines() throws IOException;
}
