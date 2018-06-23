package com.task1.fileSearch;

class Messages {
        final static String ANSI_RESET = "\u001B[0m";
        final static String ANSI_RED = "\u001B[31m";
        final static String ANSI_GREEN = "\u001B[32m";
        final static String enterPath = "Enter file path (absolute path):";
        final static String enterExt = "Enter file extension (without '.'):";
        final static String resultCount = "\n" + ANSI_GREEN + "Found files: " + ANSI_RESET;
        final static String creationTime = "\n" + ANSI_RED + "Creation time: " + ANSI_RESET;


        static String printMessage(String m){
            return m;
        }
}
