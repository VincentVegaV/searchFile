package com.task1.fileSearch;

class InputExtension {
    private String extension;


    final void setExtension(String p) throws NullPointerException {
        if (p != null) {
            extension = p;
        }else {
            throw new NullPointerException();
        }
    }

    final String getExtension() {
        return extension;
    }
}
