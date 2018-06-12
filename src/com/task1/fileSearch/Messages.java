package com.task1.fileSearch;

class Messages {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String enterPath = "Enter file path (absolute path):";
        final String enterExt = "Enter file extension (without '.'):";
        final String resultCount = "\n" + ANSI_GREEN + "Found files: " + ANSI_RESET;
        final String creationTime = "\n" + ANSI_RED + "Creation time: " + ANSI_RESET;


        String printMessage(String m){
            System.out.println(m);
            return m;
        }
}
