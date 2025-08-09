package com.example.Uebung8.seventh;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testLambdaExpressions();
    }

    public static void testLambdaExpressions() {
        Integer[] values = { 2, 9, 5, 0, 3, 7, 1, 4, 8, 6 };

        // display original values
        System.out.printf("Original values: %s%n", Arrays.asList(values));

        // Ausgabe aller Werte von values in aufsteigender Reihenfolge
        System.out.println("Sorted values: " + Arrays.stream(values).sorted().toList());

        // Ausgabe aller Werte in values, die größer als 4 sind
        System.out.println("Values greater than 4: " + Arrays.stream(values).filter(x-> x>4).toList());

        // Filtern von allen Werten in values, die größer als 4 sind, und

        System.out.println("Sorted values greater than 4: " + Arrays.stream(values).sorted().filter(x -> x > 4).toList());

        // sortierte diese anschließend

        System.out.println("Values greater than 4 (ascending with streams): " + Arrays.stream(values).filter(x -> x > 4).sorted().toList());

    }
}

