package org.example;

import java.io.*;
import java.util.*;

public class SplitBySpace {

    public static void main(String[] args) {
        String inputFilePath = "extractWords.txt";  // Change these to the desired file paths
        String outputFilePath = "output.txt";

        try {
            extractWords(inputFilePath, outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void extractWords(String inputFilePath, String outputFilePath) throws IOException {
        // Use a set to store unique words in lowercase
        Set<String> words = new HashSet<>();

        // Create a file object for the input file
        File inputFile = new File(inputFilePath);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        // Read the input file line by line
        String line;
        while ((line = reader.readLine()) != null) {
            // Split the line into words using space as delimiter, and convert to lowercase
            for (String word : line.split("\\s+")) {
                words.add(word.toLowerCase());
            }
        }

        // Close the input file reader
        reader.close();

        // Write the unique words to the output file
        File outputFile = new File(outputFilePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        for (String word : words) {
            writer.write(word);
            writer.newLine();
        }

        // Close the output file writer
        writer.close();
    }
}
