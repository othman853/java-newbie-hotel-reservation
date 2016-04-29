package com.yrachid.reservations.io;


import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public interface FileReader<T> {
    Iterable<T> readLines() throws IOException;
}
