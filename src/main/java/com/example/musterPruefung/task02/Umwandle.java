package com.example.musterPruefung.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Umwandle {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("Less than 2 arguments.");
        }
        String inputFile = args[0];
        String outputFile = args[1];
        Files.deleteIfExists(Paths.get(outputFile));

        List<String> lines = readFromFile(inputFile);
        for (String line : lines) {
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'X') {
                    chars[i] = ' ';
                } else if (chars[i] == ' ') {
                    chars[i] = 'X';
                }
            }
            appendToFile(chars, outputFile);
        }
    }

    private static void appendToFile(char[] chars, String outputFile) throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile, true));
        writer.println(new String(chars));
        writer.flush();
        writer.close();
    }


    public static List<String> readFromFile(String inputFile) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        return reader.lines().toList();
    }

}
