package com.example.chatgpt.generics.task01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubles = new ArrayList<>();
        doubles.add(1.1);
        doubles.add(2.2);

        System.out.println(sumList(ints));
        System.out.println(sumList(doubles));
    }

    public static double sumList(List<? extends Number> list) {
        double sum = 0.0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum;
    }
}


