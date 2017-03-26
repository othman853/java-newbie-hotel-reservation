package com.yrachid.reservations;

import static java.lang.String.format;

public final class PathHelper {

    private static final String BASE_PATH = System.getProperty("user.dir")  + "/src/test/resources/files/%s";

    public static final String INEXISTENT_FILE = "/I_DO_NOT_EXIST_IN_THIS_LONELY_FILE_SYSTEM";
    public static final String NO_PERMISSION_FILE = format(BASE_PATH, "no_permission_file");
    public static final String EMPTY_FILE = format(BASE_PATH, "empty_file");
    public static final String FILE_WITH_TWO_ENTRIES = format(BASE_PATH, "two_entries_file");
    public static final String A_DIRECTORY = System.getProperty("user.dir")  +  "/src/test/resources/files/";

    private PathHelper() {}
}
