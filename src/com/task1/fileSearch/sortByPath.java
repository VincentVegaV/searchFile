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

class sortByPath {
    //InputPath inp = new InputPath();
    //InputExtension ine = new InputExtension();
    //Messages mes = new Messages();
    Scanner inputString = new Scanner(System.in);

    private int fileCount;


    void findFiles() {

        try {
            //Enter path
            Messages.printMessage(Messages.enterPath);
            InputPath.setPath(inputString.nextLine());
            //Enter extension
            Messages.printMessage(Messages.enterExt);
            //ine.setExtension(inputString.nextLine());
            InputExtension.setExtension(inputString.nextLine());

            String patternString = "." + "\\." + InputExtension.getExtension() + "$";

            //Set path
            File f = new File(InputPath.getPath());
            //Set pattern extension ("." - any char, "$" - end of the line, "\\." - shielding of ".")
            Pattern p = Pattern.compile(patternString);

            //Save list of files from the path to File[] array
            File[] arrayFiles = f.listFiles();

            ArrayList<FileTime> foundDates = new ArrayList<>();
            ArrayList<String> foundNames = new ArrayList<>();

            for (int i=0; i < arrayFiles.length; ++i) {
                Matcher m = p.matcher(arrayFiles[i].getName());
                if (m.find() && !arrayFiles[i].isDirectory()) {
                    Path pa = Paths.get(arrayFiles[i].getPath());
                    BasicFileAttributes attr = Files.readAttributes(pa, BasicFileAttributes.class);
                    //Messages.printMessage(arrayFiles[i].getName() + " " + Messages.creationTime + attr.creationTime().toInstant().atZone(ZoneId.systemDefault()));

                    foundDates.add(attr.creationTime());
                    foundNames.add(arrayFiles[i].getName());

                    fileCount++;
                }
            }
                //Print count of files
                Messages.printMessage(Messages.resultCount + fileCount);
                //Messages.printMessage(foundNames.toString());
                Messages.printMessage(foundDates.toString());

                System.out.println(SortByDate.sortDates(foundDates).toInstant().atZone(ZoneId.systemDefault()));

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