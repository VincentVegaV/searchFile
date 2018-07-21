package com.task1.fileSearch;
import java.io.File;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortByName {


    static String getNewestFileName(ArrayList<FileTime> dates, ArrayList<String> nameFile){
        FileTime recentFile = dates.get(0);
        String name = nameFile.get(0);
        for(int i=0; i < dates.size(); i++){
            if(recentFile.compareTo(dates.get(i)) > 0){
                continue;
            }else{
                if(recentFile.compareTo(dates.get(i)) < 0){
                    recentFile = dates.get(i);
                    name = nameFile.get(i);
                }
            }
        }
        return name;
    }

    static Long minusMillis(long mil){
        long diff = 10000;
        mil = mil - diff;
        return mil;
    }


    static ArrayList<String> getListFileName(FileTime recentFile, ArrayList<FileTime> dates, ArrayList<String> nameFile){
        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<FileTime> dateList = new ArrayList<>();
        long file = recentFile.toMillis();

        for (int i=0; i < dates.size(); ++i){
            if(dates.get(i).toMillis() > minusMillis(file) && dates.get(i).toMillis() < file){
                namesList.add(nameFile.get(i));
                dateList.add(dates.get(i));
            }
        }
        return namesList;
    }


    //out-of-date (to be edited)
    static ArrayList<String> sortByName(ArrayList<String> names, ArrayList<FileTime> dates){

        String temp;

            for (int i = 0; i < dates.size() - 1; i++) {
                for (int j = i + 1; j < dates.size(); j++) {
                    if (dates.get(i).toMillis() > dates.get(j).toMillis()) {
                        temp = names.get(j);
                        names.add(j, names.get(i));
                        names.add(i, temp);
                    }
                }
            }

        return names;
    }


}


