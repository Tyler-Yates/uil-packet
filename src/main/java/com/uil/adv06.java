package com.uil;

import java.util.*;


@SuppressWarnings("StringConcatenationInLoop")
public class adv06 {
    private static final Set<String> OPERATORS = Set.of("  +  ", "  -  ", "  /  ", "  *  ", "  ^  ");
    private static final int CHUNK_ROWS = 5;
    private static final int CHUNK_COLS = 3;

    private static final List<String[]> NUMBERS = List.of(
            new String[]{
                    "---",
                    "- -",
                    "- -",
                    "- -",
                    "---",
            },
            new String[]{
                    "-- ",
                    " - ",
                    " - ",
                    " - ",
                    "---",
            },
            new String[]{
                    "---",
                    "  -",
                    " - ",
                    "-  ",
                    "---",
            },
            new String[]{
                    "---",
                    "  -",
                    "---",
                    "  -",
                    "---",
            },
            new String[]{
                    "- -",
                    "- -",
                    "---",
                    "  -",
                    "  -",
            },
            new String[]{
                    "---",
                    "-  ",
                    "---",
                    "  -",
                    "---",
            },
            new String[]{
                    "-  ",
                    "-  ",
                    "---",
                    "- -",
                    "---",
            },
            new String[]{
                    "---",
                    "  -",
                    "  -",
                    "  -",
                    "  -",
            },
            new String[]{
                    "---",
                    "- -",
                    "---",
                    "- -",
                    "---",
            },
            new String[]{
                    "---",
                    "- -",
                    "---",
                    "  -",
                    "  -",
            }
    );

    private static class Result {
        List<Integer> numbers;
        List<Character> operators;

        public Result(List<Integer> numbers, List<Character> operators) {
            this.numbers = numbers;
            this.operators = operators;
        }
    }

    private static int getNumberFromChunk(final String[] chunk) {
        for (int i = 0; i < NUMBERS.size(); i++) {
            final String[] number = NUMBERS.get(i);
            if (Arrays.deepEquals(number, chunk)) {
                return i;
            }
        }

        // This should never happen!
        throw new RuntimeException("BAD NUMBER!");
    }

    private static Result getResult(final String[] lines) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        int colOffset = 0;
        String currentNumber = "";

        while (colOffset < lines[0].length()) {
            String[] chunk = new String[CHUNK_ROWS];
            for (int r = 0; r < CHUNK_ROWS; r++) {
                StringBuilder s = new StringBuilder();
                for (int c = 0; c < CHUNK_COLS; c++) {
                    final int colIndex = c + colOffset;
                    if (colIndex >= lines[r].length()) {
                        s.append(" ");
                    } else {
                        s.append(lines[r].charAt(colIndex));
                    }
                }
                chunk[r] = s.toString();
            }

            final StringBuilder firstColumnBuilder = new StringBuilder();
            for (int r = 0; r < CHUNK_ROWS; r++) {
                firstColumnBuilder.append(chunk[r].charAt(0));
            }
            final String firstColumn = firstColumnBuilder.toString();
            if (OPERATORS.contains(firstColumn)) {
                numbers.add(Integer.parseInt(currentNumber));
                currentNumber = "";
                operators.add(firstColumn.replace(" ", "").charAt(0));
                colOffset += 2;
            } else {
                currentNumber += getNumberFromChunk(chunk);
                colOffset += CHUNK_COLS + 1;
            }
        }

        // Add the last number
        numbers.add(Integer.parseInt(currentNumber));

        return new Result(numbers, operators);
    }

    private static void processInput(final String[] lines) {
        final Result result = getResult(lines);

        int value = result.numbers.remove(0);
        while (!result.operators.isEmpty()) {
            final char operator = result.operators.remove(0);
            final int nextNumber = result.numbers.remove(0);
            if (operator == '+') {
                value += nextNumber;
            }
            if (operator == '-') {
                value -= nextNumber;
            }
            if (operator == '*') {
                value *= nextNumber;
            }
            if (operator == '/') {
                value /= nextNumber;
            }
            if (operator == '^') {
                value = (int) Math.pow(value, nextNumber);
            }
        }

        System.out.println(value);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numInputs; i++) {
            final String[] lines = new String[5];
            for (int j = 0; j < 5; j++) {
                lines[j] = scanner.nextLine();
            }
            processInput(lines);

            if (scanner.hasNext()) {
                scanner.nextLine();
            }
        }
    }
}
