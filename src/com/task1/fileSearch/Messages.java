package com.task1.fileSearch;

class Messages {
        final static String ANSI_RESET = "\u001B[0m";
        final static String ANSI_RED = "\u001B[31m";
        private final static String ANSI_GREEN = "\u001B[32m";
        final static String ANSI_BLUE = "\u001B[34m";
        private final static String ANSI_PURPLE = "\u001B[35m";
        final static String enterPath = ANSI_PURPLE + "Enter file path (absolute path):" + ANSI_RESET;
        final static String enterExt = "Enter file extension (without '.'):";
        final static String resultCount = ANSI_GREEN + "Found files: " + ANSI_RESET;
        final static String newestFileName = "\n" + ANSI_BLUE + "The newest file name: " + ANSI_RESET;
        final static String newestFileDate = ANSI_BLUE + "The newest file date: " + ANSI_RESET;
        final static String listFiles = ANSI_BLUE + "The list of older files:" + ANSI_RESET;
}
