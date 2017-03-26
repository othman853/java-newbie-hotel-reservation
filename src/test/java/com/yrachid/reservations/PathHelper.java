package com.yrachid.reservations;

public class PathHelper {

    public static final String INEXISTENT_FILE = "/I_DO_NOT_EXIST_IN_THIS_LONELY_FILE_SYSTEM";
    public static final String NO_PERMISSION_FILE = "/src/main/test/resources/files/no_permission_file";
    public static final String EMPTY_FILE = "/src/main/test/resources/files/empty_file";
    public static final String FILE_WITH_TWO_ENTRIES = "/src/main/test/resources/files/two_entries_file";
    public static final String A_DIRECTORY = "/src/main/test/resources/files/";


    public static String resolvePath(String partialFilePath) {
        return System.getProperty("user.dir") + partialFilePath;
    }

}
