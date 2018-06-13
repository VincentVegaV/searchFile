package com.task1.fileSearch;
import java.lang.String;

class InputPath {
    private String path;


    final void setPath(String p) throws NullPointerException {
        if (p != null) {
            path = p;
        }else {
            throw new NullPointerException();
        }
    }

    final String getPath() {
        return path;
    }
}
