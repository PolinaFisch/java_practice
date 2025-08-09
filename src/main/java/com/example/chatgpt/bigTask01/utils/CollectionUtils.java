package com.example.chatgpt.bigTask01.utils;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T> List<T> filter(List<T> src, Predicate<T> pred) {
        return src.stream().filter(pred).collect(Collectors.toList());
    }

    public static <T> T findFirst(List<T> src, Predicate<T> pred) {
        return src.stream().filter(pred).findFirst().orElseThrow(() -> new NoSuchElementException());
    }

    public static <T> void sort(List<T> src, Comparator<T> comp) {
        src.sort(comp);
    }
}
