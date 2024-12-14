package com.uil;

import java.util.Scanner;


public class adv01 {
    private static class Result {
        int time;
        String ampm;

        public Result(int time, String ampm) {
            this.time = time;
            this.ampm = ampm;
        }
    }

    private static Result getResult(int currentTime, String ampm, String operator, int hours) {
        int currentMilitaryTime = currentTime;
        if (ampm.equalsIgnoreCase("pm") && currentTime != 12) {
            currentMilitaryTime += 12;
        } else if (ampm.equalsIgnoreCase("am") && currentTime == 12) {
            currentMilitaryTime = 0;
        }

        hours = hours % 24;

        if (operator.equalsIgnoreCase("-")) {
            hours = -hours;
        }

        currentMilitaryTime += hours;

        if (currentMilitaryTime < 0) {
            currentMilitaryTime += 24;
        }
        if (currentMilitaryTime >= 24) {
            currentMilitaryTime -= 24;
        }

        if (currentMilitaryTime == 0) {
            return new Result(12, "AM");
        }
        if (currentMilitaryTime == 12) {
            return new Result(12, "PM");
        }
        if (currentMilitaryTime > 12) {
            return new Result(currentMilitaryTime - 12, "PM");
        }
        return new Result(currentMilitaryTime, "AM");
    }

    private static void processLine(final String line) {
        final String[] parts = line.split(" ");
        final int currentTime = Integer.parseInt(parts[0]);
        final String ampm = parts[1];
        final String operator = parts[2];
        final int hours = Integer.parseInt(parts[3]);

        final Result result = getResult(currentTime, ampm, operator, hours);

        System.out.printf("%d %s%n", result.time, result.ampm);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numLines; i++) {
            processLine(scanner.nextLine());
        }
    }
}
