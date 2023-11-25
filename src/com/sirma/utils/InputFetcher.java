package com.sirma.utils;

import java.util.Scanner;

public final class InputFetcher {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        System.out.print("?: ");
        return scanner.nextLine();
    }

    public static int getIntegerInput() {
        System.out.print("?: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
            return getIntegerInput();
        }
    }

    public static double getDoubleInput() {
        System.out.print("?: ");
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
            return getDoubleInput();
        }
    }
}
