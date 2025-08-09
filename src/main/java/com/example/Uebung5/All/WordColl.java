package com.example.Uebung5.All;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordColl {

    private final Vector<Word> wordsTable;

    public WordColl(String... sentences) {
        wordsTable = new Vector<>();
        append(sentences);
    }

    public int size() {
        int sum = 0;
        for (Word word : wordsTable) {
            sum += count(word.getValue());
        }
        return sum;
    }

    public int count(String s) {
        Word word = findWord(s);
        return word == null ? 0 : word.getFrequency();
    }

    public Word findWord(String s) {
        for (Word word : wordsTable) {
            if (word.getValue().equalsIgnoreCase(s)) {
                return word;
            }
        }
        return null;
    }

    public void append(String... newSentences) {//dynamische "Array" / belibige viele Variable, Parametern
        Pattern pattern = Pattern.compile("[a-zA-Z]+|,");//............
        for (String newSentence : newSentences) {
            /*
            String[] tokens = newSentence.split("[.\\s]+");
            for (String token : tokens) {
                Word word = findWord(token);
                if (word == null) {
                    wordsTable.add(new Word(token, 1));
                } else {
                    word.increaseFrequency();
                }
            }
            */
            Matcher matcher = pattern.matcher(newSentence);
            while (matcher.find()) {
                String token = matcher.group();
                Word word = findWord(token);
                if (word == null) {
                    wordsTable.add(new Word(token, 1));
                } else {
                    word.increaseFrequency();
                }
            }
        }
    }

    public Word top() {
        int max = 0;
        Word top = null;
        for (Word word : wordsTable) {
            int count = count(word.getValue());
            if (count > max) {
                max = count;
                top = word;
            }
        }
        return top;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%-20s | %s%n", "Word", "count"));
        builder.append("-".repeat(50) + "\n");
        for (Word word : wordsTable) {
            builder.append(word.toString());
        }
        builder.append("-".repeat(50) + "\n");
        builder.append("Total: " + size());
        return builder.toString();
    }

    public static void main(String[] args) {//.sout
        WordColl wordColl = new WordColl("Sentence about something.", "Another sentence about something.");
        wordColl.append("It was shiny today, and here is the sentence.");
        System.out.println(wordColl);
        System.out.println(wordColl.top());
    }
}
