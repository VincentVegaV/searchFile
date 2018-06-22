package com.task1.fileSearch;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

public class SortByName {


    static String getNewestFileName(ArrayList<FileTime> dates, ArrayList<String> nameFile){
        FileTime recentFile = dates.get(0);
        String name = nameFile.get(0);
        for(int i=0; i < dates.size(); i++){
            if(recentFile.compareTo(dates.get(i)) > 0){
                recentFile = recentFile;
                name = name;
            }else{
                if(recentFile.compareTo(dates.get(i)) < 0){
                    recentFile = dates.get(i);
                    name = nameFile.get(i);
                }
            }
        }
        return name;
    }

/*
    static ArrayList<FileTime> getListFileName(FileTime recentFile, ArrayList<FileTime> dates, ArrayList<String> nameFile){
        ArrayList<String> namesList;
        ArrayList<FileTime> datesList;




        return fileList;
    }
*/


}


