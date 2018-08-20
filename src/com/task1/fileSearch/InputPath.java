package com.task1.fileSearch;
import java.lang.String;

/**
 * "Input path" class contain getter and setter methods for
 * a path value
 *
 * @author a2.verbitsky
 * @version 1.0
 */
class InputPath {
    /**Path field*/
    private static String path;

    /**
     * Method saves path value
     *
     * @param p filled path string
     * @throws NullPointerException returns in case of an empty string
     */
    static void setPath(String p) throws NullPointerException {
        if (p != null) {
            path = p;
        }else {
            throw new NullPointerException();
        }
    }

    /**
     * Method gets saved path
     *
     * @return returns path string
     */
    static String getPath() {
        return path;
    }
}
