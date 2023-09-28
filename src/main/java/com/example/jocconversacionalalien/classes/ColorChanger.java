package com.example.jocconversacionalalien.classes;
public class ColorChanger {
    public static void printTextToBlue(String word) {
            // ANSI escape code to BLUE
            System.out.print("\u001B[34m");
            System.out.println(word);
            System.out.print("\u001B[0m");
        }
    public static void printTextToBlack(String word) {
        // ANSI escape code to BLACK
        System.out.print("\u001B[30m");
        System.out.println(word);
        System.out.print("\u001B[0m");
    }
    public static void printTextToRed(String word) {
        // ANSI escape code to RED
        System.out.print("\u001B[31m");
        System.out.println(word);
        System.out.print("\u001B[0m");
    }
    public static void printTextToGreen(String word) {
        // ANSI escape code to GREEN
        System.out.print("\u001B[32m");
        System.out.println(word);
        System.out.print("\u001B[0m");
    }
}