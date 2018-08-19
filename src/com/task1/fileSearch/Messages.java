package com.task1.fileSearch;
/**
 * "Message" class contains messages and other text output
 *
 * @author a2.verbitsky
 * @version 1.0
 */
class Messages {
    /**The field resets a color of a text*/
    final static String ANSI_RESET = "\u001B[0m";

    /**The field colors text in red*/
    final static String ANSI_RED = "\u001B[31m";

    /**The field colors text in green*/
    private final static String ANSI_GREEN = "\u001B[32m";

    /**The field colors text in blue*/
    final static String ANSI_BLUE = "\u001B[34m";

    /**The field colors text in purple*/
    private final static String ANSI_PURPLE = "\u001B[35m";
    
    final static String enterPath = ANSI_PURPLE + "Enter file path (absolute path):" + ANSI_RESET;
    final static String enterExt = "Enter file extension (without '.'):";
    final static String resultCount = ANSI_GREEN + "Found files: " + ANSI_RESET;
    final static String newestFileName = "\n" + ANSI_BLUE + "The newest file name: " + ANSI_RESET;
    final static String newestFileDate = ANSI_BLUE + "The newest file date: " + ANSI_RESET;
    final static String listFiles = ANSI_BLUE + "The list of older files:" + ANSI_RESET;
}
