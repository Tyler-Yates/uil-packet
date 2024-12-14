package com.uil;

import java.util.Scanner;


public class adv02 {
    private static String getResult(final String input) {
        StringBuilder result = new StringBuilder();
        int length = 8;

        for (int i = 0; i < input.length(); i += length) {
            String chunk = input.substring(i, Math.min(i + length, input.length()));
            final char ch = (char) Integer.parseInt(chunk, 2);
            result.append(ch);
        }

        return result.toString();
    }

    private static void processLine(final String line) {
        final String result = getResult(line);

        System.out.printf("%s%n", result);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numLines; i++) {
            processLine(scanner.nextLine());
        }
    }
}
