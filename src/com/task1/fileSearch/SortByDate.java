package com.task1.fileSearch;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

public class SortByDate {

    static FileTime sortDates(ArrayList<FileTime> dates){
        FileTime recentFile = dates.get(0);
        for(int i=0; i < dates.size(); ++i){
            if(recentFile.compareTo(dates.get(i)) > 0){
                recentFile = recentFile;
            }else{
                if(recentFile.compareTo(dates.get(i+1)) < 0){
                    recentFile = dates.get(i);
                }
            }
        }
        return recentFile;
    }

}
