package com.yrachid.reservations.io;

import com.yrachid.reservations.data.FileLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamBasedFileReader implements FileReader<FileLine>{

    private Path path;

    public StreamBasedFileReader(String pathAsString) throws InvalidFileException {

        Path filePath = Paths.get(pathAsString);

        if (Files.notExists(filePath)) {
            throw new InvalidFileException("The specified file does not exists");
        }

        if (!Files.isRegularFile(filePath)) {
            throw new InvalidFileException("The specified file is not a valid file");
        }

        if (!Files.isReadable(filePath)) {
            throw new InvalidFileException("This file cannot be read by this user");
        }

        this.path = filePath;
    }

    @Override
    public Collection<FileLine> readLines() throws IOException {

        AtomicInteger lineNumber = new AtomicInteger(0);

        List<FileLine> lines = Files
                                .lines(path)
                                .map(value -> new FileLine(lineNumber.incrementAndGet(), value))
                                .collect(Collectors.toList());

        return lines;
    }


}
