package com.task1.fileSearch;
import java.lang.String;

class InputPath {
    private String path;


    void setPath(String p) throws NullPointerException {
        if (p != null) {
            path = p;
        }else {
            throw new NullPointerException();
        }
    }

    String getPath() {
        return path;
    }
}
