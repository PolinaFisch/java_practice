package com.example.chatgpt.generics.task05;

import java.util.List;

public class SwapUtil {

    public static void swap(List<?> list, int i, int j) {
        if (list == null) {
            throw new NullPointerException();
        }

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (i < 0 || i >= list.size() || j < 0 || j >= list.size()) {
            throw new IndexOutOfBoundsException();
        }

        swapHelper(list, i, j);
    }

    private static <T> void swapHelper(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
