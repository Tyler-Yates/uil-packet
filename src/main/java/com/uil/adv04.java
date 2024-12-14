package com.uil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class adv04 {
    private static long getResult(final String input) {
        final ArrayList<String> digits = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            digits.add(String.valueOf(input.charAt(i)));
        }

        // Sort the digits in reverse order to get the biggest number possible
        digits.sort(Comparator.reverseOrder());

        long firstNum = 0;
        long secondNum = 0;
        while (!digits.isEmpty()) {
            String digit = digits.remove(0);
            int digitValue = Integer.parseInt(digit, 16);
            if (firstNum < secondNum) {
                firstNum <<= 4;
                firstNum |= digitValue;
            } else {
                secondNum <<= 4;
                secondNum |= digitValue;
            }
        }

        return firstNum * secondNum;
    }

    private static void processLine(final String line) {
        final String[] parts = line.split(" ");
        int numDigits = Integer.parseInt(parts[0]);
        String digits = parts[1].substring(0, numDigits);

        final long result = getResult(digits);

        System.out.printf("%d%n", result);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numLines; i++) {
            processLine(scanner.nextLine());
        }
    }
}
