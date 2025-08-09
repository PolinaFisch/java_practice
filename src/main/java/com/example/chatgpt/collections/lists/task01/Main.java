package com.example.chatgpt.collections.lists.task01;

//List.add /

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 2, 4));
        List<Integer> list2 = List.of(5, 6, 2);

        System.out.println("merge:           " + ListUtils.merge(list1, list2));
        // Ожидается: [1, 2, 3, 2, 4, 5, 6, 2]

        System.out.println("removeDuplicates: " + ListUtils.removeDuplicates(list1));
        // Ожидается: [1, 2, 3, 4]

        System.out.println("subList(1,4):     " + ListUtils.subList(list1, 1, 4));
        // Ожидается: [2, 3, 2]

        List<Integer> rot = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ListUtils.rotateRight(rot, 2);
        System.out.println("rotateRight(2):  " + rot);
        // Ожидается: [4, 5, 1, 2, 3]

        LinkedList<Integer> linked = ListUtils.toLinkedList(list2);
        System.out.println("toLinkedList:    " + linked.getClass().getSimpleName() + " " + linked);
        // Ожидается: LinkedList [5, 6, 2]
    }

}


class ListUtils {

    /**
     * 1. Объединить два списка в один, сохраняя порядок элементов.
     */
    public static <T> List<T> merge(List<T> a, List<T> b) {

        List<T> res = new ArrayList<>(a); //Констурктор копирования
        res.addAll(b);
        return res;
    }

    /**
     * 2. Удалить дубликаты, сохраняя только первое появление каждого элемента.
     */
    public static <T> List<T> removeDuplicates(List<T> source) {
        List<T> res = new ArrayList<>();
        for (T el : source) {
            if (!res.contains(el)) {
                res.add(el);
            }
        }
        return res;
    }

    /**
     * Возвращает порцию списка
     *
     * @param source исходный список
     * @param from   индекс начала отрезка
     * @param to     индекс конца отрезка
     * @param <T>
     * @return - сегмент списка
     */
    public static <T> List<T> subList(List<T> source, int from, int to) {
        return source.subList(from, to);
    }

    /**
     * 4. Повернуть список вправо на k позиций (циклически).
     */
    // [1, 2, 3, 4, 5, 6, 7]    --->     [5, 6, 7, 1, 2, 3, 4]
    public static <T> void rotateRight(List<T> list, int k) {
        var first = new ArrayList<>(list.subList(list.size() - k, list.size()));
        var second = new ArrayList<>(list.subList(0, list.size() - k));
        list.clear();
        list.addAll(first);
        list.addAll(second);
    }

    /**
     * 5. Преобразовать любой `List<T>` в `LinkedList<T>`.
     */
    public static <T> LinkedList<T> toLinkedList(List<T> source) {
        return new LinkedList<T>(source);
    }
}
