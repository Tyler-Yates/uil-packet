package com.uil;

import java.util.Scanner;


public class adv13 {
    private static void processLine(final String line) {
        // Lower case and get rid of everything that is not a letter or space.
        final String cleanedLine = line.toLowerCase().replaceAll("[^a-z ]", "");
        final String[] words = cleanedLine.split(" ");

        int numThe = 0;
        for (final String word : words) {
            if (word.equals("the")) {
                numThe++;
            }
        }

        System.out.printf("%.2f%%%n", numThe * 100.0 / words.length);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numLines; i++) {
            processLine(scanner.nextLine());
        }
    }
}
