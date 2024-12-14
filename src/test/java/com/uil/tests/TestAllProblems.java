package com.uil.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAllProblems {

    private static final String TEST_RESOURCE_DIR = "src/test/resources/data/";

    @ParameterizedTest
    @ValueSource(strings = {"adv00"})
    void testAdvFiles(String advFileName) throws IOException {
        // Read the input and expected output files dynamically
        String inputFilePath = TEST_RESOURCE_DIR + advFileName + ".dat";
        String expectedOutputFilePath = TEST_RESOURCE_DIR + advFileName + "_ans.dat";

        String inputContent = new String(Files.readAllBytes(Paths.get(inputFilePath)));
        String expectedOutputContent = new String(Files.readAllBytes(Paths.get(expectedOutputFilePath)));

        // Call the main method of the corresponding advXX class
        String actualOutput = executeMainMethod(advFileName, inputContent);

        // Assert the output is as expected
        assertEquals(expectedOutputContent, actualOutput);
    }

    // Helper method to execute the main method dynamically
    private String executeMainMethod(String className, String input) throws IOException {
        // Get the class using reflection
        try {
            Class<?> clazz = Class.forName("com.uil." + className);
            java.lang.reflect.Method mainMethod = clazz.getMethod("main", String[].class);
            java.io.ByteArrayOutputStream outStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outStream));

            // Redirect stdin for the input
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            // Invoke the main method
            mainMethod.invoke(null, (Object) new String[]{});

            return outStream.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error executing main method for " + className, e);
        }
    }
}
