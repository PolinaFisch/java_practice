package Uebung8.first;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void printIntValues(Integer[] values ) {

        List<Integer> list = Arrays.asList(values);

        // Ausgabe aller Werte von values mit forEach
        list.stream().forEach(x -> System.out.println(x));


    }


}
