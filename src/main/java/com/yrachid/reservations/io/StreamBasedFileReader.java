package com.yrachid.reservations.io;

import com.yrachid.reservations.exceptions.InvalidFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamBasedFileReader implements FileReader<String> {

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
    public Collection<String> readLines() throws IOException {

        return Files
                .lines(path)
                .collect(Collectors.toList());
    }


}
