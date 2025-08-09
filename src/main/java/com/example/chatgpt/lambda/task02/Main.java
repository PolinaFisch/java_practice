package com.example.chatgpt.lambda.task02;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Function<Integer, Integer> square = x -> x * x;  // f(x) = x^2
        Consumer<Integer> printer = x -> System.out.println("Результат: " + x);

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        for (Integer number : numbers) {
            if (isEven.test(number)) {
                Integer sq = square.apply(number);
                printer.accept(sq);
            }
        }
    }

}


