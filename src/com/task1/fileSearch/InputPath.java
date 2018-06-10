package com.task1.fileSearch;
import java.lang.String;

class InputPath {
    private String path;


    void setPath(String p) throws NullPointerException {
            path = p;
    }

    String getPath() throws NullPointerException {
        return path;
    }
}
