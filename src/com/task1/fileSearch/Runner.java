package com.task1.fileSearch;

import jdk.jfr.StackTrace;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        sortByPath sbp = new sortByPath();
        sbp.findFiles();

    }
}
