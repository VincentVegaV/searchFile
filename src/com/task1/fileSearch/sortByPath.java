package com.task1.fileSearch;
import java.io.File;
import java.util.Scanner;
import java.nio.file.*;

public class sortByPath {

    void findFiles() {
        InputPath inp = new InputPath();
        Messages mes = new Messages();
        Scanner inputString = new Scanner(System.in);


        try {
            mes.printMessage(mes.enterPath);
            inp.setPath(inputString.nextLine());
            File f = new File(inp.getPath());

            PathMatcher matcher =
                    FileSystems.getDefault().getPathMatcher("glob:*.{txt,class}");

            File arrayFiles[] = f.listFiles();

                for (int i = 0; i <= arrayFiles.length; ++i) {
                    if (matcher.matches(arrayFiles[i])) {
                    System.out.println(arrayFiles[i]);
            }
                }

                System.out.println(arrayFiles.length);
            inputString.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
            inputString.close();
        } finally {
            inputString.close();
        }
    }
}