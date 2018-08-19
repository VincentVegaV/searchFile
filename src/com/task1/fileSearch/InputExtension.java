package com.task1.fileSearch;

/**
 *
 *
 */
class InputExtension {
    private static String extension;

    /**
     *
     *
     * @param p
     * @throws NullPointerException
     */
    static void setExtension(String p) throws NullPointerException {
        if (p != null) {
            extension = p;
        }else {
            throw new NullPointerException();
        }
    }

    static String getExtension() {
        return extension;
    }
}
