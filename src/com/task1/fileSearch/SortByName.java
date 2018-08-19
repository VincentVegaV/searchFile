package com.task1.fileSearch;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;


/**
 * "Sort by name" class contains methods that operate list of names
 * and return values
 *
 * @author a2.verbitsky
 * @version 1.0
 */
class SortByName {

    /**
     * Returns the latest file name by provided list of file dates
     *
     * @param dates the list of file dates
     * @param nameFile the list of file names
     * @return the latest created file name
     */
    static String getNewestFileName(ArrayList<FileTime> dates, ArrayList<String> nameFile){
        FileTime recentFile = dates.get(0);
        String name = nameFile.get(0);
        for(int i=0; i < dates.size(); i++){
            if(recentFile.compareTo(dates.get(i)) > 0){
            }else{
                if(recentFile.compareTo(dates.get(i)) < 0){
                    recentFile = dates.get(i);
                    name = nameFile.get(i);
                }
            }
        }
        return name;
    }

    /**
     * Method returns subtracted value (difference in milliseconds)
     *
     * @param mil file creation time in milliseconds
     * @return subtracted value in milliseconds
     */
    static Long minusMillis(long mil){
        long diff = 10000;
        mil = mil - diff;
        return mil;
    }

    /**
     * Method select file names from array with creation dates <b>not greater</b> than minusMillis value
     *
     * @see SortByName#minusMillis
     * @see SortByDate#getNewestFileDate(ArrayList)
     * @param recentFile the latest file creation date
     * @param dates the list of all file dates in the directory
     * @param nameFile the list of all file names from the directory
     * @return the list of file names with creation dates <b>not greater</b> than minusMillis value
     */
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
}


