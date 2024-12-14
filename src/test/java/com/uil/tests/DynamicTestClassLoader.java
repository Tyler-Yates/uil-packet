package com.uil.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class DynamicTestClassLoader {
    public static List<String> getClassNamesFromDirectory() throws IOException {
        List<String> classNames = new ArrayList<>();
        final Path projectRoot = findProjectRoot();
        if (projectRoot == null) {
            return Collections.emptyList();
        }
        Path sourceDir = Paths.get(projectRoot.toString(), "src", "main", "java", "com", "uil");

        try (Stream<Path> paths = Files.walk(sourceDir)) {
            paths.filter(path -> path.toString().endsWith(".java"))  // Only .java files
                    .forEach(path -> {
                        // Get the relative path from the src/main/java/com/uil folder and convert to class name
                        String className = sourceDir.relativize(path).toString()
                                .replace(File.separatorChar, '.')
                                .replace(".java", "");
                        classNames.add(className);
                    });
        }

        return classNames;
    }

    // Method to find the project root by looking for the .git directory
    private static Path findProjectRoot() {
        Path currentDir = Paths.get("").toAbsolutePath();
        while (currentDir != null) {
            if (new File(currentDir.toFile(), ".git").exists()) {
                return currentDir; // Return the root if .git directory is found
            }
            currentDir = currentDir.getParent(); // Move to the parent directory
        }
        return null; // Return null if the root is not found
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getClassNamesFromDirectory());
    }
}
