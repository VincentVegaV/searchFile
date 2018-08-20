package com.task1.fileSearch;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.task1.fileSearch.SortByDate.*;
import static com.task1.fileSearch.SortByName.*;

/**
 * "Sort by path" class summarize functions from:
 *
 * @see InputExtension
 * @see InputPath
 * @see Messages
 * @see SortByDate
 * @see SortByName
 * @author a2.verbitsky
 * @version 1.0
 */
class sortByPath {
    /**Field contains quantity of files in the directory*/
    private int fileCount;
    /**New instance of Scanner object*/
    private final Scanner inputString = new Scanner(System.in);

    /**
     * Sets input from console (file path and extension). Adds creation file time and
     * file name to collections. Prints the latest file name (by creation date).
     * Prints the list of files with creation date >= 10 sec from the latest file date.
     */
    void findFiles() {

        try {

            System.out.println(Messages.enterPath);
            InputPath.setPath(inputString.nextLine());

            System.out.println(Messages.enterExt);

            InputExtension.setExtension(inputString.nextLine());

            final String patternString;
            patternString = "." + "\\." + InputExtension.getExtension() + "$";

            File f = new File(InputPath.getPath());

            Pattern p = Pattern.compile(patternString);

            File[] arrayFiles = f.listFiles();

            ArrayList<FileTime> foundDates = new ArrayList<>();
            ArrayList<String> foundNames = new ArrayList<>();

            for (File arrayFile : arrayFiles) {
                Matcher m = p.matcher(arrayFile.getName());
                if (m.find() && !arrayFile.isDirectory()) {
                    Path pa = Paths.get(arrayFile.getPath());
                    BasicFileAttributes attr = Files.readAttributes(pa, BasicFileAttributes.class);

                    foundDates.add(attr.creationTime());
                    foundNames.add(arrayFile.getName());

                    fileCount++;
                }
            }

                System.out.print(Messages.resultCount + fileCount);

                System.out.println(Messages.newestFileName + SortByName.getNewestFileName(foundDates, foundNames));
                System.out.println(Messages.newestFileDate + getNewestFileDate(foundDates).toInstant().atZone(ZoneId.systemDefault()));

                ArrayList<FileTime> t;
                ArrayList<String> n;
                t = getListFileDate(getNewestFileDate(foundDates), foundDates, foundNames);
                n = getListFileName(getNewestFileDate(foundDates), foundDates, foundNames);

                System.out.println(Messages.listFiles);

                sortByDate(t, n);

                for(int i=0; i < n.size(); i++) {
                    System.out.println(Messages.ANSI_RED + (i+1) + ") " + Messages.ANSI_RESET + n.get(n.size()-i-1));
                    System.out.println(Messages.ANSI_BLUE + "Date: " + Messages.ANSI_RESET + t.get(t.size()-i-1).toInstant().atZone(ZoneId.systemDefault()));
                }

                inputString.close();
        } catch (NullPointerException | ArrayIndexOutOfBoundsException | IOException e) {
            e.printStackTrace();
            inputString.close();
        } finally {
            inputString.close();
        }
    }
}