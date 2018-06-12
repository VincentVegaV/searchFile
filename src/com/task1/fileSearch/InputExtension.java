package com.task1.fileSearch;

class InputExtension {
    private String extension;


    void setExtension(String p) throws NullPointerException {
        if (p != null) {
            extension = p;
        }else {
            throw new NullPointerException();
        }
    }

    String getExtension() {
        return extension;
    }
}
