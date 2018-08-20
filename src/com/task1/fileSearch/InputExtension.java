package com.task1.fileSearch;

/**
 * "Input extension" class contain getter and setter methods for
 * an extension value
 *
 * @author a2.verbitsky
 * @version 1.0
 */
class InputExtension {

    /**Extension field*/
    private static String extension;

    /**
     * Method saves extension value
     *
     * @param p filled extension string
     * @throws NullPointerException returns in case of an empty string
     */
    static void setExtension(String p) throws NullPointerException {
        if (p != null) {
            extension = p;
        }else {
            throw new NullPointerException();
        }
    }

     /**
     * Method gets saved extension
     *
     * @return returns extension string
     */
    static String getExtension() {
        return extension;
    }
}
