package com.example.musterPruefung.IandO;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {//throws Exeption
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            Map<String, Set<Integer>> concordance = createConcordance(lines);
            System.out.println(concordance);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static Map<String, Set<Integer>> createConcordance(List<String> lines) {
        /**
         * для каждой строки:
         * 1. разбить строку на слова
         * 2. взять слово из массива, полученного на шаге 1)
         * 3. найти номера строк, где встречается слово
         * 4. добавить в результат <word, [множество номеров строк где встречается слово]>
         * 5. повторить действия 2) - 4) для каждого слова
         * 6. если слово повторяется, пропускать его
         */

        Map<String, Set<Integer>> result = new TreeMap<>();

        String text = String.join(" ", lines);
        String[] words = text.split("[\\s\\r\\n]+");

        for (String word : words) {
            if (result.containsKey(word)) {
                continue;
            }
            result.put(word, new HashSet<>());
            for (int i = 0; i < lines.size(); i++) {
                List<String> tokens = Arrays.asList(lines.get(i).split("[\\s\\r\\n]+"));
                if (tokens.contains(word)) {
                    result.get(word).add(i + 1);
                }
            }
        }

        return result;
    }

}