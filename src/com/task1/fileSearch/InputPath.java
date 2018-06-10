package com.task1.fileSearch;

import java.util.Scanner;

public class InputPath {
    private Scanner path;

    Scanner inputString = new Scanner(System.in);

    public void setInputString(Scanner inputString) {
        this.inputString = inputString;
    }

    public Scanner getInputString() {
        return inputString;
    }
}
