package com.uil;

import java.util.Scanner;


public class adv14 {
    private static void processLine(final String line) {
        try {
            Byte.parseByte(line);
            System.out.println("byte");
            return;
        } catch (NumberFormatException ignored) {}

        try {
            Short.parseShort(line);
            System.out.println("short");
            return;
        } catch (NumberFormatException ignored) {}

        try {
            Integer.parseInt(line);
            System.out.println("integer");
            return;
        } catch (NumberFormatException ignored) {}

        try {
            Long.parseLong(line);
            System.out.println("long");
            return;
        } catch (NumberFormatException ignored) {}

        try {
            Double.parseDouble(line);
            System.out.println("double");
            return;
        } catch (NumberFormatException ignored) {}

        if (line.equals("true")) {
            System.out.println("boolean");
            return;
        }

        if (line.equals("false")) {
            System.out.println("boolean");
            return;
        }

        if (line.length() == 1) {
            System.out.println("character");
        } else {
            System.out.println("string");
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numLines; i++) {
            processLine(scanner.nextLine());
        }
    }
}
