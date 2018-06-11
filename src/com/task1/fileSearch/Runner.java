package com.task1.fileSearch;

import jdk.jfr.StackTrace;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        InputPath inp = new InputPath();
        Scanner inputString = new Scanner(System.in);

        try {
            inp.setPath(inputString.nextLine());

            System.out.println(inp.getPath());

            inputString.close();
        }catch(NullPointerException e){
            //stack trace не выводит
            e.printStackTrace();

            inputString.close();
        }finally {
            inputString.close();
        }
    }
}
