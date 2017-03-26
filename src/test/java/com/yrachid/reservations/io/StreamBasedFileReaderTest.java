package com.yrachid.reservations.io;


import com.yrachid.reservations.exceptions.InvalidFileException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collection;

import static java.lang.String.format;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class StreamBasedFileReaderTest {

    private static final String BASE_PATH = System.getProperty("user.dir") + "/src/test/resources/files/%s";

    private static final String INEXISTENT_FILE = "/I_DO_NOT_EXIST_IN_THIS_LONELY_FILE_SYSTEM";
    private static final String NO_PERMISSION_FILE = format(BASE_PATH, "no_permission_file");
    private static final String EMPTY_FILE = format(BASE_PATH, "empty_file");
    private static final String FILE_WITH_TWO_ENTRIES = format(BASE_PATH, "two_entries_file");
    private static final String A_DIRECTORY = System.getProperty("user.dir") + "/src/test/resources/files/";

    private StreamBasedFileReader reader;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructor_ShouldNotCreate_WhenFileDoesntExists() throws Exception {

        expectedException.expect(InvalidFileException.class);
        expectedException.expectMessage("The specified file does not exist");

        reader = new StreamBasedFileReader(INEXISTENT_FILE);

    }

    @Test
    public void constructor_ShouldNotCreate_WhenPathIsNotAFile() throws Exception {

        expectedException.expect(InvalidFileException.class);
        expectedException.expectMessage("The specified file is not a valid file");

        reader = new StreamBasedFileReader(A_DIRECTORY);

    }

    @Test
    @Ignore
    public void constructor_ShouldNotCreate_WhenFileIsNotReadableForLackOfPermission() throws Exception {

        expectedException.expect(InvalidFileException.class);
        expectedException.expectMessage("This file cannot be read by this user");

        reader = new StreamBasedFileReader(NO_PERMISSION_FILE);
    }

    @Test
    public void readLines_ReturnAnEmptyIterable_WhenFileIsEmpty() throws Exception {

        reader = new StreamBasedFileReader(EMPTY_FILE);

        Iterable<String> fileLines = reader.readLines();
        boolean isIterableEmpty = !fileLines.iterator().hasNext();

        assertTrue(isIterableEmpty);
    }

    @Test
    public void readLines_ReturnAnIterableWithTwoFileLines_WhenFileHasTwoLines() throws Exception {
        int expectedSize = 2;
        reader = new StreamBasedFileReader(FILE_WITH_TWO_ENTRIES);

        Collection<String> fileLines = reader.readLines();
        int actualSize = fileLines.size();

        assertEquals(expectedSize, actualSize);
    }


}
