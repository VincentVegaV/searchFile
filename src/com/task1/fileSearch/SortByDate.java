package com.task1.fileSearch;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

import static com.task1.fileSearch.SortByName.minusMillis;

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


    static ArrayList<FileTime> getListFileDate(FileTime recentFile, ArrayList<FileTime> dates, ArrayList<String> nameFile){
        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<FileTime> dateList = new ArrayList<>();
        long file = recentFile.toMillis();

        for (int i=0; i < dates.size(); ++i){
            if(dates.get(i).toMillis() > minusMillis(file) && dates.get(i).toMillis() < file){
                namesList.add(nameFile.get(i));
                dateList.add(dates.get(i));
            }
        }
        return dateList;
    }

    static void sortByDate(ArrayList<FileTime> dates, ArrayList<String> names)
    {
        int bubbleCount = dates.size();

        for (int i=0; i < bubbleCount-1; i++)
            for (int j=0; j < bubbleCount - i - 1; j++)
                if (dates.get(j).toMillis() > dates.get(j+1).toMillis())
                {
                    FileTime temp = dates.get(j);
                    dates.set(j, dates.get(j + 1));
                    dates.set(j + 1, temp);

                    String tempString = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, tempString);
                }
    }


}
