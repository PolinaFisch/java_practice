package com.example.chatgpt.generics.HA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        //List<Integer> → List<Number>
        List<Integer> one = List.of(12, 33, 66, 1234, 89, 234);
        List<Number> two = new ArrayList<>();
        copy(one, two);
        System.out.println(two);

        //List<String> → List<Object>
        List<String> first = List.of("12", "33", "66", "1234", "89", "234");
        List<Object> second = new ArrayList<>();
        copy(first, second);
        System.out.println(second);

        //List<Double> → List<Double>
        List<Double> oneDouble = List.of(12.0, 33.0, 66.0, 1234.0, 89.0, 234.0);
        List<Double> twoDouble = new ArrayList<>();
        copy(oneDouble, twoDouble);
        System.out.println(twoDouble);


        //Fill with value
        List<String> origFill = new ArrayList<>(Arrays.asList("a", "bb", "cccc", "dfgh", "sdfgh", "cvbnm-g"));
        fill(origFill, "12");
        System.out.println(origFill);

        //Filter
        List<String> origFilter = List.of("a", "bb", "cccc", "dfgh", "sdfgh", "cvbnm-g");
        List<String> newFiltered = filter(origFilter, x -> x.length() > 5);
        System.out.println(newFiltered);

        assert two.equals(List.of(12, 33, 66, 1234, 89, 234));
        assert second.equals(List.of("12", "33", "66", "1234", "89", "234"));
        assert twoDouble.equals(List.of(12.0, 33.0, 66.0, 1234.0, 89.0, 234.0));
        assert origFill.equals(List.of("12", "12", "12", "12", "12", "12"));
        assert newFiltered.equals(List.of("cvbnm-g"));

    }


    public static <T> void copy(List<? extends T> src, List<? super T> dst) {
        dst.addAll(src);
    }

    public static <T> void fill(List<? super T> list, T value) {
        list.replaceAll(x -> value);
    }

    public static <T> List<T> filter(List<? extends T> list, Predicate<? super T> predicate) {
        List<T> res = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                res.add(el);
            }
        }
        return res;
    }


}
