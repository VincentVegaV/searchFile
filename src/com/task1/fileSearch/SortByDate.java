package com.task1.fileSearch;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

public class SortByDate {

    static FileTime getNewestFileDate(ArrayList<FileTime> dates){
        FileTime recentFile = dates.get(0);
        for (FileTime date : dates) {
            if (recentFile.compareTo(date) > 0) {
                continue;
            } else {
                if (recentFile.compareTo(date) < 0) {
                    recentFile = date;
                }
            }
        }
        return recentFile;
    }
/*
    static FileTime sortDate(ArrayList<FileTime> dates){
        ArrayList<FileTime> sortedArray = new ArrayList<>();

        return sortedArray;
    }
*/
}
