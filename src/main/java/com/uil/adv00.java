package com.uil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {
    int males;
    int females;

    public Result(int males, int females) {
        this.males = males;
        this.females = females;
    }
}

public class adv00 {
    private static Result getGenerationNumber(final String gender, final int generation) {
        List<String> bees = new ArrayList<>();
        bees.add(gender);

        for (int i = 0; i < generation; i++) {
            List<String> newBees = new ArrayList<>();

            for (final String bee : bees) {
                if (bee.equalsIgnoreCase("female")) {
                    newBees.add("male");
                    newBees.add("female");
                } else {
                    newBees.add("female");
                }
            }

            bees = newBees;
        }

        int males = 0;
        int females = 0;
        for (final String bee : bees) {
            if (bee.equalsIgnoreCase("female")) {
                females++;
            } else {
                males++;
            }
        }

        return new Result(males, females);
    }

    private static void processLine(final String line) {
        final String[] parts = line.split(" ");
        final String gender = parts[0];
        final int generation = Integer.parseInt(parts[1]);

        final Result result = getGenerationNumber(gender, generation);
        System.out.printf("%d male(s) %d female(s)%n", result.males, result.females);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <numLines; i++) {
            processLine(scanner.nextLine());
        }
    }
}
