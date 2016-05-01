package com.yrachid.reservations.io;


import com.yrachid.reservations.data.FileLine;
import com.yrachid.reservations.exceptions.InvalidFileException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collection;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static resources.PathHelper.*;

public class StreamBasedFileReaderTest {

    private StreamBasedFileReader reader;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructor_ShouldNotCreate_WhenFileDoesntExists() throws Exception {

        expectedException.expect(InvalidFileException.class);
        expectedException.expectMessage("The specified file does not exist");

        reader = new StreamBasedFileReader(resolvePath(INEXISTENT_FILE));

    }

    @Test
    public void constructor_ShouldNotCreate_WhenPathIsNotAFile() throws Exception {

        expectedException.expect(InvalidFileException.class);
        expectedException.expectMessage("The specified file is not a valid file");

        reader = new StreamBasedFileReader(resolvePath(A_DIRECTORY));

    }

    @Test
    @Ignore
    public void constructor_ShouldNotCreate_WhenFileIsNotReadableForLackOfPermission() throws Exception {

        expectedException.expect(InvalidFileException.class);
        expectedException.expectMessage("This file cannot be read by this user");

        reader = new StreamBasedFileReader(resolvePath(NO_PERMISSION_FILE));
    }

    @Test
    public void readLines_ReturnAnEmptyIterable_WhenFileIsEmpty() throws Exception {

        reader = new StreamBasedFileReader(resolvePath(EMPTY_FILE));

        Iterable<FileLine> fileLines = reader.readLines();
        boolean isIterableEmpty = !fileLines.iterator().hasNext();

        assertTrue(isIterableEmpty);
    }

    @Test
    public void readLines_ReturnAnIterableWithTwoFileLines_WhenFileHasTwoLines() throws Exception {
        int expectedSize = 2;
        reader = new StreamBasedFileReader(resolvePath(FILE_WITH_TWO_ENTRIES));

        Collection<FileLine> fileLines = reader.readLines();
        int actualSize = fileLines.size();

        assertEquals(expectedSize, actualSize);
    }

}
