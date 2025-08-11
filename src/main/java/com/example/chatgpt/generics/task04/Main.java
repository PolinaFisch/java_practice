package com.example.chatgpt.generics.task04;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<Integer> retval = max(List.of(111, 555, 666, 222, 333), Integer::compare);
        assert retval.isPresent();
        int max = retval.get();
        System.out.println(max);
        assert max == 666;

        Optional<String> testString = max(List.of("a", "bb", "ccc", "aa", "bbbbbbbb"), Comparator.comparingInt(String::length));
        assert testString.isPresent();
        String retval2 = testString.get();
        System.out.println(retval2);
        assert retval2.equals("bbbbbbbb");
    }

    public static <T extends Comparable<T>> Optional<T> max(List<T> list) {

        if (list.isEmpty()) {
            return Optional.empty();
        }

        T maxx = list.getFirst();
        for (T el : list) {
            if (maxx.compareTo(el) < 0) {
                maxx = el;
            }
        }
        return Optional.of(maxx);

    }

    public static <T> Optional<T> max(List<? extends T> list, Comparator<? super T> comparator) {
        if (list.isEmpty()) {
            return Optional.empty();
        }

        T maxx = list.getFirst();

        for (T element : list) {
            if (comparator.compare(element, maxx) > 0) {
                maxx = element;
            }
        }

        return Optional.of(maxx);

    }

}
