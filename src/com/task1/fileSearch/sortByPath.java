package com.task1.fileSearch;
import java.io.File;
import java.io.IOException;
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

class sortByPath {
    private int fileCount;
    Scanner inputString = new Scanner(System.in);

    void findFiles() {

        try {
            //Enter path
            System.out.println(Messages.enterPath);
            InputPath.setPath(inputString.nextLine());
            //Enter extension
            System.out.println(Messages.enterExt);
            //ine.setExtension(inputString.nextLine());
            InputExtension.setExtension(inputString.nextLine());

            final String patternString;
            patternString = "." + "\\." + InputExtension.getExtension() + "$";

            //Set path
            File f = new File(InputPath.getPath());
            //Set pattern extension ("." - any char, "$" - end of the line, "\\." - shielding of ".")
            Pattern p = Pattern.compile(patternString);

            //Save list of files from the path to File[] array
            File[] arrayFiles = f.listFiles();

            ArrayList<FileTime> foundDates = new ArrayList<>();
            ArrayList<String> foundNames = new ArrayList<>();

            for (File arrayFile : arrayFiles) {
                Matcher m = p.matcher(arrayFile.getName());
                if (m.find() && !arrayFile.isDirectory()) {
                    Path pa = Paths.get(arrayFile.getPath());
                    BasicFileAttributes attr = Files.readAttributes(pa, BasicFileAttributes.class);
                    //Messages.printMessage(arrayFiles[i].getName() + " " + Messages.creationTime + attr.creationTime().toInstant().atZone(ZoneId.systemDefault()));

                    foundDates.add(attr.creationTime());
                    foundNames.add(arrayFile.getName());

                    fileCount++;
                }
            }
                //Print count of files
                System.out.println(Messages.resultCount + fileCount);

                System.out.println(SortByName.getNewestFileName(foundDates, foundNames));
                System.out.println(getNewestFileDate(foundDates).toInstant().atZone(ZoneId.systemDefault()));



                //Выводит список имен, которые были созданы в течение 10 сек после свежего файла. Отсортировано по возрастанию.
                //СДЕЛАТЬ СОРТИРОВКУ ПО УБЫВАНИЮ (в SortByName -> sortByName)
                //СОЗДАТЬ МЕТОД, КОТОРЫЙ БУДЕТ ОПРЕДЕЛЯТЬ, СКОЛЬКО ИМЕН НУЖНО ЗАПИСАТЬ В МАССИВ (9)
                //СДЕЛАТЬ ВЫВОД ЗНАЧЕНИЙ ИЗ ARRAYLIST С НОВОЙ СТРОКИ
                System.out.println(sortByName(getListFileName(getNewestFileDate(foundDates), foundDates, foundNames), getListFileDate(getNewestFileDate(foundDates), foundDates, foundNames)));





            //Close stream
                inputString.close();
        } catch (NullPointerException | ArrayIndexOutOfBoundsException | IOException e) {
            e.printStackTrace();
            inputString.close();
        } finally {
            inputString.close();
        }
    }
}