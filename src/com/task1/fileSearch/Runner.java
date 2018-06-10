package com.task1.fileSearch;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        InputPath inp = new InputPath();
        Scanner inputString = new Scanner(System.in);

        inp.setPath(inputString.nextLine());
        System.out.println(inp.getPath());
        inputString.close();
    }
}
