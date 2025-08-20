package com.example.chatgpt.sorting.task01;

import java.util.Comparator;
import java.util.List;

public class GenericSort
{
    public static <T> void genericSort(List<T> list, Comparator<? super T> comparator) {

    }

    public static <T extends Comparable<? super T>> void genericSort(List<T> list) {

    }
}
