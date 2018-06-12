package com.task1.fileSearch;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class sortByPath {
    private int fileCount;
    private boolean isDir = false;

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
            //Set pattern extension ("." - any char, "$" - end of the line, "\\." - shielding of ".")
            Pattern p = Pattern.compile("." + "\\." + ine.getExtension() + "$");

            //Save list of files from the path to File[] array
            File[] arrayFiles = f.listFiles();

            for (File arrayFile : arrayFiles) {
                Matcher m = p.matcher(arrayFile.getName());
                if (m.find() && !arrayFile.isDirectory()) {
                    Path pa = Paths.get(arrayFile.getPath());
                    BasicFileAttributes attr = Files.readAttributes(pa, BasicFileAttributes.class);
                    mes.printMessage(arrayFile.getName() + " " + mes.creationTime + attr.creationTime().toInstant().atZone(ZoneId.systemDefault()));

                    fileCount++;
                }
            }
                //Print count of files
                mes.printMessage(mes.resultCount + fileCount);
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