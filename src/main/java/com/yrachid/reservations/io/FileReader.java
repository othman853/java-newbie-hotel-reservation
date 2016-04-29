package com.yrachid.reservations.io;


import java.io.IOException;
import java.util.Collection;

public interface FileReader<T> {
    Collection<T> readLines() throws IOException;
}
