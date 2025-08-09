package com.example.Uebung5.All;

public class Word {
    private final String value;
    private int frequency;

    public Word(String value, int frequency) {
        this.value = value.toLowerCase();
        this.frequency = frequency;
    }

    public String getValue() {
        return value;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %s%n", value, frequency);
    }

    public void increaseFrequency() {
        frequency++;
    }
}
