package com.task1.fileSearch;
import java.lang.String;

class InputPath {
    private static String path;


    static void setPath(String p) throws NullPointerException {
        if (p != null) {
            path = p;
        }else {
            throw new NullPointerException();
        }
    }

    static String getPath() {
        return path;
    }
}
