package com.uil;

import java.util.Scanner;


public class adv05 {
    private static boolean isValid(final char[][] template, final char[][] block, int rowOffset, int colOffset) {
        for (int r = 0; r < template.length; r++) {
            for (int c = 0; c < template[r].length; c++) {
                // Check that the block has this position first
                if (r > block.length || c > block[r].length) {
                    return false;
                }

                final char templateChar = template[r][c];
                // Star means anything counts
                if (templateChar == '*') {
                    continue;
                }

                final char blockChar = block[r + rowOffset][c + colOffset];
                if (blockChar != templateChar) {
                    return false;
                }
            }
        }

        return true;
    }

    private static char[][] rotateBlock(final char[][] block) {
        final int blockRowCount = block.length;
        final int blockColCount = block[0].length;

        // We swap rows and columns
        char[][] rotatedBlock = new char[blockColCount][blockRowCount];

        for (int r = 0; r < blockRowCount; r++) {
            for (int c = 0; c < blockColCount; c++) {
                final char ch = block[r][c];

                rotatedBlock[blockColCount - c - 1][r] = ch;
            }
        }

        return rotatedBlock;
    }

    private static void processBlock(final char[][] template, char[][] block) {
        for (int i = 0; i < 4; i++) {
            for (int rowOffset = 0; rowOffset <= block.length - template.length; rowOffset++) {
                for (int colOffset = 0; colOffset <= block[0].length - template[0].length; colOffset++) {
                    if (isValid(template, block, rowOffset, colOffset)) {
                        System.out.println("VALID");
                        return;
                    }
                }
            }

            block = rotateBlock(block);
        }

        System.out.println("INVALID");
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String firstLine = scanner.nextLine();
        final String[] firstLineParts = firstLine.split(" ");
        int templateRows = Integer.parseInt(firstLineParts[0]);
        int templateCols = Integer.parseInt(firstLineParts[1]);

        char[][] template = new char[templateRows][templateCols];
        for (int r = 0; r < templateRows; r++) {
            final String line = scanner.nextLine();
            for (int c = 0; c < templateCols; c++) {
                template[r][c] = line.charAt(c);
            }
        }

        final int numBlocks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numBlocks; i++) {
            final String blockFirstLine = scanner.nextLine();
            final String[] blockFirstLineParts = blockFirstLine.split(" ");
            final int blockRows = Integer.parseInt(blockFirstLineParts[0]);
            final int blockCols = Integer.parseInt(blockFirstLineParts[1]);
            char[][] block = new char[blockRows][blockCols];
            for (int r = 0; r < blockRows; r++) {
                final String line = scanner.nextLine();
                for (int c = 0; c < blockCols; c++) {
                    block[r][c] = line.charAt(c);
                }
            }

            processBlock(template, block);
        }
    }
}
