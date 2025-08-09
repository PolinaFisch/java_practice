package com.example.Uebung8.third;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class Main {

    public static void operators() {
        IntBinaryOperator addition = Integer::sum;
        IntBinaryOperator subtraction = (a, b) -> a - b;
        IntBinaryOperator division = (a, b) -> a / b;
        IntBinaryOperator multiplication = (a, b) -> a * b;

        IntUnaryOperator inc = x -> x + 1; // increment
        IntUnaryOperator dec = x -> x - 1; // decrement

        System.out.println("40 + 2 = " + addition.applyAsInt(40, 2) );
        System.out.println("20 - 10 = " + subtraction.applyAsInt(20,10));

        System.out.println("inc(20) = " + inc.applyAsInt(20) );
        System.out.println("dec(20) = " + dec.applyAsInt(20) );

        System.out.println("20 / 4 = " + division.applyAsInt(20,4) );
        System.out.println("20 * 5 = " + multiplication.applyAsInt(20,5) );
    }
}
