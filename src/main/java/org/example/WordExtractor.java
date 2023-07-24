package org.example;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordExtractor {
    public static void main(String[] args) {
        // Specify your input and output files here
        String inputFilePath = "mathProblemsUnifiedDataset.txt";
        String outputFilePath = "words.txt";

        try {
            FileReader fileReader = new FileReader(inputFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Using a Set to store words, ensuring uniqueness
            Set<String> words = new HashSet<>();

            // Modified regex to match words with hyphens
            Pattern pattern = Pattern.compile("\\p{L}+(?:-\\p{L}+)*");

            String line = bufferedReader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String word = matcher.group();
                    words.add(word); // add to set
                }
                line = bufferedReader.readLine();
            }

            bufferedReader.close();

            // Write the unique words to the output file
            FileWriter fileWriter = new FileWriter(outputFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(String word: words) {
                bufferedWriter.write(word);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            System.out.println("Words extraction completed. Check the output file.");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file '" + inputFilePath + "'");
        } catch (IOException e) {
            System.out.println("Error reading or writing file");
        }
    }
}
