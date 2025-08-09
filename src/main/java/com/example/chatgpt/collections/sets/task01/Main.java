package com.example.chatgpt.collections.sets.task01;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class SetUtils {

    /**
     * 1. Объединение: возвращает новый Set, содержащий все элементы из a и из b.
     *
     * @param a первое множество (не null)
     * @param b второе множество (не null)
     * @return новое множество с union(a,b)
     * @throws IllegalArgumentException если a или b == null
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> res = new TreeSet<>(a);
        res.addAll(b);
        return res;
    }


    /**
     * 2. Пересечение: возвращает новый Set из тех элементов, которые есть и в a, и в b.
     *
     * @param a первое множество (не null)
     * @param b второе множество (не null)
     * @return новое множество с intersection(a,b)
     * @throws IllegalArgumentException если a или b == null
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }


    /**
     * 3. Разность: возвращает новый Set из элементов a, которых нет в b.
     *
     * @param a первое множество (не null)
     * @param b второе множество (не null)
     * @return новое множество с difference(a,b)
     * @throws IllegalArgumentException если a или b == null
     */
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("a or b is null");
        }
        Set<T> inter = intersection(a, b);
        Set<T> res = new HashSet<>(a);
        res.removeAll(inter);
        return res;
    }


    /**
     * 4. Симметричная разность: возвращает новый Set элементов,
     * которые есть в a или в b, но не в обоих сразу.
     *
     * @param a первое множество (не null)
     * @param b второе множество (не null)
     * @return новое множество с symmetricDifference(a,b)
     * @throws IllegalArgumentException если a или b == null
     */
    public static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b) {
        Set<T> leftFromA = difference(a,b);
        Set<T> leftFromB = difference(b,a);
        Set<T> res = new HashSet<>();
        res.addAll(leftFromA);
        res.addAll(leftFromB);
        return res;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new LinkedHashSet<>(List.of(1, 2, 3, 4));
        Set<Integer> s2 = new LinkedHashSet<>(List.of(3, 4, 5, 6));

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        System.out.println("union:               " + SetUtils.union(s1, s2));
        // ожидается: [1, 2, 3, 4, 5, 6]

        System.out.println("intersection:        " + SetUtils.intersection(s1, s2));
        // ожидается: [3, 4]

        System.out.println("difference(s1, s2):  " + SetUtils.difference(s1, s2));
        // ожидается: [1, 2]

        System.out.println("difference(s2, s1):  " + SetUtils.difference(s2, s1));
        // ожидается: [5, 6]

        System.out.println("symmDifference:      " + SetUtils.symmetricDifference(s1, s2));
        // ожидается: [1, 2, 5, 6]
    }

}
