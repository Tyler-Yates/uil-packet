package com.uil;

import java.util.*;


public class adv06 {
    private static final Set<Character> OPERATORS = Set.of('+', '-', '*', '/', '^');
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

    private static class Chunk {
        char[][] chars = new char[CHUNK_ROWS][CHUNK_COLS];
        int index = 0;

        /**
         * Adds a character to the chunk.
         *
         * @param ch the character to add
         * @return true if the chunk is complete, false otherwise
         */
        public boolean addCharacter(final char ch) {
            int row = index % CHUNK_ROWS;
            int col = index / CHUNK_ROWS;

            chars[row][col] = ch;

            this.index++;

            return this.index >= CHUNK_ROWS * CHUNK_COLS;
        }
    }

    private static int getNumberFromChunk(final Chunk chunk) {
        final String[] chunkValue = new String[CHUNK_ROWS];
        for (int r = 0; r < CHUNK_ROWS; r++) {
            StringBuilder s = new StringBuilder();
            for (int c = 0; c < CHUNK_COLS; c++) {
                s.append(chunk.chars[r][c]);
            }
            chunkValue[r] = s.toString();
        }

        for (int i = 0; i < NUMBERS.size(); i++) {
            final String[] number = NUMBERS.get(i);
            if (Arrays.deepEquals(number, chunkValue)) {
                return i + 1;
            }
        }

        // This should never happen!
        throw new RuntimeException("BAD NUMBER!");
    }

    private static Result getNumbers(final String[] lines) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        Chunk chunk = new Chunk();
        for (int c = 0; c < lines[0].length(); c++) {
            for (int r = 0; r < lines.length; r++) {
                final char ch = lines[r].charAt(c);

                if (OPERATORS.contains(ch)) {
                    operators.add(ch);

                    // Reset the chunk
                    chunk = new Chunk();

                    // Advance the column to skip empty
                    c++;
                }

                final boolean completedChunk = chunk.addCharacter(ch);
                if (completedChunk) {
                    numbers.add(getNumberFromChunk(chunk));
                    chunk = new Chunk();

                    // Advance the column to skip empty
                    c++;
                }
            }
        }

        return new Result(numbers, operators);
    }

    private static void processInput(final String[] lines) {
        System.out.println(getNumbers(lines));
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
        }
    }
}
