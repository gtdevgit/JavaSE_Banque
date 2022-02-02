package com.mini.banque;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String message){
        System.out.println(message);
        String value = scanner.next();
        return value;
    }

    public static int getInt(String message){
        System.out.println(message);
        int value = scanner.nextInt();
        return value;
    }

    public static float getFloat(String message){
        System.out.println(message);
        float value = scanner.nextFloat();
        return value;
    }

    public static void closeScanner(){
        scanner.close();
    };
}
