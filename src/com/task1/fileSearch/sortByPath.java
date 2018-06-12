package com.task1.fileSearch;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class sortByPath {
    private int fileCount;

    void findFiles() {
        InputPath inp = new InputPath();
        InputExtension ine = new InputExtension();
        Messages mes = new Messages();
        Scanner inputString = new Scanner(System.in);


        try {
            //Enter path
            mes.printMessage(mes.enterPath);
            inp.setPath(inputString.nextLine());
            //Enter extension
            mes.printMessage(mes.enterExt);
            ine.setExtension(inputString.nextLine());


            //Set path
            File f = new File(inp.getPath());
            //Set pattern extension (NEED TO FIX)
            Pattern p = Pattern.compile("." + ine.getExtension());

            //Save list of files from the path to File[] array
            File[] arrayFiles = f.listFiles();

            for (File arrayFile : arrayFiles) {
                Matcher m = p.matcher(arrayFile.getName());
                if (m.find()) {
                    System.out.println(arrayFile.getName());
                    fileCount++;
                }
            }
                //Print count of files
                mes.printMessage(mes.resultCount + fileCount);
            //Close stream
            inputString.close();
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            inputString.close();
        } finally {
            inputString.close();
        }
    }
}